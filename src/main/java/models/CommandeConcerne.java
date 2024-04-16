package models;

/**
 * Classe CommandeConcerne représentant la liaison entre une commande et les produits qu'elles concernent.
 * Chaque instance de cette classe est identifiée par un ID de fiche produit, un ID de commande et une quantité.
 */
public class CommandeConcerne {
    private int id_fiche_produit;
    private int id_commande;
    private int quantite;

    /**
     * Constructeur de la classe CommandeConcerne.
     * @param id_fiche_produit l'ID de la fiche produit.
     * @param id_commande l'ID de la commande.
     * @param quantite la quantité de produit commandée.
     */
    public CommandeConcerne(int id_fiche_produit, int id_commande, int quantite) {
        this.id_fiche_produit = id_fiche_produit;
        this.id_commande = id_commande;
        this.quantite = quantite;
    }

    /**
     * Récupère l'ID de la fiche produit.
     * @return l'ID de la fiche produit.
     */
    public int getId_fiche_produit() {
        return id_fiche_produit;
    }

    /**
     * Définit l'ID de la fiche produit.
     * @param id_fiche_produit l'ID de la fiche produit à définir.
     */
    public void setId_fiche_produit(int id_fiche_produit) {
        this.id_fiche_produit = id_fiche_produit;
    }

    /**
     * Récupère l'ID de la commande.
     * @return l'ID de la commande.
     */
    public int getId_commande() {
        return id_commande;
    }

    /**
     * Définit l'ID de la commande.
     * @param id_commande l'ID de la commande à définir.
     */
    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    /**
     * Récupère la quantité de produit commandée.
     * @return la quantité de produit commandée.
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Définit la quantité de produit commandée.
     * @param quantite la quantité de produit commandée à définir.
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}