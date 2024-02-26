package appli.Medecin;

import appli.BaseController;
import controllers.PatientController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import models.DossierPatient;
import models.Medecin;
import javafx.scene.control.Label;
import models.Patient;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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


    private DossierPatient activeItem;



    @Override
    public void setMainPane(Pane mainPane) throws SQLException {

    }

    @Override
    public void setObject(DossierPatient object) throws SQLException {
        this.activeItem = object;
        labelTitle.setText("Dossier patient n° "+this.activeItem.getId());
        PatientController patientController = new PatientController();
        Patient patient = patientController.getById(this.activeItem.getId_patient());
        labelNom.setText("Nom: "+ patient.getNom());
        labelPrenom.setText("Prenom: "+patient.getPrenom());
        labelAdresse.setText("Adresse: "+patient.getAdresse());
        labelEmail.setText("Email: "+patient.getEmail());
        labelTel.setText("Tel: "+patient.getTel());
        labelSecu.setText("Num sécurité sociale: "+patient.getNumSecu());
        labelHeure.setText("Heure venue: "+this.activeItem.getHeure_venue());
        labelDate.setText("Date venue:  "+this.activeItem.getDate_venue());
        labelSymptome.setText("Symptomes: "+this.activeItem.getSymptomes());
        labelGravite.setText("Gravité: "+this.activeItem.getGravite());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }






}
