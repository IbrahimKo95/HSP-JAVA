package appli.GS;

import appli.BaseController;
import appli.HelloApplication;
import appli.HomeGSController;
import appli.PopUpFicheProduitController;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FicheProduitController implements Initializable, BaseController<Void> {
    @FXML
    private AnchorPane FournisseursPane;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button detailsButton;

    @FXML
    private Button editButton;

    @FXML
    private ListView<FicheProduit> list;

    private FicheProduit activeItem;

    @FXML
    private TextField researchBar;

    private Pane mainPane;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshList();
    }

    public void refreshList() {
        controllers.FicheProduitController ficheProduitController = new controllers.FicheProduitController();
        try {
            ObservableList<FicheProduit> listeFiches =  FXCollections.observableArrayList(ficheProduitController.getAll());
            list.setItems(listeFiches);
            list.setCellFactory(param -> new ListCell<FicheProduit>() {
                @Override
                protected void updateItem(FicheProduit item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null || item.getLibelle() == null) {
                        setText(null);
                    } else {
                        setText(item.getLibelle());
                    }
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void selectItems(MouseEvent event) {
        if(!list.getSelectionModel().getSelectedItems().isEmpty()){
            editButton.setDisable(false);
            deleteButton.setDisable(false);
            detailsButton.setDisable(false);
            this.activeItem = list.getSelectionModel().getSelectedItem();
        }
    }
    @FXML
    void add(ActionEvent event) throws IOException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("AjouterFicheProduit");
    }

    @FXML
    void delete(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Vous êtes sur le point de supprimer la fiche produit \""+this.activeItem.getLibelle()+"\" ");
        alert.setContentText("Etes vous sur de vouloir le supprimer ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            controllers.FicheProduitController ficheProduitController = new controllers.FicheProduitController();
            ficheProduitController.delete(this.activeItem.getId());
            refreshList();
        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("ModifierFicheProduit", this.activeItem);
    }

    @FXML
    void research(ActionEvent event) {

    }

    @FXML
    void showDetails(ActionEvent event) {
        HelloApplication.newStage("popupFicheProduit", new PopUpFicheProduitController(this.activeItem));
    }


}
