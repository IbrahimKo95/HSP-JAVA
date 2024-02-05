package appli.GS;

import appli.BaseController;
import controllers.FicheProduitController;
import controllers.ProduitController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import models.FicheProduit;
import models.Fournisseur;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AjouterProduitController implements Initializable, BaseController<Fournisseur> {

    private Pane mainPane;

    private Fournisseur fournisseur;
    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private ComboBox<FicheProduit> comboBox;

    @FXML
    private TextField priceInput;

    @FXML
    void add(ActionEvent event) throws SQLException {
        ProduitController produitController = new ProduitController();
        produitController.add(comboBox.getValue().getId(), this.fournisseur.getId(), Double.parseDouble(priceInput.getText()));
    }

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        try {
            refreshCombo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        priceInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    priceInput.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    public void refreshCombo() throws SQLException {
        FicheProduitController ficheProduitController = new FicheProduitController();


        comboBox.setCellFactory(new Callback<ListView<FicheProduit>, ListCell<FicheProduit>>() {
            @Override
            public ListCell<FicheProduit> call(ListView<FicheProduit> param) {
                return new ListCell<FicheProduit>() {
                    @Override
                    protected void updateItem(FicheProduit item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getLibelle());
                        }
                    }
                };
            }
        });


        comboBox.setButtonCell(new ListCell<FicheProduit>() {
            @Override
            protected void updateItem(FicheProduit item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getLibelle());
                }
            }
        });

        comboBox.getItems().addAll(ficheProduitController.getAll());
    }
}

