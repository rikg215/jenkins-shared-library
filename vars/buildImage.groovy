#!/user/bin/env groovy
def call() {
    echo "building docker image..."
    withCredentials([usernamePassword(credentialsId: 'rik215', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t rik215/bootcamp-test:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push rik215/bootcamp-test:jma-2.0'
    }