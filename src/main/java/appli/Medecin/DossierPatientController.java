package appli.Medecin;

import appli.BaseController;
import appli.HomeGSController;
import appli.HomeMedecinController;
import appli.HomeSecretaireController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import models.DossierPatient;
import models.FicheProduit;
import models.Medecin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class DossierPatientController implements BaseController<Medecin>, Initializable {

    private DossierPatient activeItem;
    @FXML
    private Button showButton;

    @FXML
    private TableColumn<DossierPatient, Integer> id;
    @FXML
    private TableColumn<DossierPatient, LocalDate> date;
    @FXML
    private TableColumn<DossierPatient, Integer> gravite;
    @FXML
    private TableColumn<DossierPatient, LocalTime> heure;
    @FXML
    private TableView<DossierPatient> table;

    @FXML
    private TableColumn<DossierPatient, LocalDate> dateMesDossiers;
    @FXML
    private TableColumn<DossierPatient, Integer> graviteMesDossiers;
    @FXML
    private TableColumn<DossierPatient, LocalTime> heureMesDossiers;
    @FXML
    private TableColumn<DossierPatient, Integer> idMesDossiers;
    @FXML
    private TableView<DossierPatient> tableMesDossiers;


    public void refreshList() throws SQLException {
        controllers.DossierPatientController dossierPatientController = new controllers.DossierPatientController();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date_venue"));
        heure.setCellValueFactory(new PropertyValueFactory<>("heure_venue"));
        gravite.setCellValueFactory(new PropertyValueFactory<>("gravite"));
        ObservableList<DossierPatient> list = FXCollections.observableArrayList(dossierPatientController.getAll());
        table.setItems(list);


        controllers.DossierPatientController MesDossierPatientController = new controllers.DossierPatientController();
        idMesDossiers.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateMesDossiers.setCellValueFactory(new PropertyValueFactory<>("date_venue"));
        heureMesDossiers.setCellValueFactory(new PropertyValueFactory<>("heure_venue"));
        graviteMesDossiers.setCellValueFactory(new PropertyValueFactory<>("gravite"));
        ObservableList<DossierPatient> MesDossierList = FXCollections.observableArrayList(MesDossierPatientController.getByIdMed(medecin.getId()));
        tableMesDossiers.setItems(MesDossierList);


    }

    private Pane mainPane;

    private Medecin medecin;

    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane = mainPane;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setObject(Medecin object) throws SQLException {
        this.medecin = object;
        refreshList();
    }

    @FXML
    void selectItems(MouseEvent event) {
        if(!table.getSelectionModel().getSelectedItems().isEmpty()){
            showButton.setDisable(false);
            this.activeItem = table.getSelectionModel().getSelectedItem();
        }


    }
    @FXML
    void selectItemsMesD(MouseEvent event) {
        if(!tableMesDossiers.getSelectionModel().getSelectedItems().isEmpty()) {
            showButton.setDisable(false);
            this.activeItem = tableMesDossiers.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    void showDossier(ActionEvent event) throws IOException, SQLException{
        HomeMedecinController homeMedecinController = (HomeMedecinController) mainPane.getScene().getUserData();
        homeMedecinController.changePaneSide("AfficherDossierPatient", this.activeItem);

    }
}
