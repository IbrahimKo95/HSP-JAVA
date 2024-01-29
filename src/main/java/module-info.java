module appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.dotenv;
    requires passay;

    opens appli to javafx.fxml;
    opens appli.Secretaire to javafx.fxml;
    opens appli.GS to javafx.fxml;
    opens appli.Medecin to javafx.fxml;
    exports appli;
}