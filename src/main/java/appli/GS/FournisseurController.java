package appli.GS;

import appli.BaseController;
import appli.HomeGSController;
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
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FournisseurController implements Initializable, BaseController<Void> {

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private ListView<Fournisseur> list;

    @FXML
    private TextField researchBar;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button showButton;

    private Fournisseur activeItem;

    private Pane mainPane;

    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshFournisseur();
    }

    public void refreshFournisseur() {
        controllers.FournisseurController fournisseurController = new controllers.FournisseurController();
        try {
            ObservableList<Fournisseur> listeFournisseur =  FXCollections.observableArrayList(fournisseurController.getAll());
            list.setItems(listeFournisseur);
            list.setCellFactory(param -> new ListCell<Fournisseur>() {
                @Override
                protected void updateItem(Fournisseur item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null || item.getNom() == null) {
                        setText(null);
                    } else {
                        setText(item.getNom());
                    }
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void add(ActionEvent event) throws IOException, SQLException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("AjouterFournisseur");
    }

    @FXML
    void delete(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Vous êtes sur le point de supprimer le fournisseur \""+this.activeItem.getNom()+"\" ");
        alert.setContentText("Etes vous sur de vouloir le supprimer ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            controllers.FournisseurController fournisseurController = new controllers.FournisseurController();
            fournisseurController.delete(activeItem.getId());
            refreshFournisseur();
        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException, SQLException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("ModifierFournisseur", this.activeItem);
    }

    @FXML
    void research(ActionEvent event) throws SQLException {
        controllers.FournisseurController fournisseurController = new controllers.FournisseurController();
        ArrayList<Fournisseur> fournisseurs = fournisseurController.getAll();
        fournisseurs.removeIf(f -> !f.getNom().contains(researchBar.getText()));
        list.getItems().clear();
        ObservableList<Fournisseur> listeFournisseur =  FXCollections.observableArrayList(fournisseurs);
        list.setItems(listeFournisseur);
        list.setCellFactory(param -> new ListCell<Fournisseur>() {
            @Override
            protected void updateItem(Fournisseur item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getNom() == null) {
                    setText(null);
                } else {
                    setText(item.getNom());
                }
            }
        });
    }

    @FXML
    void selectItems(MouseEvent event) {
        if(!list.getSelectionModel().getSelectedItems().isEmpty()){
            editButton.setDisable(false);
            deleteButton.setDisable(false);
            showButton.setDisable(false);
            this.activeItem = list.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    void showProducts(ActionEvent event) throws IOException, SQLException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("Produits", this.activeItem);
    }

}
