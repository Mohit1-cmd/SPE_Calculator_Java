pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/Mohit1-cmd/SPE_Calculator_Java_New.git'
        DOCKER_HUB_USERNAME = 'mohit67'
    }

    stages {

        // ---- FIX 1: clean old repo ----
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        // ---- FIX 2: proper checkout ----
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
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', 'docker-hub-credential') {
                        sh "docker tag ${DOCKER_IMAGE_NAME} ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest"
                        sh "docker push ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest"
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
