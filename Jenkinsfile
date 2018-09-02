pipeline {
	agent any
	stages {
		stage("Compile") {
			steps {
				sh "./gradlew compileJava"
			}
		}
		stage("Unit Test") {
			steps {
				sh "./gradlew test"
			}
		}

		stage("Code Coverage") {
			steps {
				sh "./gradlew jacocoTestReport"
				publishHTML (target: [
					reportDir: 'build/reports/jacoco/test/html',
					reportFiles: 'index.html',
					reportName: "Jacoco Report"
				])
				sh "./gradlew jacocoTestCoverageVerification"
				publishHTML (target: [
					reportDir: 'build/reports/checkstyle',
					reportFiles: 'main.html',
					reportName: "Checkstyle Report"
				])
			}
		}
		stage("static code analysis") {
			steps {
				sh "./gradlew checkstyleMain"
			}
		}
	}
	post {
		always {
			mail to: 'richard@nepoware.com',
			subject: "Jenkins build pipeline: ${currentBuild.fullDisplayName}",
			body: "Your build completed, please check: ${env.BUILD.URL}"
		}
	}
}

