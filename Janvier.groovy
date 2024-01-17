// Paramètres initiaux
def params = [
    "MOIS" : "Janvier",
    "NOM": "Jean",
    "JOUR": 1
]

// Fonction pour générer une entrée de journal avec des métadonnées supplémentaires
def genererEntreeJournal(String nom, String texte, String photos, String videos, Date date, String theme, String humeur) {
    return [
        titre: "Journal de $nom",
        texte: texte,
        photos: photos,
        videos: videos,
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

node {
    // Suspendre l'exécution et demander à l'utilisateur de saisir des informations
    def userInput = input(
        id: 'userInput', message: 'Entrez les détails de votre entrée de journal:',
        parameters: [
            string(name: 'Texte', defaultValue: 'Texte de l\'entrée du journal', description: 'Entrez le texte de votre entrée de journal'),
            string(name: 'Photos', defaultValue: 'photo1.jpg, photo2.jpg', description: 'Entrez les noms des fichiers des photos, séparés par des virgules'),
            string(name: 'Videos', defaultValue: 'video1.mp4, video2.mp4', description: 'Entrez les noms des fichiers des vidéos, séparés par des virgules'),
            string(name: 'Theme', defaultValue: 'Mon Thème', description: 'Entrez le thème de l\'entrée du journal'),
            string(name: 'Humeur', defaultValue: 'Mon Humeur', description: 'Entrez votre humeur pour l\'entrée du journal')
        ]
    )

    // Création et enregistrement d'une nouvelle entrée de journal avec les informations de l'utilisateur
    def nouvelleEntree = genererEntreeJournal(
        params.NOM,
        userInput['Texte'],
        userInput['Photos'],
        userInput['Videos'],
        new Date(),
        userInput['Theme'],
        userInput['Humeur']
    )
    enregistrerDonnees(nouvelleEntree)
    envoyerNotification("Nouvelle entrée pour ${params.NOM}")
}
