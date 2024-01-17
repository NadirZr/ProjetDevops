pipeline {
    agent any
    parameters {
        string(name: 'Texte', defaultValue: 'Votre texte ici', description: 'Ajoutez le texte de votre journal intime')
        string(name: 'Photos', defaultValue: 'photo1.jpg, photo2.jpg', description: 'Liste des photos séparées par des virgules')
        string(name: 'Videos', defaultValue: 'video1.mp4, video2.mp4', description: 'Liste des vidéos séparées par des virgules')
        string(name: 'Theme', defaultValue: 'Mon Thème', description: 'Le thème de l\'entrée du journal')
        string(name: 'Humeur', defaultValue: 'Mon Humeur', description: 'Votre humeur actuelle')
    }
    stages {
        stage('Creation Entree Journal') {
            steps {
                script {
                    // Utilisation des paramètres pour créer une nouvelle entrée de journal
                    def nouvelleEntree = genererEntreeJournal(
                        params.NOM,
                        params.Texte,
                        params.Photos,
                        params.Videos,
                        new Date(),
                        params.Theme,
                        params.Humeur
                    )
                    enregistrerDonnees(nouvelleEntree)
                    envoyerNotification("Nouvelle entrée pour ${params.NOM}")
                }
            }
        }
    }
}

// Les fonctions restent inchangées
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

def enregistrerDonnees(Map donnees) {
    println("Données enregistrées en base de données : $donnees")
}

def envoyerNotification(String message) {
    println("Notification envoyée : $message")
}
