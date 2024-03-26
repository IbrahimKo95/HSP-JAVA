package appli.GS;

import appli.BaseController;
import appli.HelloApplication;
import controllers.CommandeConcerneController;
import controllers.FicheProduitController;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import models.CommandeProduit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.FicheProduit;
import models.Produit;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PopUpDetailsCommandeController implements Initializable {

    private Pane mainPane;

    private CommandeProduit commandeProduit;


    @FXML
    private TableColumn<FicheProduit, Integer> QuantiteCol;

    @FXML
    private TableColumn<FicheProduit, String> produitCol;

    @FXML
    private TableView<FicheProduit> table;


    public PopUpDetailsCommandeController(CommandeProduit commandeProduit) {
        this.commandeProduit = commandeProduit;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controllers.FicheProduitController ficheProduitController = new controllers.FicheProduitController();
        produitCol.setCellValueFactory(cellData -> {
            FicheProduit ficheProduit = cellData.getValue();
            StringProperty libelleProperty = null;
            libelleProperty = new SimpleStringProperty(ficheProduit.getLibelle());
            return libelleProperty;
        });

        QuantiteCol.setCellValueFactory(cellData -> {
            CommandeConcerneController commandeConcerneController = new CommandeConcerneController();
            FicheProduit ficheProduit = cellData.getValue();
            IntegerProperty prixProperty = null;
            try {
                prixProperty = new SimpleIntegerProperty(commandeConcerneController.getByFiche(this.commandeProduit.getId(), ficheProduit.getId()).getQuantite());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return prixProperty.asObject();
        });
        ObservableList<FicheProduit> list = null;
        try {
            list = FXCollections.observableArrayList(ficheProduitController.getByCommande(commandeProduit.getId()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table.setItems(list);
    }
}
