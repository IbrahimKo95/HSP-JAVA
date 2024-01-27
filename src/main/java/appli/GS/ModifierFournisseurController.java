package appli.GS;

import appli.BaseController;
import appli.HomeGSController;
import controllers.FournisseurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Fournisseur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifierFournisseurController implements Initializable, BaseController<Fournisseur> {

    private Fournisseur fournisseur;

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private TextField nomInput;

    private Pane mainPane;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Fournisseur object) {
        this.fournisseur = object;
        setField();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setField() {
        nomInput.setText(fournisseur.getNom());
    }

    @FXML
    void edit(ActionEvent event) throws SQLException, IOException {
        FournisseurController fournisseurController = new FournisseurController();
        fournisseurController.edit(nomInput.getText(), fournisseur.getId());
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("fournisseurs");
    }
}
