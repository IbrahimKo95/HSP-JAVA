package appli.GS;

import appli.BaseController;
import appli.HomeGSController;
import controllers.FicheProduitController;
import controllers.FournisseurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.FicheProduit;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifierFicheProduitController implements Initializable, BaseController<FicheProduit> {

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private TextArea descInput;

    @FXML
    private ToggleGroup nivDangerosite;

    @FXML
    private TextField nomInput;


    private Pane mainPane;

    private FicheProduit ficheProduit;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(FicheProduit object) {
        this.ficheProduit = object;
        setField();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setField() {
        descInput.setText(ficheProduit.getDescription());
        nomInput.setText(ficheProduit.getLibelle());
        nivDangerosite.selectToggle(nivDangerosite.getToggles().get(ficheProduit.getNiv_dangerosite()-1));
    }

    @FXML
    void edit(ActionEvent event) throws IOException, SQLException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        RadioButton selectedRadioButton = (RadioButton) nivDangerosite.getSelectedToggle();
        int radioValue = Integer.parseInt(selectedRadioButton.getText());
        controllers.FicheProduitController ficheProduitController = new FicheProduitController();
        ficheProduitController.edit(nomInput.getText(), descInput.getText(), radioValue, ficheProduit.getId());
        homeGSController.changePaneSide("FichesProduits");
    }
}
