# Projet de Compilation

## Informations 

Membres :

	  Nathan BARLOY
	  
	  Quentin MERITET

	  Lucas MINE

	  Guillaume VANNESSON
	  

## Utilisation

### Exécution sous Eclipse

- Charger le projet sous Eclipse
- Charger les librairies fournises
- Présicer le chemin du fichier tiger dans le "main.java"
- Exécuter le "main.java"

### Exécution avec microIUP

Une fois le "main.java" exécuté sur eclipse, un fichier "toto.src" est créé. Il faut ensuite l'éxecuter avec le microIUP.

Pour assembler le fichier "toto.src" dans le fichier de code machine "toto.iup" :

```
java -jar microIUP.jar -ass toto.src
```

Pour exécuter en batch le fichier de code machine "toto.iup" :

```
java -jar microIUP.jar -batch toto.iup
```

Pour lancer le simulateur sur interface graphique : 

```
java -jar microIUP.jar -sim
```


