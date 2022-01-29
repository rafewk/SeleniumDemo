pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git branch: 'cucumber', url: 'https://github.com/rafewk/SeleniumDemo.git'

                bat 'mvn clean test'
            }
        }
    }
}