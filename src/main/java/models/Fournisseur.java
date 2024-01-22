package models;

import controllers.ProduitController;

import java.sql.SQLException;
import java.util.ArrayList;

public class Fournisseur {
   private int id;
   private String nom;
   private ArrayList<Produit> produits;


    public Fournisseur(int id, String nom) throws SQLException {
        this.id = id;
        this.nom = nom;
       ProduitController produitController = new ProduitController();
       setProduits(produitController.getByFournisseur(this.id));
    }
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public ArrayList<Produit> getProduits() {
      return produits;
   }

   public void setProduits(ArrayList<Produit> produits) {
      this.produits = produits;
   }
}
