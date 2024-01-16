package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import models.GS;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeGSController implements Initializable {
    @FXML
    private Label UsernameLabel;
    @FXML
    private AnchorPane AccueilPane;

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private Button btnAccueil;

    @FXML
    private Button btnFournisseurs;
    private GS utilisateur;

    public HomeGSController(GS utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        UsernameLabel.setText(utilisateur.getPrenom()+" "+utilisateur.getNom());
    }

    void fermerPane() {
        AccueilPane.setVisible(false);
        FournisseursPane.setVisible(false);

    }

    @FXML
    void changePage1(ActionEvent event) {
        fermerPane();
        AccueilPane.setVisible(true);
    }

    @FXML
    void changePage2(ActionEvent event) {
        fermerPane();
        FournisseursPane.setVisible(true);
    }

}
