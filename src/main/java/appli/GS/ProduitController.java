package appli.GS;

import appli.BaseController;
import controllers.FicheProduitController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.FicheProduit;
import models.Fournisseur;
import models.Produit;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    private ListView<Produit> list;

    @FXML
    private TextField researchBar;

    @FXML
    private Label labelTitle;


    private Pane mainPane;

    private Fournisseur fournisseur;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Fournisseur object) {
        this.fournisseur = object;
        labelTitle.setText("Objets vendus par "+this.fournisseur.getNom());
        refreshList();
    }

    public void refreshList() {
        controllers.ProduitController produitController = new controllers.ProduitController();
        try {
            ObservableList<Produit> listeFournisseur =  FXCollections.observableArrayList(produitController.getByFournisseur(this.fournisseur.getId()));
            list.setItems(listeFournisseur);
            list.setCellFactory(param -> new ListCell<Produit>() {
                @Override
                protected void updateItem(Produit item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        FicheProduitController ficheProduitController = new FicheProduitController();
                        try {
                            setText(ficheProduitController.getById(item.getId_fiche_produit()).getLibelle());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void add(ActionEvent event) {

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
    void selectItems(MouseEvent event) {

    }
}
