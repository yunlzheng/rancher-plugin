node {

  stage ('Checkout') {
    git 'https://github.com/jenkinsci/rancher-plugin.git'
  }

  stage ('Build') {
    sh 'docker pull dgroup/java8-gradle'
    sh 'docker run --rm -v ${WORKSPACE}:/code --workdir /code dgroup/java8-gradle ./gradlew jpl'
  }

}