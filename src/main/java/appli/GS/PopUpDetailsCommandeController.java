package appli.GS;

import appli.BaseController;
import appli.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import models.CommandeProduit;

import java.sql.SQLException;

public class PopUpDetailsCommandeController implements BaseController<CommandeProduit> {

    private Pane mainPane;

    private CommandeProduit commandeProduit;

    @FXML
    private ScrollPane scrollPane;

    @Override
    public void setMainPane(Pane mainPane) throws SQLException {
        this.mainPane = mainPane;
    }

    @Override
    public void setObject(CommandeProduit object) throws SQLException {
        this.commandeProduit = object;

    }


}
