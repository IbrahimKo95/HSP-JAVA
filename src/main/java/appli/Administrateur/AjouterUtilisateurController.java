package appli.Administrateur;

import appli.BaseController;
import controllers.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AjouterUtilisateurController implements Initializable, BaseController {

    private Pane mainPane;
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField nomInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField prenomInput;



    @FXML
    private AnchorPane FournisseursPane;
    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Object object) {

    }

    @FXML
    void add(ActionEvent event) throws SQLException {
        UtilisateurController utilisateurController = new UtilisateurController();
        if(!prenomInput.getText().isEmpty() || !nomInput.getText().isEmpty() || !passwordInput.getText().isEmpty() || !emailInput.getText().isEmpty() || !(comboBox.getValue() == null)) {
            utilisateurController.addUser(prenomInput.getText(), nomInput.getText(), passwordInput.getText(), emailInput.getText(), comboBox.getValue());
        } else {
            System.out.println("erreur");
        }
    }

    @FXML
    void generatePassword(ActionEvent event) {
        CharacterRule alphabeticals = new CharacterRule(EnglishCharacterData.Alphabetical);
        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(10, digits, alphabeticals);
        passwordInput.setText(password);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().add("medecin");
        comboBox.getItems().add("secretaire");
        comboBox.getItems().add("gs");
        comboBox.getItems().add("admin");
    }
}
