pipeline {
    agent any
    stages {

               stage('deploy image') {
                   steps {
                     sshPublisher(publishers: [sshPublisherDesc(configName: 'deployserver',
                     transfers: [sshTransfer(cleanRemote: false, excludes: '',
                     execCommand: '/rechard/home/deploy.sh localhost:8081 admin Harbor12345 broker ${tag}', execTimeout: 120000,
                     flatten: false, makeEmptyDirs: false, noDefaultExcludes: false,
                     patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false,
                     removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false,
                     useWorkspaceInPromotion: false, verbose: false)])
                   }
               }
    }
}