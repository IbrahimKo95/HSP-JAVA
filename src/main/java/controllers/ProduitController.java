package controllers;

import database.Bdd;
import models.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe gère les opérations liées aux produits dans l'application.
 */
public class ProduitController {

    /**
     * Récupère tous les produits fournis par un fournisseur donné.
     *
     * @param id L'identifiant du fournisseur.
     * @return Une liste de produits fournis par le fournisseur spécifié.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<Produit> getByFournisseur(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM produits WHERE id_fournisseur = ?");
        recupererTout.setInt(1, id);
        ResultSet res = recupererTout.executeQuery();
        ArrayList<Produit> produits = new ArrayList<>();
        while (res.next()) {
            produits.add(new Produit(res.getDouble(3), res.getInt(1), res.getInt(2)));
        }
        return produits;
    }

    /**
     * Supprime un produit spécifique associé à un fournisseur.
     *
     * @param idFournisseur   L'identifiant du fournisseur.
     * @param idFicheProduit  L'identifiant du produit à supprimer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void delete(int idFournisseur, int idFicheProduit) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement delete = co.prepareStatement(
                "DELETE FROM produits WHERE id_fournisseur = ? AND id_fiche_produit = ?");
        delete.setInt(1, idFournisseur);
        delete.setInt(2, idFicheProduit);
        delete.executeUpdate();
    }

    /**
     * Ajoute un nouveau produit fourni par un fournisseur.
     *
     * @param idFicheProduit  L'identifiant du produit.
     * @param idFournisseur   L'identifiant du fournisseur.
     * @param prix            Le prix du produit.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void add(int idFicheProduit, int idFournisseur, double prix) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement add = co.prepareStatement(
                "INSERT INTO produits (id_fiche_produit, id_fournisseur, prix) VALUES (?,?,?)");
        add.setInt(1, idFicheProduit);
        add.setInt(2, idFournisseur);
        add.setDouble(3, prix);
        add.executeUpdate();
    }

    /**
     * Modifie le prix d'un produit spécifique fourni par un fournisseur.
     *
     * @param idFicheProduit  L'identifiant du produit.
     * @param idFournisseur   L'identifiant du fournisseur.
     * @param prix            Le nouveau prix du produit.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void edit(int idFicheProduit, int idFournisseur, double prix) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement edit = co.prepareStatement(
                "UPDATE produits SET prix = ? WHERE id_fiche_produit = ? AND id_fournisseur = ?");
        edit.setDouble(1, prix);
        edit.setInt(2, idFicheProduit);
        edit.setInt(3, idFournisseur);
        edit.executeUpdate();
    }
}
