pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
		mvn clean compile package install -DskipTests=true
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
		mvn test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
