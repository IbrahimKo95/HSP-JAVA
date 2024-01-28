package controllers;

import database.Bdd;
import models.FicheProduit;
import models.Fournisseur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FicheProduitController {

    public ArrayList<FicheProduit> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM fiches_produits");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<FicheProduit> fichesProduits = new ArrayList<>();
        while(res.next()){
            fichesProduits.add(new FicheProduit(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5), res.getInt(6)));
        }
        return fichesProduits;
    }

    public void add(String libelle, String description, int niv_dangerosite, int id_gs) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO fiches_produits (libelle, description, niv_dangerosite, id_gs) VALUES (?,?,?,?)");
        req.setString(1, libelle);
        req.setString(2, description);
        req.setInt(3, niv_dangerosite);
        req.setInt(4, id_gs);
        req.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement delete = co.prepareStatement(
                "DELETE FROM fiches_produits WHERE id = ?");
        delete.setInt(1, id);
        delete.executeUpdate();
    }

    public void edit(String libelle, String description, int niv_dangerosite, int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE fiches_produits SET libelle = ?, description = ?, niv_dangerosite = ? WHERE id = ?");
        req.setString(1, libelle);
        req.setString(2, description);
        req.setInt(3, niv_dangerosite);
        req.setInt(4, id);
        req.executeUpdate();
    }
}
