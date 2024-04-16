package controllers;

import database.Bdd;
import models.DemandeProduit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe gère les opérations liées aux demandes de produits dans l'application.
 */
public class DemandeProduitController {

    /**
     * Récupère toutes les demandes de produits avec un statut non validé.
     *
     * @return Une liste contenant toutes les demandes de produits en attente de validation.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<DemandeProduit> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM demandes_produits WHERE statut = 0");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<DemandeProduit> demandeProduits = new ArrayList<>();
        while (res.next()) {
            demandeProduits.add(new DemandeProduit(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5)));
        }
        return demandeProduits;
    }

    /**
     * Valide une demande de produit en mettant à jour son statut et en appelant la méthode de validation correspondante dans la classe DemandeConcerneController.
     *
     * @param idCommande L'identifiant de la commande associée à la demande de produit.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void valider(int idCommande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE demandes_produits SET statut = 2 WHERE id = ?");
        req.setInt(1, idCommande);
        req.executeUpdate();
        // Appelle la méthode valider de la classe DemandeConcerneController pour valider la demande associée.
        DemandeConcerneController demandeConcerneController = new DemandeConcerneController();
        demandeConcerneController.valider(idCommande);
    }

    /**
     * Refuse une demande de produit en mettant à jour son statut.
     *
     * @param idCommande L'identifiant de la commande associée à la demande de produit.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void refuser(int idCommande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE demandes_produits SET statut = 1 WHERE id = ?");
        req.setInt(1, idCommande);
        req.executeUpdate();
    }
}
