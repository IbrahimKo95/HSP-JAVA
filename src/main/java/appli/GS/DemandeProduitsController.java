package appli.GS;

import appli.BaseController;
import controllers.CommandeProduitController;
import controllers.DemandeProduitController;
import controllers.UtilisateurController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.CommandeProduit;
import models.DemandeProduit;
import models.Utilisateur;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class DemandeProduitsController implements Initializable, BaseController<Void> {

    private Pane mainPane;


    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private TableColumn<DemandeProduit, String> NomCol;

    @FXML
    private TableColumn<DemandeProduit, String> RaisonCol;

    @FXML
    private TextField researchBar;

    @FXML
    private Button statutButton;

    @FXML
    private TableView<DemandeProduit> tableView;

    private DemandeProduit activeItem;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void changeStatut(ActionEvent event) throws SQLException {
        DemandeProduitController demandeProduitController = new DemandeProduitController();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choix un statut");
        alert.setHeaderText("Voulez vous valider ou refuser cette demande ?");
        alert.setContentText("Choississez une option");

        ButtonType buttonTypeOne = new ButtonType("Valider");
        ButtonType buttonTypeTwo = new ButtonType("Refuser");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            demandeProduitController.valider(this.activeItem.getId());
            refreshList();
        } else if (result.get() == buttonTypeTwo) {
            demandeProduitController.refuser(this.activeItem.getId());
            refreshList();
        }
    }

    @FXML
    void edit(ActionEvent event) {

    }

    @FXML
    void research(ActionEvent event) {

    }

    @FXML
    void select(MouseEvent event) {
        if(tableView.getSelectionModel().getSelectedItem() != null){
            statutButton.setDisable(false);
            this.activeItem = tableView.getSelectionModel().getSelectedItem();
        }
    }

    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) throws SQLException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshList();
    }

    public void refreshList() {
        DemandeProduitController demandeProduitController = new DemandeProduitController();
        RaisonCol.setCellValueFactory(cellData -> {

            DemandeProduit demandeProduit = cellData.getValue();
            StringProperty libelleProperty = null;
            libelleProperty = new SimpleStringProperty(demandeProduit.getRaison());
            return libelleProperty;
        });

        NomCol.setCellValueFactory(cellData -> {
            UtilisateurController utilisateurController = new UtilisateurController();
            DemandeProduit demandeProduit = cellData.getValue();
            SimpleStringProperty nomProperty = null;

            try {
                Utilisateur utilisateur = utilisateurController.getById(demandeProduit.getId_medecin());
                nomProperty = new SimpleStringProperty(utilisateur.getPrenom() + " " + utilisateur.getNom());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return nomProperty;
        });

        ObservableList<DemandeProduit> list = null;
        try {
            list = FXCollections.observableArrayList(demandeProduitController.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableView.setItems(list);
    }
}
