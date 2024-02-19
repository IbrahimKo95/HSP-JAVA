package appli.GS;

import appli.BaseController;
import appli.HomeGSController;
import controllers.FicheProduitController;
import controllers.FournisseurController;
import controllers.ProduitController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Fournisseur;
import models.Produit;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifierProduitController implements Initializable, BaseController<Produit> {

    public Pane mainPane;

    public Produit produit;

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private TextField priceInput;

    @FXML
    private Label productLabel;

    @FXML
    void edit(ActionEvent event) throws SQLException, IOException {
        ProduitController produitController = new ProduitController();
        FournisseurController fournisseurController = new FournisseurController();
        produitController.edit(produit.getId_fiche_produit(), produit.getId_fournisseur(), Double.parseDouble(priceInput.getText()));
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("Produits", fournisseurController.getById(produit.getId_fournisseur()));
    }

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Produit object) throws SQLException {
        this.produit = object;
        FicheProduitController ficheProduitController = new FicheProduitController();
        productLabel.setText(ficheProduitController.getById(this.produit.getId_fiche_produit()).getLibelle());
        priceInput.setText(String.valueOf(produit.getPrix()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        priceInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    priceInput.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            }
        });
    }
}
