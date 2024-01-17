def calculer_imc():
    poids = float(input("Quel est votre poids en kilogrammes ? "))
    taille = float(input("Quelle est votre taille en mètres ? "))
    imc = poids / (taille**2)

    if imc < 18.5:
        message = "Vous êtes en sous-poids. C'est important de bien manger et de rester actif !"
    elif 18.5 <= imc < 25:
        message = "Vous avez un poids normal. Continuez vos bonnes habitudes !"
    elif 25 <= imc < 30:
        message = "Vous êtes en surpoids. Un petit effort pour une alimentation équilibrée et de l'exercice !"
    else:
        message = "Vous êtes en obésité. Parlez à un professionnel de santé pour vous accompagner."

    print(f"Votre IMC est de {imc:.2f}. {message}")

calculer_imc()
