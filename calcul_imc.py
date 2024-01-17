import sys

def calculer_imc(poids, taille):
    imc = poids / (taille**2)
    if imc < 18.5:
        message = "Vous êtes en sous-poids. C'est important de bien manger et de rester actif !"
    elif 18.5 <= imc < 25:
        message = "Vous avez un poids normal. Continuez vos bonnes habitudes !"
    elif 25 <= imc < 30:
        message = "Vous êtes en surpoids. Un petit effort pour une alimentation équilibrée et de l'exercice !"
    else:
        message = "Vous êtes en obésité. Parlez à un professionnel de santé pour vous accompagner."
    return imc, message

if __name__ == "__main__":
    if len(sys.argv) != 3:
        sys.exit("Usage: python3 calcul_imc.py <poids en kg> <taille en mètres>")
    poids = float(sys.argv[1])
    taille = float(sys.argv[2])
    imc, message = calculer_imc(poids, taille)
    print(f"Votre IMC est de {imc:.2f}. {message}")
