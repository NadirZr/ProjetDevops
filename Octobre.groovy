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
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }
                    def progressionCours(duree){
                        def dureeFaite = 500 // en minute
                        def pourcentageRealisation = (dureeFaite*100) / (duree*60)
                        return pourcentageRealisation
                    }
                    
                    def envoyerNotification(message) {
                        println("Notification envoyée : $message")
                    }


                    
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
