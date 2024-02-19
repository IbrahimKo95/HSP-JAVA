package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Medecin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeMedecinController implements Initializable {
    @FXML
    private Label UsernameLabel;

    @FXML
    private AnchorPane basePane;

    @FXML
    private Button btnAccueil;
    private Medecin utilisateur;

    public HomeMedecinController(Medecin utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UsernameLabel.setText(utilisateur.getPrenom()+" "+utilisateur.getNom());
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/appli/pages/Medecin/DossierPatient.fxml"));
            basePane.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void changePage(ActionEvent event) throws IOException {
        basePane.getChildren().setAll();
        Button button = (Button) event.getSource();
        if(Objects.equals(button.getText(), "Dossier Patient")) {
            changePane("DossierPatient");
        } else if (Objects.equals(button.getText(), "Accueil")) {
            changePane("Accueil");
        } else if (Objects.equals(button.getText(), "Fiches produits")) {
            changePane("FichesProduits");
        }
    }

    public void changePane(String name) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appli/pages/Medecin/"+name+".fxml"));
        Pane pane = loader.load();
        Object controller = loader.getController();
        if (controller instanceof BaseController) {
            BaseController baseController = (BaseController) controller;
            baseController.setMainPane(basePane);
        }

        basePane.getChildren().add(pane);
    }

    public void changePaneSide(String name) throws IOException {
        basePane.getChildren().setAll();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appli/pages/Medecin/"+name+".fxml"));
        Pane pane = loader.load();
        Object controller = loader.getController();
        if (controller instanceof BaseController) {
            BaseController baseController = (BaseController) controller;
            baseController.setMainPane(basePane);
        }
        basePane.getChildren().add(pane);
    }

    public void changePaneSide(String name, Object parameter) throws IOException, SQLException {
        basePane.getChildren().setAll();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appli/pages/Medecin/" + name + ".fxml"));
        Pane pane = loader.load();
        Object controller = loader.getController();

        if (controller instanceof BaseController) {
            BaseController<Object> baseController = (BaseController<Object>) controller;
            baseController.setMainPane(basePane);
            baseController.setObject(parameter);
        }

        basePane.getChildren().add(pane);
    }
}
