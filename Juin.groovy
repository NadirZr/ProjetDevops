                    def planifierEvenement(nom, date, invites) {
                        println("Évènement planifié : $nom le $date avec les invités : $invites")
                    }
                    def albumVacances() {
                        return "AlbumVacances"
                    }
                    def prendrePhoto() {
                        println "Photos prises"
                    }
                    def partagerPhotos(album, personnes) {
                        println("Photos de l'album $album partagées avec : $personnes")
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }

                    
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
                            planifierEvenement("Pique-nique", "12/06/2023", ["Maman", "Papa"])
                            prendrePhoto()
                            partagerPhotos(albumVacances(), ["Mamie", "Papi"])
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
