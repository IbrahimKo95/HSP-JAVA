package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;
public class Bdd {
    private Connection instance;

    public Connection getInstance() throws SQLException {
        if(this.instance == null){
            Dotenv dotenv = null;
            dotenv = Dotenv.configure().load();
            this.instance = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+dotenv.get("DATABASE_NAME"), dotenv.get("DATABASE_USER"), dotenv.get("DATABASE_PASSWORD"));
            return this.instance;
        }
        else {
            return this.instance;
        }
    }
}
