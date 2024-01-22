module appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.dotenv;

    opens appli to javafx.fxml;
    exports appli;
}