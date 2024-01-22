package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.GS;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeGSController implements Initializable {
    @FXML
    private Label UsernameLabel;

    @FXML
    private AnchorPane basePane;

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
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/appli/pages/GS/Accueil.fxml"));
            basePane.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void changePage(ActionEvent event) throws IOException {
        basePane.getChildren().setAll();
        Button button = (Button) event.getSource();
        if(Objects.equals(button.getText(), "Fournisseurs")) {
            changePane("fournisseurs");
        } else if (Objects.equals(button.getText(), "Accueil")) {
            changePane("Accueil");
        }
    }

    void changePane(String name) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/appli/pages/GS/"+name+".fxml"));
        basePane.getChildren().add(pane);
    }


}
