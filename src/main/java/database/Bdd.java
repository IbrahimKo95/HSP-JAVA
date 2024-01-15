package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {
    private Connection instance;

    public Connection getInstance() throws SQLException {
        if(this.instance == null){
            this.instance = DriverManager.getConnection(
                    "jdbc:mysql://avnadmin:AVNS_Ra_VGdFXFfTnEvLhwPz@remote-desktop-manager-remote-desktop-manager.a.aivencloud.com:19165/defaultdb?ssl-mode=REQUIRED");
            return this.instance;
        }
        else {
            return this.instance;
        }
    }
}
