node {

  stage ('Checkout') {
    git 'https://github.com/jenkinsci/rancher-plugin.git'
  }

  stage ('Build') {
    sh './gradlew build'
  }

}