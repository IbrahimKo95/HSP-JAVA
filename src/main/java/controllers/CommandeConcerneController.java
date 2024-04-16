package controllers;

import database.Bdd;
import models.CommandeConcerne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cette classe gère les opérations liées aux commandes concernées par des produits dans l'application.
 */
public class CommandeConcerneController {

    /**
     * Ajoute une commande concernée par un produit dans la base de données.
     *
     * @param id_commande     L'identifiant de la commande.
     * @param id_fiche_produit L'identifiant de la fiche produit concernée.
     * @param quantite        La quantité de produits concernée.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void add(int id_commande, int id_fiche_produit, int quantite) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO commandes_concerne (id_commande, id_fiche_produit, quantite) VALUES (?,?,?)");
        req.setInt(1, id_commande);
        req.setInt(2, id_fiche_produit);
        req.setInt(3, quantite);
        req.executeUpdate();
    }

    /**
     * Valide une commande concernée par un produit en mettant à jour les stocks des produits concernés.
     *
     * @param id_commande L'identifiant de la commande à valider.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void valider(int id_commande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM commandes_concerne WHERE id_commande = ?");
        req.setInt(1, id_commande);
        ResultSet res = req.executeQuery();
        while (res.next()) {
            PreparedStatement update = co.prepareStatement(
                    "UPDATE fiches_produits SET qte_stock = qte_stock + ? WHERE id = ?");
            update.setInt(1, res.getInt(3));
            update.setInt(2, res.getInt(1));
            update.executeUpdate();
        }
    }

    /**
     * Récupère une commande concernée par un produit en fonction de l'identifiant de la commande et de la fiche produit.
     *
     * @param id_commande     L'identifiant de la commande.
     * @param id_fiche        L'identifiant de la fiche produit.
     * @return La commande concernée par un produit correspondante.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public CommandeConcerne getByFiche(int id_commande, int id_fiche) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM commandes_concerne WHERE id_commande = ? AND id_fiche_produit = ?");
        req.setInt(1, id_commande);
        req.setInt(2, id_fiche);
        ResultSet res = req.executeQuery();
        res.next();
        return new CommandeConcerne(res.getInt(1), res.getInt(2), res.getInt(3));
    }
}
