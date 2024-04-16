package controllers;

import database.Bdd;
import models.CommandeProduit;

import java.sql.*;
import java.util.ArrayList;

/**
 * Cette classe gère les opérations liées aux commandes de produits dans l'application.
 */
public class CommandeProduitController {

    /**
     * Récupère toutes les nouvelles commandes de produits.
     *
     * @return Une liste des nouvelles commandes de produits.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<CommandeProduit> getAllNew() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM commande_produit WHERE statut = 0");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<CommandeProduit> commandeProduit = new ArrayList<>();
        while (res.next()) {
            commandeProduit.add(new CommandeProduit(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5)));
        }
        return commandeProduit;
    }

    /**
     * Récupère toutes les anciennes commandes de produits.
     *
     * @return Une liste des anciennes commandes de produits.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<CommandeProduit> getAllOld() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM commande_produit WHERE statut = 1 OR statut = 2");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<CommandeProduit> commandeProduit = new ArrayList<>();
        while (res.next()) {
            commandeProduit.add(new CommandeProduit(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5)));
        }
        return commandeProduit;
    }

    /**
     * Calcule le prix total d'une commande en fonction de son identifiant.
     *
     * @param id L'identifiant de la commande.
     * @return Le prix total de la commande.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public Double getPrixTotal(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement getPrice = co.prepareStatement(
                " SELECT SUM(cc.quantite * p.prix) as total FROM commandes_concerne cc JOIN produits p ON cc.id_fiche_produit = p.id_fiche_produit WHERE cc.id_commande = ?;");
        getPrice.setInt(1, id);
        ResultSet res = getPrice.executeQuery();
        res.next();
        double total = res.getDouble("total");
        total = Math.round(total * 100.0) / 100.0; // Arrondi à deux décimales
        return total;
    }

    /**
     * Ajoute une nouvelle commande de produits dans la base de données.
     *
     * @param raison         La raison de la commande.
     * @param id_gs          L'identifiant du gestionnaire de stock associé à la commande.
     * @param id_fournisseur L'identifiant du fournisseur associé à la commande.
     * @return L'identifiant de la nouvelle commande ajoutée.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public int add(String raison, int id_gs, int id_fournisseur) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "INSERT INTO commande_produit (raison, statut, id_gs, id_fournisseur) VALUES (?,0,?,?)", Statement.RETURN_GENERATED_KEYS);
        req.setString(1, raison);
        req.setInt(2, id_gs);
        req.setInt(3, id_fournisseur);
        req.executeUpdate();
        ResultSet generatedKeys = req.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }

    /**
     * Refuse une commande de produits en mettant à jour son statut.
     *
     * @param idCommande L'identifiant de la commande à refuser.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void refuser(int idCommande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE commande_produit SET statut = 1 WHERE id = ?");
        req.setInt(1, idCommande);
        req.executeUpdate();
    }

    /**
     * Valide une commande de produits en mettant à jour son statut et les commandes concernées associées.
     *
     * @param idCommande L'identifiant de la commande à valider.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void valider(int idCommande) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement req = co.prepareStatement(
                "UPDATE commande_produit SET statut = 2 WHERE id = ?");
        req.setInt(1, idCommande);
        req.executeUpdate();
        CommandeConcerneController commandeConcerneController = new CommandeConcerneController();
        commandeConcerneController.valider(idCommande);
    }

    /**
     * Récupère une commande de produits en fonction de son identifiant.
     *
     * @param id L'identifiant de la commande.
     * @return La commande de produits correspondante.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public CommandeProduit getById(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM commande_produit WHERE id = ?");
        recupererTout.setInt(1, id);
        ResultSet res = recupererTout.executeQuery();
        res.next();
        return new CommandeProduit(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5));
    }
}
