                    def trouverTutoriels(instrument) {
                        println "Cours de $instrument choisi"
                        println "1.Tuto de Guitare pour débutant(10H)\n, 2.Tuto de Guitare pour niveau intermédiaire(15H)\n, 3.Tuto de Guitare pour niveau avancé(20H)\n"
                        return ["1.Tuto de Guitare pour débutant(10H)", "2.Tuto de Guitare pour niveau intermédiaire(15H)", "3.Tuto de Guitare pour niveau avancé(20H)"]
                    }
                    
                    def jouerTutoriel(tuto) {
                        println("Tutoriel joué : $tuto")
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }
                    def enregistrerPerformance(morceau) {
                        println("Performance enregistrée pour le morceau : $morceau")
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
