package controllers;

import database.Bdd;
import models.Fournisseur;
import models.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduitController {

    public ArrayList<Produit> getByFournisseur(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM produits WHERE id_fournisseur = ?");
        recupererTout.setInt(1, id);
        ResultSet res = recupererTout.executeQuery();
        ArrayList<Produit> produits = new ArrayList<>();
        while(res.next()){
            produits.add(new Produit(res.getDouble(3), res.getInt(1),res.getInt(2)));
        }
        return produits;
    }


    public void delete(int idFournisseur, int idFicheProduit) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement delete = co.prepareStatement(
                "DELETE FROM produits WHERE id_fournisseur = ? AND id_fiche_produit = ?");
        delete.setInt(1, idFournisseur);
        delete.setInt(2, idFicheProduit);
        delete.executeUpdate();
    }

    public void add(int id_fiche_produit, int id_fournisseur, double prix) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement delete = co.prepareStatement(
                "INSERT INTO produits (id_fiche_produit, id_fournisseur, prix) VALUES (?,?,?)");
        delete.setInt(1, id_fiche_produit);
        delete.setInt(2, id_fournisseur);
        delete.setDouble(3, prix);
        delete.executeUpdate();
    }
}
