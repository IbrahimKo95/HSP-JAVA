package appli.Medecin;

import appli.BaseController;
import javafx.scene.layout.Pane;

public class DossierPatientController implements BaseController<Void> {

    private Pane mainPane;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }

}
