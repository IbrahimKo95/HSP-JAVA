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

    public Double getPrixTotal(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement getPrice = co.prepareStatement(
                " SELECT SUM(cc.quantite * p.prix) as total FROM demandes_concerne cc JOIN produits p ON cc.id_fiche_produit = p.id_fiche_produit WHERE cc.id_fiche_produit = ?;");
        getPrice.setInt(1, id);
        ResultSet res = getPrice.executeQuery();
        res.next();
        double total = res.getDouble("total");
        total = Math.round(total * 100.0) / 100.0;
        return total;
    }

    public void valider(int idCommande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE demandes_produits SET statut = 2 WHERE id = ?");
        req.setInt(1, idCommande);
        req.executeUpdate();
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
