package controllers;

import database.Bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
