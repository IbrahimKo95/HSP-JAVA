package appli;

import javafx.scene.layout.Pane;

public interface BaseController<T> {
    void setMainPane(Pane mainPane);
    void setObject(T object);
}
