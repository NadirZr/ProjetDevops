                    def verifierObjectifs(objectifs, activites) {
                        println("Vérification des objectifs atteints")
                        return true
                    }
                    def envoyerNotification(message) {
                        println("Notification envoyée : $message")
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }

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

                    def pythonPath = "python3"
                    def messageEncouragement = "Le succès est la somme de petits efforts, répétés jour après jour. On croit en toi, tu peux le faire."

                    if (params.MOIS == 'Mars') {
                        // Calculer progression en fonction du jour
                        def jourActuel = params.JOUR.toInteger()
                        if (params.JOUR >= '1' && params.JOUR <'15') {

                            progression.faireDuSport = 4
                            progression.préparerUnRepasSain = 8
                            progression.nombreDeNotif = 14

                            // Appeler fonction mois
                            verifierObjectifs(objectifs, activites)
                            envoyerNotification("Ta progression : ${progression}")
                            envoyerNotification("Le succès est la somme de petits efforts, répétés jour après jour. On croit en toi, tu peux le faire.")
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
                        def output = sh(script: "${pythonPath} calcul_imc.py", returnStdout: true).trim()
                        println(output)
                        // Envoyer un message d'encouragement
                        envoyerNotification(messageEncouragement)
                        // Afficher progression
                        println "Objectis à atteindre: $objectifs"    
                        if (jourActuel < 15){
                            println "Progression au $jourActuel $params.MOIS : $progression"
                        } else {
                            println "Progression au $jourActuel $params.MOIS : $progression_after_15"   
                        }
                        
                    }

