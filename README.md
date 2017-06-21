Jenkins Rancher Plugin
======================

Rancher is an open source software platform that enables organizations to run containers in production. With Rancher, organizations no longer have to build a container services platform from scratch using a distinct set of open source technologies. Rancher supplies the entire software stack needed to manage containers in production.

You can learn more on the [Rancher Website/](http://rancher.com/)

## General information

Jenkins Rancher Plugin Support Deploy or Upgrade Service Instance in Rancher.

### Requirements

* Java8 or Higher
* Jenkins 1.609.1 or Higher
* Rancher should support v2-beta API

### Job Config

> Tips: docker image support all build variable in current job eq: busybox:dev-${BUILD_NUMBER}

Basic config:

![](http://7pn5d3.com1.z0.glb.clouddn.com//snapshots/rancher-plugin/snapshot1.png)

|       variable |         description |       example |
|----------------|---------------------|---------------|
| API Endpoint   | Rancher Account API Endpoint | http://rancher-server/v2-beta |
| AccessKey      | Account API Access Key | F39583DE2EB3DABD28B0 |
| SecretKey      | Account API Secret Key | 2AAHwT3YVXpNT9rMhxSs3egFrwFgKK3c3bYaXK7w |
| Rancher Environment Id | data2 | 1a5558 |
| Service Name | Target Service Name | stack/demo |
| Docker Image | Deploy Image Tag | busybox |

Advance config:

![](http://7pn5d3.com1.z0.glb.clouddn.com//snapshots/rancher-plugin/snapshot2.png)

|       variable |         description |       example |
|----------------|---------------------|---------------|
| Auto Confirm   | auto finish upgrade service  | true |
| Public Ports | ports should export by service | 8080:8080,9090:9090 |
| Environment Variables | service environments | aaa=bbb,ccc=ddd |

## Developing

Start jenkins instance

```
./gradlew server
```

Create jenkins hpi  

```
./gradlew jpi
```

## Changelog

* Create version 0.1.0-SNAPSHOT, support deploy/upgrade service