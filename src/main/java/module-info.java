module appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.dotenv;

    opens appli to javafx.fxml;
    opens appli.GS to javafx.fxml;
    exports appli;
}