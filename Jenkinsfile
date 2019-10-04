pipeline {
    agent any
    environment {
        BUILD_TAG = """${sh(
                returnStdout: true,
                script: 'git rev-parse --short HEAD | tr -d "\n"'
            )}"""
    }
    stages {
        stage('Build') {
            steps {
                sh 'docker build -t adithya321/jenkins-tomcat-demo:$BUILD_TAG .'
            }
        }
        stage('Push') {
            steps {
                sh 'docker push adithya321/jenkins-tomcat-demo:$BUILD_TAG'
            }
        }
        stage('Deploy') {
            steps {
                sh 'sed -i -e "s/latest/$BUILD_TAG/g" deployment.yml'
                sh 'kubectl apply -f deployment.yml'
                sh 'kubectl rollout status deploy/tomcat-demo-deployment'
            }
        }
    }
}
