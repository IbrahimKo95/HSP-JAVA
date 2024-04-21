package appli.Medecin;

import appli.BaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.Medecin;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DemandeProduitController  implements BaseController<Medecin>, Initializable {
    private Pane mainPane;

    private Medecin medecin;
    @FXML
    private TextField produitDemanderText;

    @FXML
    private TextField quantiteText;

    @FXML
    private TextArea raisonText;

    @FXML
    private Button validerButton;


    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Medecin object) throws SQLException {
            this.medecin=object;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void valide(ActionEvent event) throws SQLException {
        String raison = raisonText.getText();
        int id_medecin = this.medecin.getId();
        int statut = 0;
        controllers.DemandeProduitController demandeProduitController = new controllers.DemandeProduitController();
        demandeProduitController.addDemande(raison,statut,id_medecin);
    }

}
