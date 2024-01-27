package appli.GS;

import appli.BaseController;
import appli.HomeGSController;
import controllers.FournisseurController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Fournisseur;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterFournisseurController implements BaseController<Void> {
    private Pane mainPane;




    @FXML
    private TextField nomInput;

    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }

    @FXML
    void add(ActionEvent event) throws SQLException, IOException {
        FournisseurController fournisseurController = new FournisseurController();
        fournisseurController.add(nomInput.getText());
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("fournisseurs");
    }


}
