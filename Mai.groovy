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
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }
                    def prendreCoursEchecs() {
                        return "Cours d'échecs commencés"
                    }
                    def envoyerNotification(message) {
                        println("Notification envoyée : $message")
                    }


                    
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
                            [inscrireMarathon(), prendreCoursSalsa(), apprendreCrochet(), faireVoyageFamille(), prendreCoursEchecs()].each {
                                envoyerNotification("Nouvelle activité pour ${params.NOM} en Mai : $it")
                            }
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
