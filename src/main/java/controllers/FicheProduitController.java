package controllers;

import database.Bdd;
import models.FicheProduit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe gère les opérations liées aux fiches produits dans l'application.
 */
public class FicheProduitController {

    /**
     * Récupère toutes les fiches produits enregistrées dans la base de données.
     *
     * @return Une liste contenant toutes les fiches produits enregistrées.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<FicheProduit> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM fiches_produits");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<FicheProduit> fichesProduits = new ArrayList<>();
        while (res.next()) {
            fichesProduits.add(new FicheProduit(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5), res.getInt(6)));
        }
        return fichesProduits;
    }

    /**
     * Ajoute une nouvelle fiche produit à la base de données.
     *
     * @param libelle          Le libellé de la fiche produit.
     * @param description      La description de la fiche produit.
     * @param niv_dangerosite  Le niveau de dangerosité de la fiche produit.
     * @param id_gs            L'identifiant du GS responsable de la fiche produit.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void add(String libelle, String description, int niv_dangerosite, int id_gs) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO fiches_produits (libelle, description, niv_dangerosite, id_gs, qte_stock) VALUES (?,?,?,?,0)");
        req.setString(1, libelle);
        req.setString(2, description);
        req.setInt(3, niv_dangerosite);
        req.setInt(4, id_gs);
        req.executeUpdate();
    }

    /**
     * Supprime une fiche produit de la base de données en fonction de son identifiant.
     *
     * @param id L'identifiant de la fiche produit à supprimer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void delete(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement delete = co.prepareStatement(
                "DELETE FROM fiches_produits WHERE id = ?");
        delete.setInt(1, id);
        delete.executeUpdate();
    }

    /**
     * Modifie une fiche produit dans la base de données.
     *
     * @param libelle         Le nouveau libellé de la fiche produit.
     * @param description     La nouvelle description de la fiche produit.
     * @param niv_dangerosite Le nouveau niveau de dangerosité de la fiche produit.
     * @param id              L'identifiant de la fiche produit à modifier.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
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

    /**
     * Récupère une fiche produit spécifique par son identifiant.
     *
     * @param id L'identifiant de la fiche produit à récupérer.
     * @return La fiche produit correspondant à l'identifiant spécifié.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public FicheProduit getById(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM fiches_produits WHERE id = ?");
        recupererTout.setInt(1, id);
        ResultSet res = recupererTout.executeQuery();
        res.next();
        return new FicheProduit(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5), res.getInt(6));
    }

    /**
     * Récupère les fiches produits associées à une commande spécifique.
     *
     * @param id_commande L'identifiant de la commande.
     * @return Une liste contenant les fiches produits associées à la commande.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<FicheProduit> getByCommande(int id_commande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM commandes_concerne WHERE id_commande = ?");
        req.setInt(1, id_commande);
        ResultSet res = req.executeQuery();
        ArrayList<FicheProduit> ficheProduits = new ArrayList<>();
        while (res.next()) {
            PreparedStatement update = co.prepareStatement(
                    "SELECT * FROM fiches_produits WHERE id = ?");
            update.setInt(1, res.getInt(1));
            ResultSet res2 = update.executeQuery();
            if (res2.next()) {
                ficheProduits.add(new FicheProduit(res2.getInt(1), res2.getString(2), res2.getString(3), res2.getInt(4), res2.getInt(5), res2.getInt(6)));
            }
        }
        return ficheProduits;
    }
}
