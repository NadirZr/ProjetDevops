def telechargerPhotosMaison() {
    println "Photos de maison ajoutées "
    return ["photo1.jpg", "photo2.jpg", "photo3.jpg"]
}

def planifierEvenement(nom, date, invites) {
    println("Évènement planifié : $nom le $date avec les invités : $invites")
}

def partagerPhotos(album, personnes) {
    println("Photos de l'album $album partagées avec : $personnes")
}

def rechercherConcerts(ville, mois) {
    println "Concert le mois de $mois dans la ville de $ville"
    return ["Concert de Ice Spice", "Concert de Taylor Swift", "Concert de Central Cee"]
}

def acheterBillets(concert) {
    println("Billets achetés pour le concert : $concert")
    return ["Billet1", "Billet2"]
}

def rechercherSpotsCamping(plage, date) {
    return ["Spot1", "Spot2", "Spot3"]
}

def rechercherIdeesVoyage(continent) {
    println "Continent : $continent"
    return ["Visiter Tokyo", "Visiter Seoul", "Visiter Pekin"]
}

def genererApercu3D(photos, meubles) {
    println("Aperçu 3D généré à partir de photos et meubles")
    return "Apercu3D"
}

def enregistrerApercu(apercu) {
    println("Aperçu enregistré : $apercu")
}

def definirObjectifsSante() {
    return [sport: 2, meditation: 15]
}

def trackerActivites(objectifs) {
    return [sport: 1, meditation: 7] 
}

def verifierObjectifs(objectifs, activites) {
    println("Vérification des objectifs atteints")
    return true
}

def envoyerMessagePositif(personne) {
    println("Message positif envoyé à : $personne")
}

def genererEntreeJournal(nom) {
    return [titre: "Journal de $nom", texte: "Texte de l'entrée du journal"]
}

def enregistrerDonnees(donnees) {
    println("Données enregistrées en base de données : $donnees")
}

def envoyerNotification(message) {
    println("Notification envoyée : $message")
}

def selectionnerMeubles() {
    return ["Canapé", "Table", "Chaise"]
}

def recupererPersonne() {
    return "Jasmine"
}

def prendrePhoto() {
    println "Photos prises"
}

def albumVacances() {
    return "AlbumVacances"
}

def consulterMeteo(plage, date) {
    return "Météo ensoleillée"
}

def planifierItineraire(ideeVoyage) {
    println("Itinéraire planifié pour l'idée de voyage : $ideeVoyage")
    return "ItinérairePlanifié"
}

def progressionCours(duree){
    def dureeFaite = 500 // en minute
    def pourcentageRealisation = (dureeFaite*100) / (duree*60)
    return pourcentageRealisation
}

def statSeanceRespi(duree){
    def dureeFaite = 130 // en minute
    def pourcentageRealisation = (dureeFaite*100) / (duree)
    return pourcentageRealisation
}

def trouverCours(domaine) {
    println "Le domaine choisi est $domaine"
    println "Voici une liste de cours lié au domaine choisi : "
    if (domaine == 'web'){
        println "1.Comprendre le web (6H)\n2.Apprenez à programmer en JavaScript (12H)\n3.Créez votre site web avec HTML5 et CSS3 (15H)"

        return ["1.Comprendre le web (6H)", "2.Apprenez à programmez en JavaScript (12H)","3.Créez votre site web avec HTML5 et CSS3 (15H)" ]
    }else{
        println "Aucun cours trouvé"
    }
    
    
}

def trouverTutoriels(instrument) {
    println "Cours de $instrument choisi"
    println "1.Tuto de Guitare pour débutant(10H)\n, 2.Tuto de Guitare pour niveau intermédiaire(15H)\n, 3.Tuto de Guitare pour niveau avancé(20H)\n"
    return ["1.Tuto de Guitare pour débutant(10H)", "2.Tuto de Guitare pour niveau intermédiaire(15H)", "3.Tuto de Guitare pour niveau avancé(20H)"]
}

def jouerTutoriel(tuto) {
    println("Tutoriel joué : $tuto")
}

def enregistrerPerformance(morceau) {
    println("Performance enregistrée pour le morceau : $morceau")
}

def lancerMeditationGuidee(duree) {
    println("Méditation guidée lancée pour une durée de $duree minutes")
}

def inscrireMarathon() {
    return "Inscription au marathon réussie"
}

