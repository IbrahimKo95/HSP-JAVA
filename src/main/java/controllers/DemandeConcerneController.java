package controllers;

import database.Bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cette classe gère les opérations liées aux demandes concernées par des produits dans l'application.
 */
public class DemandeConcerneController {

    /**
     * Valide une demande concernée par des produits en mettant à jour la quantité de stock des produits correspondants.
     *
     * @param id_demande L'identifiant de la demande de produit.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void valider(int id_demande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM demandes_concerne WHERE id_demande_produit = ?");
        req.setInt(1, id_demande);
        ResultSet res = req.executeQuery();
        while (res.next()) {
            PreparedStatement update = co.prepareStatement(
                    "UPDATE fiches_produits SET qte_stock = qte_stock - ? WHERE id = ?");
            update.setInt(1, res.getInt(3));
            update.setInt(2, res.getInt(1));
            update.executeUpdate();
        }
    }

    /**
     * Vérifie si une demande concernée par des produits peut être validée en fonction des quantités de stock disponibles.
     *
     * @param id_demande L'identifiant de la demande de produit.
     * @return true si la demande peut être validée, false sinon.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public boolean canValide(int id_demande) throws SQLException {
        boolean canValide = true;
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "SELECT * FROM demandes_concerne WHERE id_demande_produit = ?");
        req.setInt(1, id_demande);
        ResultSet res = req.executeQuery();
        while (res.next()) {
            PreparedStatement update = co.prepareStatement(
                    "SELECT qte_stock FROM fiches_produits WHERE id = ?");
            update.setInt(1, res.getInt(1));
            ResultSet res2 = update.executeQuery();
            res2.next();
            if (res2.getInt("qte_stock") < res.getInt(3)) {
                canValide = false;
            }
        }
        return canValide;
    }
}
