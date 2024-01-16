                    def rechercherSpotsCamping(plage, date) {
                        return ["Spot1", "Spot2", "Spot3"]
                    }
                    def consulterMeteo(plage, date) {
                        return "Météo ensoleillée"
                    }
                    def partagerPhotos(album, personnes) {
                        println("Photos de l'album $album partagées avec : $personnes")
                    }
                    def prendrePhoto() {
                        println "Photos prises"
                    }
                    def envoyerNotification(message) {
                        println("Notification envoyée : $message")
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }

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
                            [rechercherSpotsCamping("Plage du Prado", "15/08/2023"), consulterMeteo("Plage du Prado", "15/08/2023")].each {
                                envoyerNotification(it)
                            }
                            prendrePhoto()
                            partagerPhotos("coucher de soleil", ["Alfred", "Robin"])
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

