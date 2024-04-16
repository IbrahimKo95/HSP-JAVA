# RHP-Java

## Description
RHP-Java est un projet Java utilisant JavaFX pour créer une application de gestion hospitalière. Ce projet est conçu pour gérer divers aspects de l'administration et de la gestion dans un environnement médical.

## Dépendances Maven
Le fichier `pom.xml` contient les dépendances Maven utilisées dans le projet. Voici quelques-unes des principales dépendances :

- **JavaFX** : Librairie graphique Java pour la création d'interfaces utilisateur.
- **JUnit 5** : Framework de test unitaire pour Java.
- **MySQL Connector** : Pilote JDBC pour la connexion à une base de données MySQL.
- **Java Dotenv** : Bibliothèque pour la gestion des variables d'environnement.
- **Passay** : Bibliothèque de validation de mots de passe.

## Base de données
Le fichier SQL de la base de données à importer se trouve dans `src/main/java/database/bdd.sql`.

## Comptes par défaut
Voici les comptes par défaut pour différents rôles dans l'application :

- Admin : admin@lprs.fr / adminadmin
- Gestionnaire de stock : i.konate@lprs.fr / test
- Médecin : w.sekouri@lprs.fr / potiron
- Secrétaire : n.goram@lprs.fr / khatirjtm

## Documentation
La documentation complète du projet est accessible depuis le fichier `docs/index.html`.
## Utilisation
Pour exécuter l'application, assurez-vous d'avoir configuré votre environnement de développement avec les dépendances requises et la base de données importée. Ensuite, lancez l'application en utilisant la commande Maven appropriée ou en exécutant la classe principale (HelloApplication).

