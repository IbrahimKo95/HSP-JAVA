package appli;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.FicheProduit;

import java.net.URL;
import java.util.ResourceBundle;

public class PopUpFicheProduitController implements Initializable {

    @FXML
    private Label dangerositeLabel;

    @FXML
    private Label descLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label qteLabel;


    private FicheProduit ficheProduit;

    public PopUpFicheProduitController(FicheProduit ficheProduit) {
        this.ficheProduit = ficheProduit;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText("Produit : "+ficheProduit.getLibelle());
        descLabel.setText(ficheProduit.getDescription());
        qteLabel.setText(String.valueOf(ficheProduit.getQte_stock()));
        dangerositeLabel.setText(String.valueOf(ficheProduit.getNiv_dangerosite()));
    }
}
