package appli.Medecin;

import appli.BaseController;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import models.DossierPatient;
import models.Medecin;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HospitalisationController implements BaseController<DossierPatient>, Initializable {
    private Pane mainPane;

    private Medecin medecin;

    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane = mainPane;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setObject(DossierPatient object) throws SQLException {}
}
