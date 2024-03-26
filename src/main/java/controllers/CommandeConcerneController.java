package controllers;

import database.Bdd;
import models.CommandeConcerne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandeConcerneController {

    public void add(int id_commande, int id_fiche_produit, int quantite) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO commandes_concerne (id_commande, id_fiche_produit, quantite) VALUES (?,?,?)");
        req.setInt(1, id_commande);
        req.setInt(2, id_fiche_produit);
        req.setInt(3, quantite);
        req.executeUpdate();
    }

    public void valider(int id_commande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM commandes_concerne WHERE id_commande = ?");
        req.setInt(1, id_commande);
        ResultSet res = req.executeQuery();
        while (res.next()) {
            PreparedStatement update = co.prepareStatement(
                    "UPDATE fiches_produits SET qte_stock = qte_stock + ? WHERE id = ?");
            update.setInt(1, res.getInt(3));
            update.setInt(2, res.getInt(1));
            update.executeUpdate();
        }
    }

    public CommandeConcerne getByFiche(int id_commande, int id_fiche) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM commandes_concerne WHERE id_commande = ? AND id_fiche_produit = ?");
        req.setInt(1, id_commande);
        req.setInt(2, id_fiche);
        ResultSet res = req.executeQuery();
        res.next();
        return new CommandeConcerne(res.getInt(1), res.getInt(2), res.getInt(3));
    }


}
