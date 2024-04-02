package appli.Secretaire;

import appli.BaseController;
import appli.HomeSecretaireController;
import controllers.DossierPatientController;
import controllers.FicheProduitController;
import controllers.PatientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import models.FicheProduit;
import models.Patient;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AjouterDossierPatientController implements Initializable, BaseController<Void> {

    @FXML
    private ComboBox<Patient> comboBoxPatient;

    @FXML
    private TextField gravite;

    @FXML
    private TextArea symptomes;

    @FXML
    void add(ActionEvent event) throws SQLException {
        DossierPatientController dossierPatientController = new DossierPatientController();
        HomeSecretaireController HomeSecretaireController = (HomeSecretaireController) mainPane.getScene().getUserData();

        dossierPatientController.add(Integer.parseInt(gravite.getText()), symptomes.getText(), HomeSecretaireController.getUtilisateur().getId(), comboBoxPatient.getValue().getId());
    }

    Pane mainPane;
    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) throws SQLException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PatientController patientController = new PatientController();


        comboBoxPatient.setCellFactory(new Callback<ListView<Patient>, ListCell<Patient>>() {
            @Override
            public ListCell<Patient> call(ListView<Patient> param) {
                return new ListCell<Patient>() {
                    @Override
                    protected void updateItem(Patient item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getPrenom() + " " + item.getNom());
                        }
                    }
                };
            }
        });
        comboBoxPatient.setButtonCell(new ListCell<Patient>() {
            @Override
            protected void updateItem(Patient item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getPrenom() + " " + item.getNom());
                }
            }
        });

        try {
            comboBoxPatient.getItems().addAll(patientController.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
