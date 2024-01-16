                    def envoyerMessagePositif(personne) {
                        println("Message positif envoyé à : $personne")
                    }
                    def recupererPersonne() {
                        return "Jasmine"
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }

                    
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
                            recupererPersonne().with {
                                envoyerMessagePositif(it)
                            }
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
