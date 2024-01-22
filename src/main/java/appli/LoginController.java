package appli;

import controllers.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.GS;

import java.sql.SQLException;

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
                if(utilisateurController.connexion(emailInput.getText(), mdpInput.getText()).getRole() == "secretaire") {
                    HelloApplication.changeScene("homeSecretaire");
                } else if (utilisateurController.connexion(emailInput.getText(), mdpInput.getText()).getRole() == "medecin"){
                    HelloApplication.changeScene("homeMedecin");
                } else if (utilisateurController.connexion(emailInput.getText(), mdpInput.getText()).getRole() == "admin"){
                    HelloApplication.changeScene("homeAdmin");
                } else {
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
