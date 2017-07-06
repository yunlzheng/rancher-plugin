node {

  stage ('Checkout') {
    git 'https://github.com/yunlzheng/rancher-plugin.git'
  }

  stage ('Build') {
    sh './gradlew build'
  }

}