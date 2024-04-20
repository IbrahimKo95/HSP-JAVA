package appli;

import controllers.UtilisateurController;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Medecin;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.io.IOException;

public class HelloApplication extends Application {
    /**
     * Représente la page principale
     */
    private static Stage maStage;

    @Override
    public void start(Stage stage) throws IOException {
        maStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        maStage.setTitle("RHP");
        Image applicationIcon = new Image(getClass().getResourceAsStream("/img/icon.png"));
        maStage.getIcons().add(applicationIcon);
        maStage.setScene(scene);
        maStage.setResizable(false);
        maStage.show();
        maStage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Méthode qui permet de changer de Scene sans controller
     * @param fxml Nom du fichier FXML à charger
     */
    public static void changeScene(String fxml) {
        maStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            maStage.setTitle("RHP");
            maStage.setScene(scene);
            maStage.setResizable(false);
            maStage.show();
            maStage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode qui permet de changer de Scene en venant specifier le controller
     * @param fxml Nom du fichier FXML à charger
     * @param controlleur Controlleur associer à la page
     */

    public static void changeScene(String fxml, Object controller) {
        maStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        fxmlLoader.setController(controller);
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());

            // Définissez la UserData avec le contrôleur passé en paramètre
            scene.setUserData(controller);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        maStage.setTitle("RHP");
        maStage.setScene(scene);
        maStage.setResizable(false);
        maStage.show();
        maStage.centerOnScreen();
    }

    public static void newStage(String fxml, Object controller) {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        fxmlLoader.setController(controller);
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setTitle("RHP");
        window.setScene(scene);
        window.showAndWait();
    }

    public static void newStage(String fxml) {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setTitle("RHP");
        window.setScene(scene);
        window.showAndWait();
    }

}