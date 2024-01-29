package appli.Secretaire;

import appli.BaseController;
import appli.HomeSecretaireController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AjouterPatientController implements BaseController<Void> {

    private Pane mainPane;



    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }
}


