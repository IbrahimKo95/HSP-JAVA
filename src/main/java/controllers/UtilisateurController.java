package controllers;

import database.Bdd;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurController {

    public Utilisateur connexion(String email, String mdp) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement login = co.prepareStatement(
                "SELECT * FROM utilisateurs WHERE email = ? AND mdp = md5(?)");
        login.setString(1, email);
        login.setString(2, mdp);
        ResultSet res = login.executeQuery();
        if(res.next()){
            if(res.getString(5).equals("gs")){
                return new GS(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(6), res.getString(5));
            } else if (res.getString(5).equals("medecin")) {
                return new Medecin(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(6), res.getString(5));
            } else if (res.getString(5).equals("secretaire")) {
                return new Secretaire(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(6), res.getString(5));
            } else if (res.getString(5).equals("admin")) {
                return new Utilisateur(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(6), res.getString(5));
            }

        }
        return null;
    }

    public boolean addUser(String prenom, String nom, String mdp, String email, String role) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement add = co.prepareStatement(
                "INSERT INTO utilisateurs (prenom, nom, email, mdp, role) VALUES (?,?,?,md5(?),?)");
        add.setString(1, prenom);
        add.setString(2, nom);
        add.setString(3, email);
        add.setString(4, mdp);
        add.setString(5, role);
        add.executeUpdate();
        return true;
    }
}
