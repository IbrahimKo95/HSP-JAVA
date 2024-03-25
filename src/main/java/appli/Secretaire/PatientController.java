package appli.Secretaire;

import appli.BaseController;
import appli.HomeGSController;
import appli.HomeSecretaireController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import models.Fournisseur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class PatientController implements BaseController<Void> {

    private Pane mainPane;
    @FXML
    void RedirectToAjoutPatients(ActionEvent event) throws IOException, SQLException {
        HomeSecretaireController homeSecretaireController = (HomeSecretaireController) mainPane.getScene().getUserData();
        homeSecretaireController.changePaneSide("AjouterPatient");
    }

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }


    void add(ActionEvent event) throws IOException, SQLException {
        HomeSecretaireController HomeSecretaireController = (HomeSecretaireController) mainPane.getScene().getUserData();
        HomeSecretaireController.changePaneSide("AjouterPatient");
    }


    @Override
    public void setObject(Void object) {

    }
}


