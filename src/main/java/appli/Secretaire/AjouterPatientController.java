package appli.Secretaire;

import appli.BaseController;
import appli.HomeGSController;
import appli.HomeSecretaireController;
import controllers.FournisseurController;
import controllers.PatientController;
import controllers.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import libs.Mail;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterPatientController implements BaseController<Void> {

    private Pane mainPane;


    @FXML
    private TextField adresseInput;
    @FXML
    private TextField nomInput;
    @FXML
    private TextField emailInput;

    @FXML
    private TextField numsecuInput;

    @FXML
    private TextField prenomInput;

    @FXML
    private TextField telephoneInput;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }
    @FXML
    public void add(ActionEvent event) throws SQLException {
        PatientController PatientController = new PatientController();
        if(!nomInput.getText().isEmpty() || !prenomInput.getText().isEmpty() || !numsecuInput.getText().isEmpty() || !emailInput.getText().isEmpty() || !adresseInput.getText().isEmpty()|| !telephoneInput.getText().isEmpty()) {
            PatientController.add(nomInput.getText(), prenomInput.getText(), numsecuInput.getText(), emailInput.getText(), adresseInput.getText(), telephoneInput.getText());
        } else {
            System.out.println("erreur");
        }

}}


