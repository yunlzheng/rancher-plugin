#!/usr/bin/env python
import logging
import time
import requests
import subprocess
from requests.adapters import HTTPAdapter
from requests.packages.urllib3.util.retry import Retry

XML_TEMPLATE = '''
<?xml version='1.0' encoding='UTF-8'?>
<project>
  <actions/>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties/>
  <scm class="hudson.scm.NullSCM"/>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <triggers/>
  <concurrentBuild>false</concurrentBuild>
  <builders>
    <jenkins.plugins.rancher.RancherBuilder plugin="rancher@1.0.5-SNAPSHOT">
      <environmentId>{project_id}</environmentId>
      <endpoint>http://{host_ip}:8080/v2-beta/</endpoint>
      <credentialId></credentialId>
      <service>test/echo-server</service>
      <image>jmalloc/echo-server</image>
      <confirm>true</confirm>
      <ports></ports>
      <environments></environments>
    </jenkins.plugins.rancher.RancherBuilder>
  </builders>
  <publishers/>
  <buildWrappers/>
</project>
'''.strip()

DOCKER_COMPOSE='''
version: '2'
services:
  echo-server:
    image: jmalloc/echo-server
    ports:
    - 8082:8080
'''.strip()

logging.getLogger().setLevel(logging.DEBUG)
HOST_IP = subprocess.check_output("/sbin/ip route|awk '/default/ { print $3 }'", shell=True).strip()
BASE_URL = "http://%s:8080/" % (HOST_IP)
JENKINS_URL = 'http://%s:8081' % (HOST_IP)

s = requests.Session()
retry = Retry(status_forcelist=(403, 500, 502, 504), total=100, connect=100, backoff_factor=1)
s.mount('http://', HTTPAdapter(max_retries=retry))

class RancherBootstrapper:
    project_id = None
    stack_id = None
    registrationUrl = None

    def wait_for_url(self, url):
        logging.info("Waiting for %s", url)
        s.get(url)

    def create_environment(self):
        url = "%s/v2-beta/projects" % (BASE_URL)
        matching_envs = filter((lambda (x): x['name'] == 'test'), s.get(url).json()['data'])

        if len(matching_envs) > 0:
            self.project_id = matching_envs[0]['id']
            logging.info("Found env %s", self.project_id)
            return

        payload = { 'name': 'test' }
        r = s.post(url, json=payload)
        self.project_id = r.json()['id']
        logging.info("Created env %s", self.project_id)

    def create_stack(self):
        url = "%s/v2-beta/projects/%s/stacks" % (BASE_URL, self.project_id)
        json = s.get(url).json()
        logging.debug("%s", json)
        matching_stacks = filter((lambda (x): x['name'] == 'test'), json['data'])

        if len(matching_stacks) > 0:
            self.stack_id = matching_stacks[0]['id']
            logging.info("Found stack %s", self.stack_id)
            return

        payload = { 'name': 'test', 'dockerCompose': DOCKER_COMPOSE, 'startOnCreate': True }
        r = s.post(url, json=payload)
        self.stack_id = r.json()['id']
        logging.debug("%s", r.json())
        logging.info("Created stack %s", self.stack_id)

    def create_job(self):
        url = "%s/createItem?name=test" % (JENKINS_URL)
        config = XML_TEMPLATE.format(project_id=self.project_id, host_ip=HOST_IP)
        headers = {'Content-Type': 'application/xml'}
        r = s.post(url, data=config, headers=headers)
        logging.debug("%s", r.text)

    def bootstrap(self):
        self.wait_for_url(BASE_URL)
        self.wait_for_url(JENKINS_URL)
        self.create_environment()
        self.create_stack()
        self.create_job()
        self.set_server_endpoint()
        self.get_registration_tokens()
        self.run_agent()

    def set_server_endpoint(self):
        url = "%s/v2-beta/settings/api.host" % (BASE_URL)
        payload = { 'value': ('%s:8080' % (HOST_IP))}
        r = s.put(url, json=payload)
        logging.debug('%s', r.json())

    def get_registration_tokens(self):
        url = "%s/v2-beta/projects/%s/registrationTokens" % (BASE_URL, self.project_id)
        s.post(url)

        payload = { 'state': 'active', 'limit': -1, 'sort': 'name' }

        while True:
            r = s.get(url, params=payload)
            if len(r.json()['data']) > 0:
                break
            time.sleep(10)

        logging.debug("%s", r.json())
        self.registrationUrl = r.json()['data'][0]['registrationUrl']

    def run_agent(self):
        subprocess.call(["/run.sh", self.registrationUrl])

bootstrapper = RancherBootstrapper()
bootstrapper.bootstrap()
