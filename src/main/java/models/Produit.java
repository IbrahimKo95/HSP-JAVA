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
}
