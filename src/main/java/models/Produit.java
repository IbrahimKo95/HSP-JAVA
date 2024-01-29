package models;

public class Produit {

    private double prix;
    private int id_fiche_produit;

    private int id_fournisseur;

    public Produit(double prix, int id_fiche_produit, int id_fournisseur) {
        this.prix = prix;
        this.id_fiche_produit = id_fiche_produit;
        this.id_fournisseur = id_fournisseur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId_fiche_produit() {
        return id_fiche_produit;
    }

    public void setId_fiche_produit(int id_fiche_produit) {
        this.id_fiche_produit = id_fiche_produit;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
}
