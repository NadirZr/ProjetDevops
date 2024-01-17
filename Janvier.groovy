def demanderTexteEntree() {
    return input(message: 'Veuillez entrer le texte de votre entrée de journal', parameters: [textarea(name: 'texte')])
}

def genererEntreeJournal(nom, texte, photos='placeholder_photo', videos='placeholder_video') {
    return [titre: "Journal de $nom", texte: texte, photos: photos, videos: videos]
}

def enregistrerDonnees(donnees) {
    println("Données enregistrées en base de données : $donnees")
}

def trackerActivites(objectifs) {
    return [sport: 1, meditation: 7] 
}

def envoyerNotification(message) {
    println("Notification envoyée : $message")
}

def par = [
    "MOIS" : "Janvier",
    "NOM": "Jean",
    "JOUR": 1
]

def objectifs = [
    "ecrireJournal" : 31,
    "lireLivre": 1
]

def activites = trackerActivites(objectifs)

def progression = [
    "ecrireJournal": 0,
    "lireLivre": 0
]

def progression_after_15 = [
    "ecrireJournal" : 15,
    "lireLivre" : 0
]

def jourActuel = par.JOUR.toInteger()

if (jourActuel >= 1 && jourActuel < 15) {
    progression.ecrireJournal = jourActuel
    def texteEntree = demanderTexteEntree()
    genererEntreeJournal(par.NOM, texteEntree).with {
        enregistrerDonnees(it)
        envoyerNotification("Nouvelle entrée pour ${par.NOM}")
    }
}  else {
        if (progression_after_15.ecrireJournal >= 15 && jourActuel == progression_after_15.ecrireJournal) {
            if (progression_after_15.lireLivre == 1) {
                println "Tu es sur la bonne voie, continue de remplir quotidiennement ton journal et tu atteindras ton objectif du mois."
            } else {
                println "Tu es sur la bonne voie mais n'oublie pas de lire $objectifs.lireLivre livre pour atteindre tous tes objectifs."
            }

        } else {
            if (jourActuel >= 15) {
                if (progression_after_15.ecrireJournal == 15) {
                    objectifs.ecrireJournal = 20
                } else {
                    objectifs.ecrireJournal = 15
                }
            } else {
                progression.ecrireJournal = 5
            }

            objectifs.lireLivre = 1

            println "Malheureusement je vois que t'auras du mal à réaliser tes objectifs. Mais ne t'inquiète pas je les ai réajustés pour te permettre de les atteindre. Bonne chance"
        }
    }

    // Afficher progression
println "Objectifs à atteindre: $objectifs"
if (jourActuel < 15) {
    println "Progression au $jourActuel ${par.MOIS} : $progression"
} else {
    println "Progression au $jourActuel ${par.MOIS} : $progression_after_15"
}
