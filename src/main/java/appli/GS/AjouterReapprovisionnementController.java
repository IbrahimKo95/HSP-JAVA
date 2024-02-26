package appli.GS;

import appli.BaseController;

import appli.HomeGSController;
import controllers.*;
import controllers.FicheProduitController;
import controllers.FournisseurController;
import controllers.ProduitController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import models.FicheProduit;
import models.Fournisseur;
import models.Produit;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AjouterReapprovisionnementController implements Initializable, BaseController<Void> {

    private ArrayList<ComboBox> produits = new ArrayList<>();

    private ArrayList<TextField> prix = new ArrayList<>();

    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private TextArea raisonInput;


    @FXML
    private ComboBox<Fournisseur> comboBox;

    @FXML
    private ScrollPane scrollPane;

    private Pane mainPane;

    @FXML
    private Button addNewRowButton;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) throws SQLException {

    }

    @FXML
    void addNewRow(ActionEvent event) throws SQLException {
        ComboBox comboBox = new ComboBox();
        TextField textField = new TextField();
        this.produits.add(comboBox);
        this.prix.add(textField);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                textField.setText(oldValue);
            }
        });
        updateCombo(comboBox);
        VBox content = (VBox) scrollPane.getContent();
        if (content == null) {
            content = new VBox();
            scrollPane.setContent(content);
        }

        VBox group = new VBox(comboBox, textField);
        Button deleteButton = new Button("-");
        VBox finalContent = content;
        deleteButton.setOnAction(e -> finalContent.getChildren().remove(group));
        group.getChildren().add(deleteButton);
        VBox.setVgrow(group, Priority.ALWAYS);

        VBox.setMargin(group, new Insets(0, 0, 15, 0));

        content.getChildren().add(group);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            refreshCombo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void refreshCombo() throws SQLException {
        FournisseurController fournisseurController = new FournisseurController();
        comboBox.setCellFactory(new Callback<ListView<Fournisseur>, ListCell<Fournisseur>>() {
            @Override
            public ListCell<Fournisseur> call(ListView<Fournisseur> param) {
                return new ListCell<Fournisseur>() {
                    @Override
                    protected void updateItem(Fournisseur item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getNom());
                        }
                    }
                };
            }
        });

        comboBox.setButtonCell(new ListCell<Fournisseur>() {
            @Override
            protected void updateItem(Fournisseur item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getNom());
                }
            }
        });

        comboBox.getItems().addAll(fournisseurController.getAll());
    }

    public void updateCombo(ComboBox combo) throws SQLException {
        ProduitController produitController = new ProduitController();
        FicheProduitController ficheProduitController = new FicheProduitController();
        combo.setCellFactory(new Callback<ListView<Produit>, ListCell<Produit>>() {
            @Override
            public ListCell<Produit> call(ListView<Produit> param) {
                return new ListCell<Produit>() {
                    @Override
                    protected void updateItem(Produit item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            try {
                                setText(ficheProduitController.getById(item.getId_fiche_produit()).getLibelle());
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                };
            }
        });

        combo.setButtonCell(new ListCell<Produit>() {
            @Override
            protected void updateItem(Produit item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    try {
                        setText(ficheProduitController.getById(item.getId_fiche_produit()).getLibelle());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        combo.getItems().addAll(produitController.getByFournisseur(comboBox.getValue().getId()));
    }
    @FXML
    void test(ActionEvent event) {
        addNewRowButton.setDisable(false);
    }

    @FXML
    void add(ActionEvent event) throws SQLException, IOException {
        CommandeProduitController commandeProduitController = new CommandeProduitController();
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        int id_commande = commandeProduitController.add(raisonInput.getText(), homeGSController.getUtilisateur().getId(), comboBox.getValue().getId());
        CommandeConcerneController commandeConcerneController = new CommandeConcerneController();
        for(int i = 0; i < produits.size(); i++) {
            Produit produit = (Produit) produits.get(i).getValue();
            commandeConcerneController.add(id_commande, produit.getId_fiche_produit(), Integer.parseInt(prix.get(i).getText()));
        }
        homeGSController.changePaneSide("Reapprovisionnement");
    }
}
