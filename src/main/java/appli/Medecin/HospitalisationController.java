package appli.Medecin;

import appli.BaseController;
import controllers.ChambresController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.Chambre;
import models.DossierPatient;
import models.Medecin;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HospitalisationController implements BaseController<DossierPatient>, Initializable {
    private Pane mainPane;

    private Medecin medecin;
    private DossierPatient activeItem;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Label labelDossier;

    private int selectedValue = 1;
    private int idChambre;



    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane = mainPane;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChambresController chambresController = new ChambresController();
        try {
            ArrayList<Chambre> chambres = chambresController.getAllEmptyChambre();
            List<Integer> numeros = new ArrayList<>();
            for (Chambre chambre : chambres) {
                numeros.add(chambre.getNumero());
            }
            comboBox.getItems().addAll(numeros);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        comboBox.setOnAction(e -> {
            selectedValue = comboBox.getSelectionModel().getSelectedItem();
            try {
                idChambre =  chambresController.getByNumero(selectedValue);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


    }

    @Override
    public void setObject(DossierPatient object) throws SQLException {
        this.activeItem = object;
        labelDossier.setText("Dossier patient n° "+this.activeItem.getId());

    }

    @FXML
    private ComboBox<Integer> comboBox;

    @FXML
    void test(ActionEvent event) {

    }
    @FXML
    private TextField hours;

    @FXML
    private TextField minutes;

    @FXML
    private TextField secondes;






    @FXML
    void valide(ActionEvent event) throws SQLException {
        controllers.HospitalisationController hospitalisationController = new controllers.HospitalisationController();

        String timeString = hours.getText() + ':' + minutes.getText() +':' + secondes.getText();
        LocalTime localTime = LocalTime.parse(timeString);
        LocalDate dateDebuts = dateDebut.getValue();
        LocalDate dateFins = dateFin.getValue();
        int idDossier = this.activeItem.getId();

       hospitalisationController.valideHospitalisation(dateDebuts,localTime,dateFins,idChambre,idDossier);

    }


}

