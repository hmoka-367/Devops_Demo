pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/hemanthmoka/Devops_Demo.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name devops-demo -p 8080:8080 devops-demo:latest'
            }
        }
    }
}
