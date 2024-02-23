package appli;

import javafx.scene.layout.Pane;

import java.sql.SQLException;

public interface BaseController<T> {
    void setMainPane(Pane mainPane) throws SQLException;
    void setObject(T object) throws SQLException;
}
