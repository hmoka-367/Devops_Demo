pipeline {
    agent any

    environment {
        AWS_ACCESS_KEY_ID = credentials('aws-access-key')
        AWS_SECRET_ACCESS_KEY = credentials('aws-secret-key')
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-repo/devops-demo.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Terraform Init') {
            steps {
                dir('terraform') {
                    sh 'terraform init'
                }
            }
        }

        stage('Terraform Apply') {
            steps {
                dir('terraform') {
                    sh 'terraform apply -auto-approve'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t devops-demo:latest .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name devops-demo -p 8080:8080 devops-demo:latest'
            }
        }
    }
}
