package appli.Secretaire;

import appli.BaseController;
import appli.HomeGSController;
import appli.HomeSecretaireController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.DossierPatient;
import models.Fournisseur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class DossierPatientController implements Initializable, BaseController<Void> {

    private Pane mainPane;
    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<DossierPatient, LocalDate> date;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private TableColumn<DossierPatient, Integer> gravite;

    @FXML
    private TableColumn<DossierPatient, LocalTime> heure;

    @FXML
    private TableColumn<DossierPatient, Integer> id;

    @FXML
    private TextField researchBar;

    @FXML
    private Button showButton;

    @FXML
    private TableView<DossierPatient> table;


    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }@FXML
    void add(ActionEvent event) throws IOException, SQLException {
        HomeSecretaireController HomeSecretaireController = (HomeSecretaireController) mainPane.getScene().getUserData();
        HomeSecretaireController.changePaneSide("AjouterDossiersPatients");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controllers.DossierPatientController dossierPatientController = new controllers.DossierPatientController();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date_venue"));
        heure.setCellValueFactory(new PropertyValueFactory<>("heure_venue"));
        gravite.setCellValueFactory(new PropertyValueFactory<>("gravite"));
        ObservableList<DossierPatient> list = null;
        try {
            list = FXCollections.observableArrayList(dossierPatientController.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table.setItems(list);

    }

    @FXML
    void selectItems(MouseEvent event) {

    }
}


