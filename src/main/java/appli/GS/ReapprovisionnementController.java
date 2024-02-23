package appli.GS;

import appli.BaseController;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.CommandeConcerne;
import models.CommandeProduit;
import models.Produit;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReapprovisionnementController implements Initializable, BaseController<Void> {

    public Pane mainPane;

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private TableColumn<CommandeProduit, Double> PrixTotal;

    @FXML
    private TableColumn<CommandeProduit, String> RaisonCol;


    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private TextField researchBar;

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
    void add(ActionEvent event) throws IOException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("AjouterReapprovisionnement");
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void edit(ActionEvent event) {

    }

    @FXML
    void research(ActionEvent event) {

    }

    @FXML
    void select(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
}
