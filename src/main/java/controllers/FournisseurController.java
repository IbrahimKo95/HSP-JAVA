package controllers;

import database.Bdd;
import models.Fournisseur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FournisseurController {

    public ArrayList<Fournisseur> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM fournisseurs");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        while(res.next()){
            fournisseurs.add(new Fournisseur(res.getInt(1), res.getString(2)));
        }
        return fournisseurs;
    }

    public void delete(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement delete = co.prepareStatement(
                "DELETE FROM fournisseurs WHERE id = ?");
        delete.setInt(1, id);
        delete.executeUpdate();
    }


    public void add(String nom) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO fournisseurs (nom) VALUES (?)");
        req.setString(1, nom);
        req.executeUpdate();
    }

    public void edit(String nom, int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE fournisseurs SET nom = ? WHERE id = ?");
        req.setString(1, nom);
        req.setInt(2, id);
        req.executeUpdate();
    }

    public Fournisseur getById(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM fournisseurs WHERE id = ?");
        recupererTout.setInt(1, id);
        ResultSet res = recupererTout.executeQuery();
        res.next();
        return new Fournisseur(res.getInt(1), res.getString(2));
    }
}
