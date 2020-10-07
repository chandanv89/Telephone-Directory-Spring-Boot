pipeline {
    agent any
	options {
		ansiColor('xterm')
	}

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
		sh 'mvn clean compile package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
		sh 'mvn test'
            }
        }
	stage('Install') {
		steps {
			echo 'Installing...'
			sh 'mvn package install -DskipTests'
		}
	}
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
