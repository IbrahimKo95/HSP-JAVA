package appli.GS;

import appli.BaseController;
import appli.HomeGSController;
import controllers.FicheProduitController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.FicheProduit;
import models.Fournisseur;
import models.Produit;

import java.io.IOException;
import java.sql.SQLException;

public class ProduitController implements BaseController<Fournisseur> {

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;


    @FXML
    private TextField researchBar;

    @FXML
    private Label labelTitle;

    private Produit activeItem;


    private Pane mainPane;

    private Fournisseur fournisseur;

    @FXML
    private TableColumn<Produit, Double> PrixCol;

    @FXML
    private TableColumn<Produit, String> libelleCol;

    @FXML
    private TableView<Produit> tableView;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Fournisseur object) throws SQLException {
        this.fournisseur = object;
        labelTitle.setText("Objets vendus par "+this.fournisseur.getNom());
        refreshList();
    }

    public void refreshList() throws SQLException {
        controllers.ProduitController produitController = new controllers.ProduitController();
        libelleCol.setCellValueFactory(cellData -> {
            FicheProduitController ficheProduitController = new FicheProduitController();
            Produit produit = cellData.getValue();
            StringProperty libelleProperty = null;
            try {
                libelleProperty = new SimpleStringProperty(ficheProduitController.getById(produit.getId_fiche_produit()).getLibelle());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return libelleProperty;
        });

        PrixCol.setCellValueFactory(cellData -> {
            Produit produit = cellData.getValue();
            DoubleProperty prixProperty = new SimpleDoubleProperty(produit.getPrix());
            return prixProperty.asObject();
        });
        ObservableList<Produit> list = FXCollections.observableArrayList(produitController.getByFournisseur(fournisseur.getId()));
        tableView.setItems(list);
    }

    @FXML
    void add(ActionEvent event) throws IOException, SQLException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("AjouterProduit", fournisseur);
    }

    @FXML
    void delete(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Vous êtes sur le point de supprimer ce produit ?");
        alert.setContentText("Etes vous sur de vouloir le supprimer ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            controllers.ProduitController produitController = new controllers.ProduitController();
            produitController.delete(activeItem.getId_fournisseur(), activeItem.getId_fiche_produit());
            refreshList();
        }
    }

    @FXML
    void edit(ActionEvent event) throws SQLException, IOException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("ModifierProduit", this.activeItem);
    }

    @FXML
    void research(ActionEvent event) {

    }

    @FXML
    void select(MouseEvent event) {
        if(tableView.getSelectionModel().getSelectedItem() != null){
            editButton.setDisable(false);
            deleteButton.setDisable(false);
            this.activeItem = tableView.getSelectionModel().getSelectedItem();
        }
    }
}
