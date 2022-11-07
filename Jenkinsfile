pipeline {
    agent any
    stages {
        stage('start job gateway') {
            when {
                changeset "**/gateway/*.*"
                beforeAgent true
            }
            build job: 'jobgateway'
        }
        stage('start job config') {
            when {
                changeset "**/config/*.*"
                beforeAgent true
            }
            build job: 'jobconfig'
        }
        stage('start job registry') {
            when {
                changeset "**/registry/*.*"
                beforeAgent true
            }
            build job: 'jobregistry'
        }

        stage('start job chatservice') {
            when {
                changeset "**/chatservice/*.*"
                beforeAgent true
            }
            build job: 'jobchatservice'
        }

        stage('start job statisticservice') {
            when {
                changeset "**/statisticservice/*.*"
                beforeAgent true
            }
            build job: 'jobstatisticservice'
        }


        stage('start job frontend') {
            when {
                changeset "**/frontend/*.*"
                beforeAgent true
            }
            build job: 'jobfrontend'
        }
    }
}