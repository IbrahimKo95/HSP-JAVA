package appli.Secretaire;

import appli.BaseController;
import appli.HomeGSController;
import appli.HomeSecretaireController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import models.FicheProduit;
import models.Fournisseur;
import models.Patient;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class PatientController implements Initializable, BaseController<Void> {

    private Pane mainPane;

    @FXML
    private TableColumn<Patient, String> emailCol;

    @FXML
    private TableColumn<Patient, String> nomCol;

    @FXML
    private TableColumn<Patient, String> numSecuCol;

    @FXML
    private TableColumn<Patient, String> prenomCol;

    @FXML
    private TableView<Patient> table;

    @FXML
    private TableColumn<Patient, Integer> telCol;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controllers.PatientController patientController = new controllers.PatientController();
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        numSecuCol.setCellValueFactory(new PropertyValueFactory<>("num_secu"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        ObservableList<Patient> list = null;
        try {
            list = FXCollections.observableArrayList(patientController.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table.setItems(list);
    }
}


