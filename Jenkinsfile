pipeline {
  agent {
    node {
      label 'pomt'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'npm install'
      }
    }
  }
}