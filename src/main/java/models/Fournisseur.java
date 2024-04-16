package models;

import java.sql.SQLException;

/**
 * La classe Fournisseur représente un fournisseur de produits.
 */
public class Fournisseur {
    private int id; // Identifiant unique du fournisseur.
    private String nom; // Nom du fournisseur.

    /**
     * Constructeur de la classe Fournisseur.
     * @param id L'identifiant unique du fournisseur.
     * @param nom Le nom du fournisseur.
     * @throws SQLException Si une erreur SQL survient lors de la création du fournisseur.
     */
    public Fournisseur(int id, String nom) throws SQLException {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du fournisseur.
     * @return L'identifiant du fournisseur.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant du fournisseur.
     * @param id L'identifiant du fournisseur.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir le nom du fournisseur.
     * @return Le nom du fournisseur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de définir le nom du fournisseur.
     * @param nom Le nom du fournisseur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

}
