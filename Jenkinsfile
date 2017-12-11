node {

  stage ('Checkout') {
    git 'https://github.com/jenkinsci/rancher-plugin.git'
  }

  stage('Docker Pull') {
    sh 'docker pull dgroup/java8-gradle'
  }

  stage ('Build') {
    sh 'docker run --rm -v ${WORKSPACE}:/code --workdir /code dgroup/java8-gradle ./gradlew jpi'
  }

}