def prendreCoursSalsa() {
    return "Cours de salsa commencés"
}

def apprendreCrochet() {
    return "Cours de crochet commencés"
}

def faireVoyageFamille() {
    return "Voyage en famille planifié"
}

def prendreCoursEchecs() {
    return "Cours d'échecs commencés"
}

def moisJanvier(params, objectifs, activites, progression) {
    genererEntreeJournal("${params.NOM}").with {
        enregistrerDonnees(it)
        envoyerNotification("Nouvelle entrée pour ${params.NOM}")
    }
}

def moisFevrier(params, objectifs, activites, progression) {
    selectionnerMeubles().with {
        def photos = telechargerPhotosMaison()
        genererApercu3D(photos, this).with {
            enregistrerApercu(it)
        }
    }
}

def moisMars(params, objectifs, activites, progression) {
    verifierObjectifs(objectifs, activites)
    envoyerNotification("Ta progression : ${progression}")
    envoyerNotification("Le succès est la somme de petits efforts, répétés jour après jour. On croit en toi, tu peux le faire.")
}

def moisAvril(params, objectifs, activites, progression) {
    recupererPersonne().with {
        envoyerMessagePositif(it)
    }
}

def moisMai(params, objectifs, activites, progression) {
    [inscrireMarathon(), prendreCoursSalsa(), apprendreCrochet(), faireVoyageFamille(), prendreCoursEchecs()].each {
        envoyerNotification("Nouvelle activité pour ${params.NOM} en Mai : $it")
    }
}

def moisJuin(params, objectifs, activites, progression) {
    planifierEvenement("Pique-nique", "12/06/2023", ["Maman", "Papa"])
    prendrePhoto()
    partagerPhotos(albumVacances(), ["Mamie", "Papi"])
}

def moisJuillet(params, objectifs, activites, progression) {
    acheterBillets(rechercherConcerts("Paris", "Juillet")[0]).with {
        envoyerNotification("Billets achetés pour le concert : $it")
    }
    prendrePhoto()
    partagerPhotos("concert", ["Fred", "Benjamin"])
}

def moisAout(params, objectifs, activites, progression) {
    [rechercherSpotsCamping("Plage du Prado", "15/08/2023"), consulterMeteo("Plage du Prado", "15/08/2023")].each {
        envoyerNotification(it)
    }
    prendrePhoto()
    partagerPhotos("coucher de soleil", ["Alfred", "Robin"])
}

def moisSeptembre(params, objectifs, activites, progression) {
    planifierItineraire(rechercherIdeesVoyage("Asie")[0])
}

def moisOctobre(params, objectifs, activites, progression) {
    trouverCours("web")
    def choix = "2"
    def duree
    if (choix == '1'){
        choix = 'Comprendre le web'
        duree = 6
    } else if( choix == '2'){
        choix = "Apprenez à programmez en JavaScript"
        duree = 12
    } else if ( choix == '3'){
        choix = "Créez votre site web avec HTML5 et CSS3"
        duree = 15
    }
    if (choix && duree){
        envoyerNotification("Étude en Octobre pour ${params.NOM} : ${choix} avec un durée totale de ${duree}H")
        progressionCours(duree)
        envoyerNotification("${params.NOM} vous avez fait ${progressionCours(duree)}% de votre cours : ${choix}")
    }else{
        println "Une erreur s'est produite."
    }
}

def moisNovembre(params, objectifs, activites, progression) {
    trouverTutoriels("Guitare")[0]
    def choix = '1'
    def duree


    if (choix == '1') {
        choix = 'Tuto pour débutant'
        duree = 10 // en heure
    } else if (choix == '2') {
        choix = "Tuto pour niveau intermédiaire"
        duree = 15 // en heure
    } else if (choix == '3') {
        choix = "Tuto pour niveau avancé"
        duree = 20 // en heure
    }

    if (choix && duree) {
        envoyerNotification("Étude en Novembre pour ${params.NOM} de ${choix} avec une durée totale de ${duree}H")
        progressionCours(duree)
        envoyerNotification("${params.NOM} vous avez fait ${progressionCours(duree)}% de votre cours : ${choix}")
    } else {
        println "Une erreur s'est produite."
    }

    jouerTutoriel(trouverTutoriels("Guitare")[0])
    enregistrerPerformance("Morceau d'Elton John et Stevie Wonder : Finish Line")
}


