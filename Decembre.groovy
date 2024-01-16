                    def envoyerNotification(message) {
                        println("Notification envoyée : $message")
                    }
                    def lancerMeditationGuidee(duree) {
                        println("Méditation guidée lancée pour une durée de $duree minutes")
                    }
                    def statSeanceRespi(duree){
                        def dureeFaite = 130 // en minute
                        def pourcentageRealisation = (dureeFaite*100) / (duree)
                        return pourcentageRealisation
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }

                    
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
                            lancerMeditationGuidee(10)
                            envoyerNotification("${params.NOM} vous avez fait ${statSeanceRespi(objectifs.statSeance)}% de votre objectif du mois.")
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
