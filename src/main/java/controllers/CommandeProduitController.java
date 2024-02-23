package controllers;

import database.Bdd;
import models.CommandeProduit;
import models.FicheProduit;

import java.sql.*;
import java.util.ArrayList;

public class CommandeProduitController {

    public ArrayList<CommandeProduit> getAllNew() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM commande_produit WHERE statut = 0");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<CommandeProduit> commandeProduit = new ArrayList<>();
        while (res.next()) {
            commandeProduit.add(new CommandeProduit(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5)));
        }
        return commandeProduit;
    }

    public ArrayList<CommandeProduit> getAllOld() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM commande_produit WHERE statut = 1 OR statut = 2");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<CommandeProduit> commandeProduit = new ArrayList<>();
        while (res.next()) {
            commandeProduit.add(new CommandeProduit(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5)));
        }
        return commandeProduit;
    }

    public Double getPrixTotal(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement getPrice = co.prepareStatement(
                " SELECT SUM(cc.quantite * p.prix) as total FROM commandes_concerne cc JOIN produits p ON cc.id_fiche_produit = p.id_fiche_produit WHERE cc.id_commande = ?;");
        getPrice.setInt(1, id);
        ResultSet res = getPrice.executeQuery();
        res.next();
        double total = res.getDouble("total");
        total = Math.round(total * 100.0) / 100.0; // Round to two decimal places
        return total;
    }


    public int add(String raison, int id_gs, int id_fournisseur) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO commande_produit (raison, statut, id_gs, id_fournisseur) VALUES (?,0,?,?)", Statement.RETURN_GENERATED_KEYS);
        req.setString(1, raison);
        req.setInt(2, id_gs);
        req.setInt(3, id_fournisseur);
        req.executeUpdate();
        ResultSet generatedKeys = req.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }
}
