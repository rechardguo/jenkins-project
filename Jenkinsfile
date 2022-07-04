pipeline {
    agent any
    stages {
             stage('build package') {
                   steps {
                     withAnt(installation: 'ant') {
                        sh 'ant -f /var/jenkins_home/workspace/test2/docker/build-script/build.xml'
                     }
                   }
               }
               stage('build image') {
                   steps {
                       sh 'docker build -t broker:${tag} /var/jenkins_home/workspace/test2/docker/broker'
                   }
               }
               stage('push image') {
                   steps {
                     withCredentials([usernamePassword(credentialsId: '3a5883cf-a31a-4f8b-861d-ced7a7476b3e', passwordVariable: 'userpass', usernameVariable: 'username')]) {
                         sh 'docker login localhost:8081 -u ${username} -p ${userpass}'
                         sh 'docker tag broker:${tag} localhost:8081/repo/broker:${tag}'
                         sh 'docker push localhost:8081/repo/broker:${tag}'
                       }

                   }
               }
               stage('deploy image') {
                   steps {
                     sshPublisher(publishers: [sshPublisherDesc(configName: 'deployserver',
                     transfers: [sshTransfer(cleanRemote: false, excludes: '',
                     execCommand: 'sh /rechard/home/deploy.sh localhost:8081 admin Harbor12345 broker ${tag}', execTimeout: 120000,
                     flatten: false, makeEmptyDirs: false, noDefaultExcludes: false,
                     patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false,
                     removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false,
                     useWorkspaceInPromotion: false, verbose: false)])
                   }
               }
    }
}