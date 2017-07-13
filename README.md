Jenkins Rancher Plugin
======================

[![CircleCI](https://circleci.com/gh/jenkinsci/rancher-plugin.svg?style=svg)](https://circleci.com/gh/jenkinsci/rancher-plugin)

Enables Jenkins to deploy or upgrade Rancher stack service instance

Rancher is an open source software platform that enables organizations to run containers in production. With Rancher, organizations no longer have to build a container services platform from scratch using a distinct set of open source technologies. Rancher supplies the entire software stack needed to manage containers in production.

You can learn more on the [Rancher Website/](http://rancher.com/)

## Features

* Deploy docker image to Rancher 
* Upgrade exist service instance in Rancher
* Support options to finish the upgrade automatically
* Support build environment variable as docker image tag, e.q busybox:${BUILD_NUMBER}

### Potential upcoming features

* provision rancher stack with docker-compose and rancher-compose file

## General information

Jenkins Rancher Plugin Support Deploy or Upgrade Service Instance in Rancher.

## Requirements

### Jenkins

Jenkins version 2.11 or newer is required.

###Rancher

Rancher version 1.2.2 or newer is required.

## Setup

### Install plugin

Install this plugin via the Jenkins plugin manager.
Or Download the latest version of plugin from [releases][https://github.com/jenkinsci/rancher-plugin/releases].

### Create Rancher API Key

1. To enable access to your rancher server, you must create a account api key:
2. Siigin in to rancher server dashboard
3. Select Menu → API
4. Click "Add Account API Key"
5. Give the  api key any name and description you like, e.g "Jenkins"
6. Click the "Create Key"
7. Save the "Access Key" and "Secret Key" any way you like, we will use it later
8. You can now close the dialog 

### Add the Rancher API Key to Jenkins:

1. Navigate to your Jenkins instance
2. Select "Credentials" from the Jenkins sidebar
3. Choose a credentials domain and click "Add Credentials"
4. From the "Kind" drop-down, choose "Username with password"
5. Enter a description for the credential — the actual value is not important
8. Click "OK" to create the credential

![](http://7pn5d3.com1.z0.glb.clouddn.com//snapshots/rancher-plugin/secret_config.png)

## Per-job configuration

### Freestyle job configuration

> Deploy or Upgrade Service Instance

1. Create a new free-style project
2. Ensure. via whatever build stepds you need, tha the Docker image you want to deploy to Rancher will be available in the docker registry
3. Add "Deploy/Upgrade Rancher Service" post-build action
4. Enter the target Rancher Service API endpoint, e.g 'http://rancher-server/v2-beta'
5. Select the credential name from the drop-down list 
6. Enter the target rancher environment id, e.g '1a5558'
7. Enter the target service name, e.g 'stack/service'
8. Enter the docker image name, e.g 'busybox' (image name support current build environment variable like 'busybox:${BUILD_NUMBER}' to support dynamic image tag)
9. Optionally choose "Auto Confirm" to finish the upgrade automatically

![](http://7pn5d3.com1.z0.glb.clouddn.com//snapshots/rancher-plugin/job_config.png)

## Changelog

* store credentials as Secret
* support deploy/upgrade service