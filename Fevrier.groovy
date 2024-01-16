                    def enregistrerApercu(apercu) {
                        println("Aperçu enregistré : $apercu")
                    }
                    def telechargerPhotosMaison() {
                        println "Photos de maison ajoutées "
                        return ["photo1.jpg", "photo2.jpg", "photo3.jpg"]
                    }
                    def genererApercu3D(photos, meubles) {
                        println("Aperçu 3D généré à partir de photos et meubles")
                        return "Apercu3D"
                    }
                    def selectionnerMeubles() {
                        return ["Canapé", "Table", "Chaise"]
                    }
                    def trackerActivites(objectifs) {
                        return [sport: 1, meditation: 7] 
                    }

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
                            selectionnerMeubles().with {
                                def photos = telechargerPhotosMaison()
                                genererApercu3D(photos, this).with {
                                    enregistrerApercu(it)
                                }
                            }
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
