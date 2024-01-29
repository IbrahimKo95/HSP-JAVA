package appli.Secretaire;

import appli.BaseController;
import appli.HomeGSController;
import appli.HomeSecretaireController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import models.Fournisseur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DossierPatientController implements BaseController<Void> {

    private Pane mainPane;
    private Fournisseur activeItem;


    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }@FXML
    void add(ActionEvent event) throws IOException {
        HomeSecretaireController HomeSecretaireController = (HomeSecretaireController) mainPane.getScene().getUserData();
        HomeSecretaireController.changePaneSide("AjouterDossier");
    }



    @FXML
    void edit(ActionEvent event) throws IOException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("ModifierFournisseur", this.activeItem);
    }


}


