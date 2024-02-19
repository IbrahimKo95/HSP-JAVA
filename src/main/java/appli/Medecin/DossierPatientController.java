package appli.Medecin;

import appli.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.DossierPatient;
import models.FicheProduit;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class DossierPatientController implements BaseController<Void>, Initializable {




    @FXML
    private TableColumn<DossierPatient, LocalDate> date;
    @FXML
    private TableColumn<DossierPatient, Integer> id;

    @FXML
    private TableColumn<DossierPatient, String> gravite;

    @FXML
    private TableColumn<DossierPatient, LocalTime> heure;


    @FXML
    private TableView<DossierPatient> table;

    public void refreshList() throws SQLException {
        controllers.DossierPatientController dossierPatientController = new controllers.DossierPatientController();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        gravite.setCellValueFactory(new PropertyValueFactory<>("gravite"));
        ObservableList<DossierPatient> list = FXCollections.observableArrayList(dossierPatientController.getAll());
        table.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            refreshList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Pane mainPane;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }


}
