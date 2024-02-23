package models;

public class CommandeConcerne {
    private int id_fiche_produit;
    private int id_commande;

    private int quantite;

    public CommandeConcerne(int id_fiche_produit, int id_commande, int quantite) {
        this.id_fiche_produit = id_fiche_produit;
        this.id_commande = id_commande;
        this.quantite = quantite;
    }

    public int getId_fiche_produit() {
        return id_fiche_produit;
    }

    public void setId_fiche_produit(int id_fiche_produit) {
        this.id_fiche_produit = id_fiche_produit;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
