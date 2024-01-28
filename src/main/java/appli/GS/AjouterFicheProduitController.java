package appli.GS;

import appli.BaseController;
import appli.HomeGSController;
import controllers.FicheProduitController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AjouterFicheProduitController implements Initializable, BaseController<Void> {


    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private TextArea descInput;

    @FXML
    private ToggleGroup nivDangerosite;

    @FXML
    private TextField nomInput;

    @FXML
    void add(ActionEvent event) throws SQLException, IOException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        RadioButton selectedRadioButton = (RadioButton) nivDangerosite.getSelectedToggle();
        int radioValue = Integer.parseInt(selectedRadioButton.getText());
        FicheProduitController ficheProduitController = new FicheProduitController();
        ficheProduitController.add(nomInput.getText(), descInput.getText(), radioValue, homeGSController.getUtilisateur().getId());
        homeGSController.changePaneSide("FichesProduits");
    }
    private Pane mainPane;
    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
