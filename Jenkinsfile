pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = credentials('docker-cred')  // The ID of your Jenkins Docker credentials
    }

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

        stage('Docker Login') {
            steps {
                script {
                    // Docker login command using credentials
                    bat """
                    docker login -u ${docker-cred.username} -p ${docker-cred.password}
                    """
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker build -t devops-demo .'
                bat '''
                    for /f "tokens=*" %%i in ('docker ps -a -f "name=devops-demo" --format "{{.ID}}"') do (
                        docker stop %%i
                        docker rm %%i
                    )
                '''
                bat 'docker run -d --name devops-demo -p 8085:80 devops-demo:latest'
                bat 'docker push devops-demo'
            }
        }
    }
}
