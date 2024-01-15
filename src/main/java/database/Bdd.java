package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {
    private Connection instance;

    public Connection getInstance() throws SQLException {
        if(this.instance == null){
            this.instance = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rhp-java", "root", "");
            return this.instance;
        }
        else {
            return this.instance;
        }
    }
}