def moisDecembre(params, objectifs, activites, progression) {
    lancerMeditationGuidee(10)
    envoyerNotification("${params.NOM} vous avez fait ${statSeanceRespi(objectifs.statSeance)}% de votre objectif du mois.")
}

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
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "ecrireJournal" : 31, // nb jours objectif
                        "lireLivre": 1  // nb livres objectif
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "ecrireJournal": 0, 
                        "lireLivre": 0
                    ]

                    def progression_after_15 = [
                        "ecrireJournal" : 15,
                        "lireLivre" : 0
                    ]

                    if (params.MOIS == 'Janvier') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.ecrireJournal = jourActuel 

                            // Appeler fonction mois
                            moisJanvier(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.ecrireJournal>=15 && jourActuel == progression_after_15.ecrireJournal){
                                if (progression_after_15.lireLivre == 1 ){
                                    println "Tu es sur la bonne voie, continue de remplir quotidiennement ton journal et tu atteindras ton objectif du mois."
                                }else{
                                    println "Tu es sur la bonne voie mais n'oublie pas de lire $objectifs.lireLivre livre pour atteindre tous tes objectifs."
                                }
                                
                            }else{
                                if (jourActuel >= 15){
                                    if (progression_after_15.ecrireJournal == 15){
                                        objectifs.ecrireJournal = 20
                                    }else{
                                        objectifs.ecrireJournal = 15
                                    }
                                }else{
                                    progression.ecrireJournal = 5
                                }
                                
                                objectifs.lireLivre = 1 
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Fevrier'){
            when {
                expression { params.MOIS == 'Fevrier' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        // 1: tâche effectuée 0: tâche non effectuée
                        "photosMaison" : 1, 
                        "choixMeubles": 1,
                        "aperçu3D": 1
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "photosMaison" : 0, 
                        "choixMeubles": 0,
                        "aperçu3D": 0
                    ]

                    def progression_after_15 = [
                        "photosMaison" : 1, 
                        "choixMeubles": 1,
                        "aperçu3D": 1
                    ]

                    if (params.MOIS == 'Fevrier') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.photosMaison = 1
                            progression.choixMeubles = 1
                            progression.aperçu3D = 1 

                            // Appeler fonction mois
                            moisFevrier(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.photosMaison>=1){
                                if (progression_after_15.photosMaison== 1 && progression_after_15.choixMeubles== 1 && progression_after_15.aperçu3D== 0){
                                    println "Tu es sur la bonne voie continue comme ça, il te manque que la visualisation 3D de ta maison avec les nouveaux meubles sélectionnés et tu atteindras ton objectif du mois."
                                }else if (progression_after_15.photosMaison== 1 && progression_after_15.choixMeubles== 0 && progression_after_15.aperçu3D== 0){
                                    println "Tu as pris un peu de retard mais n'abandonne pas tu peux encore y arriver, il te manque que la sélection de nouveaux meubles ainsi que la visualisation 3D de ta maison avec les nouveaux meubles sélectionnés et tu atteindras ton objectif du mois."
                                }else if (progression_after_15.photosMaison== 1 && progression_after_15.choixMeubles== 1 && progression_after_15.aperçu3D== 1){
                                    println "Félicitations tu as atteint ton objectif du mois. Ta motivation a été exemplaire, par conséquent nous te proposons un nouvel objectif. Bonne chance"
                                    progression_after_15 = ["contacterUnProfessionnel": 0]
                                    objectifs = ["contacterUnProfessionnel": 0]
                                }
                            }else{
                                progression.aperçu3D = 0

                                objectifs.aperçu3D = 0
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Mars'){
            when {
                expression { params.MOIS == 'Mars' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "faireDuSport" : 8, //Faire du sport chaque week-end (samedi et dimanche) - 8 correspond au nombre de jours de séance dans un mois 
                        "préparerUnRepasSain": 20, // Préparer un repas sain au moins 20 jours dans le mois
                        "nombreDeNotif": 31 // Une notification par jour 
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "faireDuSport" : 0, 
                        "préparerUnRepasSain": 1, 
                        "nombreDeNotif": 1 
                    ]

                    def progression_after_15 = [
                        "faireDuSport" : 4, 
                        "préparerUnRepasSain": 8, 
                        "nombreDeNotif": 15 
                    ]

                    if (params.MOIS == 'Mars') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.faireDuSport = 4
                            progression.préparerUnRepasSain = 8
                            progression.nombreDeNotif = 14

                            // Appeler fonction mois
                            moisMars(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.faireDuSport==4 && progression_after_15.préparerUnRepasSain>=5){
                                if (params.JOUR == 15){
                                    if (progression_after_15.préparerUnRepasSain>=5){
                                        println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                                    }else{
                                        println "Tu es sur la bonne voie mais tu dois manger plus sainement pour atteindre ton objectif du mois."
                                    }
                                }else{
                                    if (progression_after_15.préparerUnRepasSain>=10){
                                        println "Tu es sur la bonne voie continue de manger sainement et de faire de l'exercice et tu atteindras ton objectif du mois."
                                    }else{
                                        progression.préparerUnRepasSain = 0

                                        objectifs.préparerUnRepasSain = 0 
                                        println "Malheureusement je vois que t'auras du mal à réaliser l'un de tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                                    }
                                }
                            }else{
                                if (objectifs.faireDuSport != 4){
                                  objectifs.faireDuSport = 4  
                                }else{
                                    objectifs.faireDuSport = 6
                                }
                                if (objectifs.préparerUnRepasSain != 6){
                                    objectifs.préparerUnRepasSain = 6 
                                }else{
                                    objectifs.préparerUnRepasSain = 8
                                }
                                
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Avril'){
            when {
                expression { params.MOIS == 'Avril' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "messagePositifEnvoye" : 4, // Nombre de message positif envoyé
                        "aiderUnePersonne" : 10, // Nombre de personne qu'on a aidé dans le mois (ce sera une aide quelconque)
                        "partagerUnTemoignageInspirant" : 5 // Nombre de fois qu'on a partagé un témoignage inspirant à une personne
                    ]
                    // Il est tout à fait possible d'aider une personne en partageant un témoignage inspirant avec elle ou en lui envoyant un message positive, mais nous n'allons pas développer ce sujet
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "messagePositifEnvoye" : 0,
                        "aiderUnePersonne" : 0, 
                        "partagerUnTemoignageInspirant" : 0 
                    ]

                    def progression_after_15 = [
                        "messagePositifEnvoye" : 2,
                        "aiderUnePersonne" : 6, 
                        "partagerUnTemoignageInspirant" : 1  
                    ]

                    if (params.MOIS == 'Avril') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.aiderUnePersonne = 6 
                            progression.partagerUnTemoignageInspirant = 2

                            // Appeler fonction mois
                            moisAvril(params, objectifs, activites, progression)
                            progression.messagePositifEnvoye = 1
                        }else{
                            if (progression_after_15.aiderUnePersonne>=5){
                                println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                            }else{
                                objectifs.aiderUnePersonne = 6 
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Mai'){
            when {
                expression { params.MOIS == 'Mai' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "activiteRealisee" : 3, // Nombre d'activités réalisées
                        "nouvelleActiviteConsultee" : 2 // Nombre d'activités consultées
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "activiteRealisee" : 0,
                        "nouvelleActiviteConsultee" : 0
                    ]

                    def progression_after_15 = [
                        "activiteRealisee" : 2,
                        "nouvelleActiviteConsultee" : 0 
                    ]

                    if (params.MOIS == 'Mai') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.activiteRealisee = 2 
                            progression.nouvelleActiviteConsultee = 0

                            // Appeler fonction mois
                            moisMai(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.activiteRealisee>=2 && progression_after_15.nouvelleActiviteConsultee==1){
                                println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                            }else if(progression_after_15.activiteRealisee>=3 && progression_after_15.nouvelleActiviteConsultee>=2){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.activiteRealisee = 2
                                objectifs.nouvelleActiviteConsultee = 1 
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Juin'){
            when {
                expression { params.MOIS == 'Juin' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "activiteAvecProche" : 3, // Nombre d'activités réalisées avec ses proches
                        "ablumPhotoPartagee" : 3,
                        "invitationEnvoyee" : 2 
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "activiteAvecProche" : 0, 
                        "ablumPhotoPartagee" : 0,
                        "invitationEnvoyee" : 0
                    ]

                    def progression_after_15 = [
                        "activiteAvecProche" : 3, 
                        "ablumPhotoPartagee" : 1,
                        "invitationEnvoyee" : 0  
                    ]

                    if (params.MOIS == 'Juin') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.activiteAvecProche = 3 
                            progression.ablumPhotoPartagee = 1 

                            // Appeler fonction mois
                            moisJuin(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.activiteAvecProche>=2 && progression_after_15.ablumPhotoPartagee >=2 && progression_after_15.invitationEnvoyee>=1){
                                println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                            }else if(progression_after_15.activiteAvecProche>=3 && progression_after_15.ablumPhotoPartagee >=3 && progression_after_15.invitationEnvoyee>=2){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.activiteAvecProche = 2 
                                objectifs.ablumPhotoPartagee = 2
                                objectifs.invitationEnvoyee = 1
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Juillet'){
            when {
                expression { params.MOIS == 'Juillet' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "rechercherConcert" : 5, 
                        "acheterBillets" : 4,
                        "prendrePhotoEtVideoConcert": 1,
                        "partagerPhotoEtVideoConcert" : 4 
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "rechercherConcert" : 0, 
                        "acheterBillets" : 0,
                        "prendrePhotoEtVideoConcert": 0,
                        "partagerPhotoEtVideoConcert" : 0 
                    ]

                    def progression_after_15 = [
                        "rechercherConcert" : 3, 
                        "acheterBillets" : 2,
                        "prendrePhotoEtVideoConcert": 1, 
                        "partagerPhotoEtVideoConcert" : 1   
                    ]

                    if (params.MOIS == 'Juillet') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.rechercherConcert = 3 
                            progression.acheterBillets = 2
                            progression.prendrePhotoEtVideoConcert = 1 
                            progression.partagerPhotoEtVideoConcert = 1

                            // Appeler fonction mois
                            moisJuillet(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.rechercherConcert>=3 && progression_after_15.acheterBillets >=2){
                                if (prendrePhotoEtVideoConcert == 0){
                                    println "Tu es sur la bonne voie pour atteindre tous tes objectifs du mois mais n'oublie pas de prendre des photos à ton prochain concert et de les partager avec tes proches."
                                } else if (progression_after_15.prendrePhotoEtVideoConcert == 1 && progression_after_15.partagerPhotoEtVideoConcert == 0){
                                    println "Tu es sur la bonne voie pour atteindre tous tes objectifs du mois mais n'oublie pas de partager tes expériences avec un proche."
                                } else {
                                    println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                                }
                                
                            }else if(progression_after_15.rechercherConcert>=5 && progression_after_15.acheterBillets >=4 && progression_after_15.partagerPhotoEtVideo>=4){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.rechercherConcert = 3 
                                objectifs.acheterBillets = 2
                                objectifs.partagerPhotoEtVideo = 2
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Aout'){
            when {
                expression { params.MOIS == 'Aout' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "rechercherSpotPourCamper" : 3, 
                        "consulterMeteo" : 1,
                        "prendrePhotoCoucherSoleil" : 1,
                        "partagerPhotoCoucherSoleil": 1
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "rechercherSpotPourCamper" : 0, 
                        "consulterMeteo" : 0,
                        "prendrePhotoCoucherSoleil" : 0,
                        "partagerPhotoCoucherSoleil": 0
                    ]

                    def progression_after_15 = [
                        "rechercherSpotPourCamper" : 3, 
                        "consulterMeteo" : 1,
                        "prendrePhotoCoucherSoleil" : 1,
                        "partagerPhotoCoucherSoleil": 1   
                    ]

                    if (params.MOIS == 'Aout') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.rechercherSpotPourCamper = 3 // Nombre de spot trouvé pour un lieu à une date souhaité
                            progression.consulterMeteo = 1 //Consulter la meteo d'un lieu à une date souhaité 
                            progression.prendrePhotoCoucherSoleil = 1 // Nombre de photo prise du coucher du soleil
                            progression.partagerPhotoCoucherSoleil = 1 // Nombre de photo partagée du coucher du soleil


                            // Appeler fonction mois
                            moisAout(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.rechercherSpotPourCamper>=3 && progression_after_15.consulterMeteo >=1){
                                if (progression_after_15.prendrePhotoCoucherSoleil == 0){
                                    println "Tu es sur la bonne voie pour atteindre tous tes objectifs du mois mais n'oublie pas de prendre des photos à ta prochaine escapade et de les partager avec tes proches."
                                } else if (progression_after_15.prendrePhotoCoucherSoleil == 1 && progression_after_15.partagerPhotoCoucherSoleil == 0){
                                    println "Tu es sur la bonne voie pour atteindre tous tes objectifs du mois mais n'oublie pas de partager tes expériences avec un proche."
                                } else {
                                    println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                                }
                            }else if(progression_after_15.rechercherSpotPourCamper>=3 && progression_after_15.consulterMeteo >=1 && progression_after_15.partagerPhotoCoucherSoleil>=1 && progression_after_15.partagerPhotoCoucherSoleil>=1){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.rechercherSpotPourCamper = 2 
                                objectifs.consulterMeteo = 1
                                objectifs.partagerPhotoCoucherSoleil = 0
                                objectifs.prendrePhotoCoucherSoleil = 0
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Septembre'){
            when {
                expression { params.MOIS == 'Septembre' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "rechercherSpotPourCamper" : 3, 
                        "consulterMeteo" : 1,
                        "prendrePhotoCoucherSoleil" : 1,
                        "partagerPhotoCoucherSoleil": 1
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "rechercherSpotPourCamper" : 0, 
                        "consulterMeteo" : 0,
                        "prendrePhotoCoucherSoleil" : 0,
                        "partagerPhotoCoucherSoleil": 0
                    ]

                    def progression_after_15 = [
                        "rechercherSpotPourCamper" : 3, 
                        "consulterMeteo" : 1,
                        "prendrePhotoCoucherSoleil" : 1,
                        "partagerPhotoCoucherSoleil": 1   
                    ]

                    if (params.MOIS == 'Septembre') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.rechercherSpotPourCamper = 3 // Nombre de spot trouvé pour un lieu à une date souhaité
                            progression.consulterMeteo = 1 //Consulter la meteo d'un lieu à une date souhaité 
                            progression.prendrePhotoCoucherSoleil = 1 // Nombre de photo prise du coucher du soleil
                            progression.partagerPhotoCoucherSoleil = 1 // Nombre de photo partagée du coucher du soleil


                            // Appeler fonction mois
                            moisSeptembre(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.rechercherSpotPourCamper>=3 && progression_after_15.consulterMeteo >=1 && progression_after_15.prendrePhotoCoucherSoleil == 0 && progression_after_15.partagerPhotoCoucherSoleil == 0){
                                if (progression_after_15.prendrePhotoCoucherSoleil == 0){
                                    println "Tu es sur la bonne voie pour atteindre tous tes objectifs du mois mais n'oublie pas de prendre des photos à ta prochaine escapade et de les partager avec tes proches."
                                } else if (progression_after_15.prendrePhotoCoucherSoleil == 1 && progression_after_15.partagerPhotoCoucherSoleil == 0){
                                    println "Tu es sur la bonne voie pour atteindre tous tes objectifs du mois mais n'oublie pas de partager tes expériences avec un proche."
                                } else {
                                    println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                                }
                            }else if(progression_after_15.rechercherSpotPourCamper>=3 && progression_after_15.consulterMeteo >=1 && progression_after_15.partagerPhotoCoucherSoleil>=1 && progression_after_15.partagerPhotoCoucherSoleil>=1){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.rechercherSpotPourCamper = 2 
                                objectifs.consulterMeteo = 1
                                objectifs.partagerPhotoCoucherSoleil = 0
                                objectifs.prendrePhotoCoucherSoleil = 0
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Octobre'){
            when {
                expression { params.MOIS == 'Octobre' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "coursTrouves" : 4, // Nombre de cours minimum à choisir 
                        "coursInscrit" : 3, // Nombre de cours minimum où s'inscrire
                        "dureeMinimum": 2400 //en minutes (10h pour chaque cours, pour total de 4 cours minimum ou l'équivalent avec moins ou plus de cours)  
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "coursTrouves" : 0, 
                        "coursInscrit" : 0,
                        "dureeMinimum": 0
                    ]

                    def progression_after_15 = [
                        "coursTrouves" : 5,  
                        "coursInscrit" : 2 ,
                        "dureeMinimum": 500    
                    ]

                    if (params.MOIS == 'Octobre') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.coursTrouves = 5 
                            progression.coursInscrit = 2
                            progression.dureeMinimum = 500 

                            // Appeler fonction mois
                            moisOctobre(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.coursTrouves>=2 && progression_after_15.coursInscrit >=2){
                                if (progression_after_15.dureeMinimum < 1200){
                                    println "Si tu veux atteindre tes objectifs du mois tu devras suivre plus de cours."
                                } else {
                                    println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                                }
                            }else if(progression_after_15.coursTrouves>=4 && progression_after_15.coursInscrit >=3 && progression_after_15.dureeMinimum>=2400){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.coursTrouves = 2 
                                objectifs.coursInscrit = 1
                                objectifs.dureeMinimum = 1000
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Novembre'){
            when {
                expression { params.MOIS == 'Novembre' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "coursPris" : 3, // Nombre de cours minimum à prendre dans le mois (bien sûr il s'exercera également tout seul chez lui)
                        "nbDeChansonJoueeEnCover" : 2, // Nombre de chanson minimum jouer en cover
                        "dureeMinimum": 560 //en minutes (20min chaque jours pendant 1 mois)  
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "coursPris" : 0, 
                        "nbDeChansonJoueeEnCover" : 0,
                        "dureeMinimum": 0
                    ]

                    def progression_after_15 = [
                        "coursPris" : 3,  
                        "nbDeChansonJoueeEnCover" : 3 ,
                        "dureeMinimum": 500    
                    ]

                    if (params.MOIS == 'Novembre') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.coursPris = 3
                            progression.nbDeChansonJoueeEnCover = 3
                            progression.dureeMinimum = 600 

                            // Appeler fonction mois
                            moisNovembre(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.coursPris>=2 && progression_after_15.nbDeChansonJoueeEnCover >=1){
                                if (progression_after_15.dureeMinimum < 280){
                                    println "Si tu veux atteindre tes objectifs du mois tu devras suivre plus de cours."
                                } else {
                                    println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                                }
                            }else if(progression_after_15.coursTrouves>=4 && progression_after_15.coursInscrit >=3 && progression_after_15.dureeMinimum>=2400){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.coursPris = 2 
                                objectifs.nbDeChansonJoueeEnCover = 1
                                objectifs.dureeMinimum = 280
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
        stage('Decembre'){
            when {
                expression { params.MOIS == 'Decembre' } 
            }
            steps{
                script{
                    // Initialiser le suivi
                    
                    def objectifs = [
                        "nbDefoisAppliMeditationUtilise" : 5, // Nombre de fois que l'utilisateur doit utiliser une appli de méditation dans le mois
                        "dureeSeance" : 10, // en minutes (durée minimum de chaque séance)
                        "statSeance": 280 // en minutes (10min chaque jour pendant 1 mois)  
                    ]
                    
                    def activites = trackerActivites(objectifs)

                    def progression = [
                        "nbDefoisAppliMeditationUtilise" : 0, 
                        "dureeSeance" : 0,
                        "statSeance": 0
                    ]
                    
                    def progression_after_15 = [
                        "nbDefoisAppliMeditationUtilise" : 2, 
                        "dureeSeance" : 10, 
                        "statSeance": 130    
                    ]

                    if (params.MOIS == 'Decembre') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.nbDefoisAppliMeditationUtilise = 2
                            progression.dureeSeance = 10
                            progression.statSeance = 600 

                            // Appeler fonction mois
                            moisDecembre(params, objectifs, activites, progression)
                        }else{
                            if (progression_after_15.nbDefoisAppliMeditationUtilise>=2 && progression_after_15.dureeSeance >=10){
                                if (progression_after_15.statSeance < 140){
                                    println "Chaque respiration profonde est un pas vers la tranquillité intérieure. Consacre quelques instants à nourrir ton esprit, et chaque jour deviendra une bouffée de sérénité."
                                } else {
                                    println "Tu es sur la bonne voie continue comme ça et tu atteindras ton objectif du mois."
                                }
                            }else if(progression_after_15.nbDefoisAppliMeditationUtilise>=5 && progression_after_15.dureeSeance >=10 && progression_after_15.statSeance>=280){
                                println "Félicitation, tu as atteint tous tes objectifs."
                            }else{
                                objectifs.nbDefoisAppliMeditationUtilise = 2 
                                objectifs.statSeance = 100
                                
                                println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajuster pour te permettre de les atteindre. Bonne chance"
                            }
                        }
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }
                }
            }
        }
    }
}

