package appli.GS;

import appli.BaseController;
import appli.HelloApplication;
import appli.HomeGSController;
import controllers.CommandeProduitController;
import controllers.FicheProduitController;
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
import models.CommandeConcerne;
import models.CommandeProduit;
import models.Produit;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReapprovisionnementController implements Initializable, BaseController<Void> {

    public Pane mainPane;

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private Button detailsButton;

    @FXML
    private TableColumn<CommandeProduit, Double> PrixTotal;

    @FXML
    private TableColumn<CommandeProduit, String> RaisonCol;


    @FXML
    private Button addButton;


    @FXML
    private Button statutButton;

    @FXML
    private Button editButton;

    @FXML
    private TextField researchBar;

    private CommandeProduit activeItem;

    @FXML
    private TableView<CommandeProduit> tableView;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) throws SQLException {

    }

    @FXML
    void add(ActionEvent event) throws IOException, SQLException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("AjouterReapprovisionnement");
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
            editButton.setDisable(false);
            statutButton.setDisable(false);
            detailsButton.setDisable(false);
            this.activeItem = tableView.getSelectionModel().getSelectedItem();
        }
    }

    public void refreshList() {
        CommandeProduitController commandeProduitController = new CommandeProduitController();
        RaisonCol.setCellValueFactory(cellData -> {

            CommandeProduit commandeProduit = cellData.getValue();
            StringProperty libelleProperty = null;
            libelleProperty = new SimpleStringProperty(commandeProduit.getRaison());
            return libelleProperty;
        });

        PrixTotal.setCellValueFactory(cellData -> {
            CommandeProduit commandeProduit = cellData.getValue();

            DoubleProperty prixProperty = null;
            try {
                prixProperty = new SimpleDoubleProperty(commandeProduitController.getPrixTotal(commandeProduit.getId()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return prixProperty.asObject();
        });

        ObservableList<CommandeProduit> list = null;
        try {
            list = FXCollections.observableArrayList(commandeProduitController.getAllNew());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableView.setItems(list);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshList();
    }

    @FXML
    void changeStatut(ActionEvent event) throws SQLException {
        CommandeProduitController commandeProduitController = new CommandeProduitController();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choix un statut");
        alert.setHeaderText("Voulez vous valider ou refuser cette demande ?");
        alert.setContentText("Choississez une option");

        ButtonType buttonTypeOne = new ButtonType("Valider");
        ButtonType buttonTypeTwo = new ButtonType("Refuser");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            commandeProduitController.valider(this.activeItem.getId());
            refreshList();
        } else if (result.get() == buttonTypeTwo) {
            commandeProduitController.refuser(this.activeItem.getId());
            refreshList();
        }
    }


    @FXML
    void showDetails(ActionEvent event) {
        HelloApplication.newStage("PopUpDetailsCommande");
    }
}
