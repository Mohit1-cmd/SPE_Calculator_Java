pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/Mohit1-cmd/SPE_Calculator_Java.git'
        DOCKER_HUB_USERNAME = 'mohit67'
    }

    stages {

        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout Source Code') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: "${GITHUB_REPO_URL}",
                        credentialsId: 'github_credentials'
                    ]]
                ])
            }
        }

        stage('Build the Maven Project') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test the Maven project') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Verify JAR Existence') {
            steps {
                sh 'ls -lh target/'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credential') {

                        sh """
                        docker tag ${DOCKER_IMAGE_NAME}:latest ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest
                        docker push ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest
                        """

                    }
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                ansiblePlaybook(
                    playbook: 'deploy.yml',
                    inventory: 'inventory'
                )
            }
        }

    }
}
