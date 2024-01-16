                    def rechercherConcerts(ville, mois) {
                        println "Concert le mois de $mois dans la ville de $ville"
                        return ["Concert de Ice Spice", "Concert de Taylor Swift", "Concert de Central Cee"]
                    }
                    
                    def acheterBillets(concert) {
                        println("Billets achetés pour le concert : $concert")
                        return ["Billet1", "Billet2"]
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }
                    def envoyerNotification(message) {
                        println("Notification envoyée : $message")
                    }
                    def prendrePhoto() {
                        println "Photos prises"
                    }
                    def partagerPhotos(album, personnes) {
                        println("Photos de l'album $album partagées avec : $personnes")
                    }

                    
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
                            acheterBillets(rechercherConcerts("Paris", "Juillet")[0]).with {
                                envoyerNotification("Billets achetés pour le concert : $it")
                            }
                            prendrePhoto()
                            partagerPhotos("concert", ["Fred", "Benjamin"])
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
