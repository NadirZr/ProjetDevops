pipeline {
    agent any
    
    parameters {
        choice(name: 'MOIS', choices: ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet','Aout', 'Septembre', 'Octobre','Novembre', 'Decembre'], description: 'Choisissez le mois')
        string(name: 'NOM', defaultValue: 'Jean', description: 'Entrez votre nom')
        choice(name: 'JOUR', choices: ['1', '2', '3', '4', '5', '6', '7','8', '9', '10','11', '12','13', '14', '15', '16', '17', '18', '19','20', '21', '22','23', '24','25','26','27','28','29','30','31'], description: 'Quel est la date du jour ?')
    }

    stages {
        stage('Janvier') {
            when {
            expression { params.MOIS == 'Janvier' } 
            }
            steps {
                script {
                    def jenkinsfilePath = "Janvier.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Fevrier'){
            when {
            expression { params.MOIS == 'Fevrier' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Fevrier.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Mars'){
            when {
            expression { params.MOIS == 'Mars' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Mars.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Avril'){
            when {
            expression { params.MOIS == 'Avril' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Avril.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Mai'){
            when {
            expression { params.MOIS == 'Mai' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Mai.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Juin'){
            when {
            expression { params.MOIS == 'Juin' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Juin.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Juillet'){
            when {
            expression { params.MOIS == 'Juillet' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Juillet.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Aout'){
            when {
            expression { params.MOIS == 'Aout' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Aout.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Septembre'){
            when {
            expression { params.MOIS == 'Septembre' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Septembre.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Octobre'){
            when {
            expression { params.MOIS == 'Octobre' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Octobre.groovy"
                    load jenkinsfilePath
                }
            }
        }
        stage('Novembre'){
            when {
            expression { params.MOIS == 'Novembre' } 
            }
            steps{
                script{
                     def jenkinsfilePath = "Novembre.groovy"
                    load jenkinsfilePath   
                }
            }
        }
        stage('Decembre'){
            when {
            expression { params.MOIS == 'Decembre' } 
            }
            steps{
                script{
                    def jenkinsfilePath = "Decembre.groovy"
                    load jenkinsfilePath
                }
            }
        }
    }
}

