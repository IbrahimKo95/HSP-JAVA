package appli.Medecin;

import appli.BaseController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import models.DossierPatient;
import models.Fournisseur;
import models.Medecin;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;





public class DossierDuPatient implements BaseController<Medecin>, Initializable {

    private DossierPatient activeItem;



    @Override
    public void setMainPane(Pane mainPane) throws SQLException {

    }

    @Override
    public void setObject(Medecin object) throws SQLException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }






}
