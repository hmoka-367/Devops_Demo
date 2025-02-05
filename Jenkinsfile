pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'UserNamePw', url: 'https://github.com/hemanthmoka/Devops_Demo.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Run Docker Container') {
            steps {
                bat 'docker run -d --name devops-demo -p 8080:8080 devops-demo:latest'
            }
        }
    }
}
