package controllers;

import database.Bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemandeConcerneController {

    public void valider(int id_demande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM demandes_concerne WHERE id_demande_produit = ?");
        req.setInt(1, id_demande);
        ResultSet res = req.executeQuery();
        while (res.next()) {
            PreparedStatement update = co.prepareStatement(
                    "UPDATE fiches_produits SET qte_stock = qte_stock - ? WHERE id = ?");
            update.setInt(1, res.getInt(3));
            update.setInt(2, res.getInt(1));
            update.executeUpdate();
        }
    }

    public boolean canValide(int id_demande) throws SQLException {
        Boolean canValide = true;
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM demandes_concerne WHERE id_demande_produit = ?");
        req.setInt(1, id_demande);
        ResultSet res = req.executeQuery();
        while (res.next()) {
            PreparedStatement update = co.prepareStatement(
                    "SELECT qte_stock FROM fiches_produits WHERE id = ?");
            update.setInt(1, res.getInt(1));
            ResultSet res2 = update.executeQuery();
            res2.next();
            if(res2.getInt("qte_stock") < res.getInt(3)){
                canValide = false;
            }
        }
        return canValide;
    }
}
