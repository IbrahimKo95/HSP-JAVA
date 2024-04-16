package models;

/**
 * La classe Produit représente un produit dans le stock de l'hôpital.
 */
public class Produit {

    private double prix; // Prix du produit.
    private int id_fiche_produit; // Identifiant de la fiche produit associée au produit.
    private int id_fournisseur; // Identifiant du fournisseur du produit.

    /**
     * Constructeur de la classe Produit.
     * @param prix Le prix du produit.
     * @param id_fiche_produit L'identifiant de la fiche produit associée au produit.
     * @param id_fournisseur L'identifiant du fournisseur du produit.
     */
    public Produit(double prix, int id_fiche_produit, int id_fournisseur) {
        this.prix = prix;
        this.id_fiche_produit = id_fiche_produit;
        this.id_fournisseur = id_fournisseur;
    }

    /**
     * Méthode permettant d'obtenir le prix du produit.
     * @return Le prix du produit.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Méthode permettant de définir le prix du produit.
     * @param prix Le prix du produit.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la fiche produit associée au produit.
     * @return L'identifiant de la fiche produit.
     */
    public int getId_fiche_produit() {
        return id_fiche_produit;
    }

    /**
     * Méthode permettant de définir l'identifiant de la fiche produit associée au produit.
     * @param id_fiche_produit L'identifiant de la fiche produit.
     */
    public void setId_fiche_produit(int id_fiche_produit) {
        this.id_fiche_produit = id_fiche_produit;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du fournisseur du produit.
     * @return L'identifiant du fournisseur du produit.
     */
    public int getId_fournisseur() {
        return id_fournisseur;
    }

    /**
     * Méthode permettant de définir l'identifiant du fournisseur du produit.
     * @param id_fournisseur L'identifiant du fournisseur du produit.
     */
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
}
