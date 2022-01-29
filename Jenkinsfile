pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/rafewk/SeleniumDemo.git'

                bat 'mvn clean test'
            }
        }
    }
}