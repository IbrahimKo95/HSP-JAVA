module appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens appli to javafx.fxml;
    exports appli;
}