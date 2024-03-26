package controllers;

import database.Bdd;
import models.CommandeProduit;
import models.DemandeProduit;
import models.DossierPatient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemandeProduitController {

    public ArrayList<DemandeProduit> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM demandes_produits WHERE statut = 0");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<DemandeProduit> demandeProduits = new ArrayList<>();
        while(res.next()){
            demandeProduits.add(new DemandeProduit(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5)));
        }
        return demandeProduits;
    }

    public void valider(int idCommande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE demandes_produits SET statut = 2 WHERE id = ?");
        req.setInt(1, idCommande);
        req.executeUpdate();
        DemandeConcerneController demandeConcerneController = new DemandeConcerneController();
        demandeConcerneController.valider(idCommande);
    }

    public void refuser(int idCommande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE demandes_produits SET statut = 1 WHERE id = ?");
        req.setInt(1, idCommande);
        req.executeUpdate();

    }
}
