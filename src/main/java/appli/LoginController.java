package appli;

import controllers.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.GS;
import models.Medecin;
import models.Secretaire;
import models.Utilisateur;

import java.sql.SQLException;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField emailInput;

    @FXML
    private Label label_error;

    @FXML
    private PasswordField mdpInput;

    @FXML
    void login(ActionEvent event) throws SQLException {
        if(emailInput.getText().isEmpty() || mdpInput.getText().isEmpty()) {
            label_error.setText("Tous les champs sont requis !");
            label_error.setStyle("-fx-text-fill: red");
        } else {
            UtilisateurController utilisateurController = new UtilisateurController();
            if(utilisateurController.connexion(emailInput.getText(), mdpInput.getText()) != null) {
                Utilisateur utilisateur = utilisateurController.connexion(emailInput.getText(), mdpInput.getText());
                System.out.println(utilisateur.getRole());
                if(Objects.equals(utilisateur.getRole(), "secretaire")) {
                    HelloApplication.changeScene("homeSecretaire", new HomeSecretaireController((Secretaire) utilisateur));
                } else if (Objects.equals(utilisateur.getRole(), "medecin")){
                    HelloApplication.changeScene("homeMedecin", new HomeMedecinController((Medecin) utilisateur));
                } else if (Objects.equals(utilisateur.getRole(), "admin")){
                    HelloApplication.changeScene("homeAdmin", new HomeAdminController(utilisateur));
                } else if (Objects.equals(utilisateur.getRole(), "gs")){
                    HelloApplication.changeScene("homeGS", new HomeGSController((GS) utilisateurController.connexion(emailInput.getText(), mdpInput.getText())));
                }
                System.out.println("connected");
            } else {
                label_error.setText("Email ou mot de passe incorrect !");
                label_error.setStyle("-fx-text-fill: red");
            }
        }
    }
}
