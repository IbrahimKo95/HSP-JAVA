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
}
