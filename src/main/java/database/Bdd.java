package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Classe utilitaire pour la gestion de la connexion à la base de données MySQL.
 */
public class Bdd {

    private Connection instance;

    /**
     * Récupère ou crée une instance de connexion à la base de données.
     *
     * @return L'instance de connexion à la base de données.
     * @throws SQLException Si une erreur survient lors de la connexion à la base de données.
     */
    public Connection getInstance() throws SQLException {
        if(this.instance == null){
            // Chargement des variables d'environnement
            Dotenv dotenv = Dotenv.configure().load();

            // Connexion à la base de données en utilisant les informations de connexion fournies dans les variables d'environnement
            this.instance = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dotenv.get("DATABASE_NAME"),
                    dotenv.get("DATABASE_USER"),
                    dotenv.get("DATABASE_PASSWORD"));
            return this.instance;
        }
        else {
            return this.instance;
        }
    }
}
