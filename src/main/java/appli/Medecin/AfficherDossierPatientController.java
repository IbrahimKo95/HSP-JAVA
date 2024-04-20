package appli.Medecin;

import appli.BaseController;
import appli.HomeMedecinController;
import controllers.DossierPatientController;
import controllers.PatientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import models.DossierPatient;
import models.Medecin;
import models.Patient;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;





public class AfficherDossierPatientController implements BaseController<DossierPatient>, Initializable {
    @FXML
    private Label labelTitle;
    @FXML
    private Label labelAdresse;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelNom;

    @FXML
    private Label labelPrenom;

    @FXML
    private Label labelSecu;

    @FXML
    private Label labelTel;
    @FXML
    private Label labelHeure;
    @FXML
    private Label labelDate;
    @FXML
    private Label labelGravite;
    @FXML
    private Label labelSymptome;

    @FXML
    private Button chargeButton;
    @FXML
    private Button chargeButton2;
    @FXML
    private Button soinButton;





    private DossierPatient activeItem;
    private Pane mainPane;



    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane=mainPane;
    }

    @Override
    public void setObject(DossierPatient object) throws SQLException {
        this.activeItem = object;
        if(object.getId_medecin() != 0){
            chargeButton.setVisible(false);

                }
        else {
            chargeButton2.setVisible(false);
        }

        labelTitle.setText("Dossier patient n° "+this.activeItem.getId());
        PatientController patientController = new PatientController();
        Patient patient = patientController.getById(this.activeItem.getId_patient());
        labelNom.setText("Nom: "+ patient.getNom());
        labelPrenom.setText("Prenom: "+patient.getPrenom());
        labelAdresse.setText("Adresse: "+patient.getAdresse());
        labelEmail.setText("Email: "+patient.getEmail());
        labelTel.setText("Tel: "+patient.getTel());
        labelSecu.setText("Num sécurité sociale: "+patient.getNum_secu());
        labelHeure.setText("Heure venue: "+this.activeItem.getHeure_venue());
        labelDate.setText("Date venue:  "+this.activeItem.getDate_venue());
        labelSymptome.setText("Symptomes: "+this.activeItem.getSymptomes());
        labelGravite.setText("Gravité: "+this.activeItem.getGravite());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void takePatient(ActionEvent event) throws SQLException {
        DossierPatientController dossierPatientController = new DossierPatientController();
        HomeMedecinController homeMedecinController = (HomeMedecinController) mainPane.getScene().getUserData();
        Medecin medecin = homeMedecinController.getUtilisateur();
        dossierPatientController.insertId(medecin.getId(),this.activeItem.getId());
        chargeButton.setVisible(false);
        chargeButton2.setVisible(true);
    }
    @FXML
    void noTakePatient(ActionEvent event) throws SQLException {
        DossierPatientController dossierPatientController = new DossierPatientController();
        dossierPatientController.nullId(this.activeItem.getId());
        chargeButton2.setVisible(false);
        chargeButton.setVisible(true);

    }
    @FXML
    void soinPatient(ActionEvent event) throws SQLException, IOException {
        DossierPatientController dossierPatientController = new DossierPatientController();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Soins adapté");
        alert.setHeaderText("Voulez vous faire une ordonnance ou une hospitalisation?");
        alert.setContentText("Choississez une option");

        ButtonType buttonTypeOne = new ButtonType("Ordonnance");
        ButtonType buttonTypeTwo = new ButtonType("Hospitalisation");
        ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            dossierPatientController.conclusion1(this.activeItem.getId());
        } else if (result.get() == buttonTypeTwo) {
            dossierPatientController.conclusion2(this.activeItem.getId());
            HomeMedecinController homeMedecinController = (HomeMedecinController) mainPane.getScene().getUserData();
            homeMedecinController.changePaneSide("Hospitalisation", this.activeItem);
        }

    }

}
