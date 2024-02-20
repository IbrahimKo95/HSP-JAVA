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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Button editButton;


    private FicheProduit activeItem;

    @FXML
    private TextField researchBar;

    private Pane mainPane;

    @FXML
    private TableColumn<FicheProduit, String> DescCol;

    @FXML
    private TableColumn<FicheProduit, Integer> QteCol;

    @FXML
    private TableColumn<FicheProduit, String> libelleCol;
    @FXML
    private TableColumn<FicheProduit, Integer> DangerositeCol;

    @FXML
    private TableView<FicheProduit> tableView;

    @Override
    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(Void object) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refreshList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void refreshList() throws SQLException {
        controllers.FicheProduitController ficheProduitController = new controllers.FicheProduitController();
        libelleCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        DescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        DangerositeCol.setCellValueFactory(new PropertyValueFactory<>("niv_dangerosite"));
        QteCol.setCellValueFactory(new PropertyValueFactory<>("qte_stock"));
        ObservableList<FicheProduit> list = FXCollections.observableArrayList(ficheProduitController.getAll());
        tableView.setItems(list);

    }

    @FXML
    void add(ActionEvent event) throws IOException, SQLException {
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
    void edit(ActionEvent event) throws IOException, SQLException {
        HomeGSController homeGSController = (HomeGSController) mainPane.getScene().getUserData();
        homeGSController.changePaneSide("ModifierFicheProduit", this.activeItem);
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
