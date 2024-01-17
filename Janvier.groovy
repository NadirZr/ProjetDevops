// Fonction pour générer une entrée de journal avec des métadonnées supplémentaires
def genererEntreeJournal(String nom, String texte, String photos, String videos, Date date, String theme, String humeur) {
    return [
        titre: "Journal de $nom",
        texte: texte,
        photos: photos, // Simuler l'ajout de photos par du texte
        videos: videos, // Simuler l'ajout de vidéos par du texte
        date: date,
        theme: theme,
        humeur: humeur
    ]
}

// Fonction pour enregistrer les données (simulée ici par un affichage console)
def enregistrerDonnees(Map donnees) {
    println("Données enregistrées en base de données : $donnees")
}

// Fonction pour envoyer une notification (simulée ici par un affichage console)
def envoyerNotification(String message) {
    println("Notification envoyée : $message")
}

// Paramètres initiaux
def params = [
    "MOIS" : "Janvier",
    "NOM": "Jean",
    "JOUR": 1
]

// Création et enregistrement d'une nouvelle entrée de journal
def nouvelleEntree = genererEntreeJournal(params.NOM, "Voici mon texte de journal.", "Photo de mes vacances", "Vidéo de mon anniversaire", new Date(), "Vacances", "Joyeux")
enregistrerDonnees(nouvelleEntree)
envoyerNotification("Nouvelle entrée pour ${params.NOM}")

// Fonction pour classer les entrées de journal
def classerEntrees(List entrees, String critere) {
    switch (critere) {
        case 'date':
            entrees.sort { it.date }
            break
        case 'theme':
            entrees.sort { it.theme }
            break
        case 'humeur':
            entrees.sort { it.humeur }
            break
    }
}

// Exemple de classement et d'affichage des entrées
def journal = [nouvelleEntree] // Simuler une liste d'entrées
classerEntrees(journal, 'date') // Classer par date
journal.each { println it } // Afficher les entrées
