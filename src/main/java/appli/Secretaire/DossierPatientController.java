package appli.Secretaire;

import appli.BaseController;
import appli.HomeGSController;
import appli.HomeSecretaireController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Fournisseur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DossierPatientController implements BaseController<Void> {

    private Pane mainPane;
    private Fournisseur activeItem;
    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button showButton;


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
    void delete(ActionEvent event) {

    }

    @FXML
    void edit(ActionEvent event) {

    }

    @FXML
    void research(ActionEvent event) {

    }

    @FXML
    void showProducts(ActionEvent event) {

    }

}


