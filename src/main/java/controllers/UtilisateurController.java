package controllers;

import database.Bdd;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cette classe gère les opérations liées aux utilisateurs dans l'application.
 */
public class UtilisateurController {

    /**
     * Connecte un utilisateur en vérifiant l'adresse e-mail et le mot de passe dans la base de données.
     *
     * @param email L'adresse e-mail de l'utilisateur.
     * @param mdp   Le mot de passe de l'utilisateur.
     * @return L'utilisateur connecté ou null s'il n'existe pas dans la base de données ou si les informations d'identification sont incorrectes.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public Utilisateur connexion(String email, String mdp) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement login = co.prepareStatement(
                "SELECT * FROM utilisateurs WHERE email = ? AND mdp = md5(?)");
        login.setString(1, email);
        login.setString(2, mdp);
        ResultSet res = login.executeQuery();
        if (res.next()) {
            if (res.getString(5).equals("gs")) {
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

    /**
     * Ajoute un nouvel utilisateur à la base de données.
     *
     * @param prenom Le prénom de l'utilisateur.
     * @param nom    Le nom de l'utilisateur.
     * @param mdp    Le mot de passe de l'utilisateur.
     * @param email  L'adresse e-mail de l'utilisateur.
     * @param role   Le rôle de l'utilisateur.
     * @return true si l'utilisateur a été ajouté avec succès, sinon false.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
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

    /**
     * Récupère un utilisateur à partir de son identifiant.
     *
     * @param id L'identifiant de l'utilisateur.
     * @return L'utilisateur correspondant à l'identifiant spécifié, ou null s'il n'existe pas.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public Utilisateur getById(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement login = co.prepareStatement(
                "SELECT * FROM utilisateurs WHERE id = ?");
        login.setInt(1, id);
        ResultSet res = login.executeQuery();
        if (res.next()) {
            if (res.getString(5).equals("gs")) {
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
}
