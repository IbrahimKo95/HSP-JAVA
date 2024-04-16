package controllers;

import database.Bdd;
import models.Fournisseur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe gère les opérations liées aux fournisseurs dans l'application.
 */
public class FournisseurController {

    /**
     * Récupère tous les fournisseurs enregistrés dans la base de données.
     *
     * @return Une liste contenant tous les fournisseurs enregistrés.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<Fournisseur> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM fournisseurs");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        while (res.next()) {
            fournisseurs.add(new Fournisseur(res.getInt(1), res.getString(2)));
        }
        return fournisseurs;
    }

    /**
     * Supprime un fournisseur de la base de données en fonction de son identifiant.
     *
     * @param id L'identifiant du fournisseur à supprimer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void delete(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement delete = co.prepareStatement(
                "DELETE FROM fournisseurs WHERE id = ?");
        delete.setInt(1, id);
        delete.executeUpdate();
    }

    /**
     * Ajoute un nouveau fournisseur à la base de données.
     *
     * @param nom Le nom du nouveau fournisseur.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void add(String nom) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO fournisseurs (nom) VALUES (?)");
        req.setString(1, nom);
        req.executeUpdate();
    }

    /**
     * Modifie le nom d'un fournisseur dans la base de données.
     *
     * @param nom Le nouveau nom du fournisseur.
     * @param id  L'identifiant du fournisseur à modifier.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void edit(String nom, int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE fournisseurs SET nom = ? WHERE id = ?");
        req.setString(1, nom);
        req.setInt(2, id);
        req.executeUpdate();
    }

    /**
     * Récupère un fournisseur spécifique par son identifiant.
     *
     * @param id L'identifiant du fournisseur à récupérer.
     * @return Le fournisseur correspondant à l'identifiant spécifié.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
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
