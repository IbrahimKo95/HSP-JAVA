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
}
