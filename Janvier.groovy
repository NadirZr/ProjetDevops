import groovy.json.JsonBuilder
import groovy.json.JsonSlurper



// Fonction pour sauvegarder une entrée de journal dans un fichier
def sauvegarderEntreeJournal(Map entree) {
   def json = new JsonBuilder(entree).toPrettyString()
   def journalFile = new File(JOURNAL_DIR, "journal-${entree.date.format('yyyyMMdd')}.json")
   journalFile.write(json)
}

// Fonction pour charger une entrée de journal à partir d'un fichier
def chargerEntreeJournal(Date date) {
   def journalFile = new File(JOURNAL_DIR, "journal-${date.format('yyyyMMdd')}.json")
   def jsonText = journalFile.text
   def jsonSlurper = new JsonSlurper()
   def data = jsonSlurper.parseText(jsonText)
   return data
}

// Fonction pour lire toutes les entrées de journal à partir des fichiers
def lireEntriesJournal() {
  def journalFiles = new File(JOURNAL_DIR).listFiles()
  journalFiles.sort { a, b -> b.name <=> a.name } // Tri par ordre décroissant
  journalFiles.each { file ->
     def date = file.name.replaceAll(/^journal-/, '').replaceAll(/.json$/, '')
     def data = chargerEntreeJournal(Date.parse('yyyyMMdd', date))
     println "Date: $date\n${data}\n---"
  }
}

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
    // Chemin vers le répertoire où les entrées de journal seront stockées
def JOURNAL_DIR = "${env.WORKSPACE}/journals"
// Vérifier et créer le répertoire des journaux si nécessaire
 def journalDir = new File(JOURNAL_DIR)
 if (!journalDir.exists()) {
  journalDir.mkdirs()
 }

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
   sauvegarderEntreeJournal(nouvelleEntree)
   enregistrerDonnees(nouvelleEntree)
   envoyerNotification("Nouvelle entrée pour ${params.NOM}")
   lireEntriesJournal()
}
