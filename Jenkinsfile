node {

  stage ('Checkout') {
    git 'https://github.com/jenkinsci/rancher-plugin.git'
  }

  stage ('Build') {
    sh './gradlew build'
  }

  stage ('Build Plugin') {
    buildPlugin(platforms: ['linux'], jdkVersions: [8])
  }

}