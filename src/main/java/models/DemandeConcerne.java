package models;

/**
 * La classe DemandeConcerne représente la liaison entre une demande de produit et les produits qu'elles concernent.
 */
public class DemandeConcerne {

    private int id; // Identifiant unique de la demande.
    private int quantite; // Quantité demandée.
    private int id_demande_produit; // Identifiant de la demande de produit associée.
    private int id_fiche_produit; // Identifiant de la fiche produit concernée.

    /**
     * Méthode permettant d'obtenir l'identifiant de la demande.
     * @return L'identifiant de la demande.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant de la demande.
     * @param id L'identifiant de la demande.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir la quantité demandée.
     * @return La quantité demandée.
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Méthode permettant de définir la quantité demandée.
     * @param quantite La quantité demandée.
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la demande de produit associée.
     * @return L'identifiant de la demande de produit.
     */
    public int getId_demande_produit() {
        return id_demande_produit;
    }

    /**
     * Méthode permettant de définir l'identifiant de la demande de produit associée.
     * @param id_demande_produit L'identifiant de la demande de produit.
     */
    public void setId_demande_produit(int id_demande_produit) {
        this.id_demande_produit = id_demande_produit;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la fiche produit concernée.
     * @return L'identifiant de la fiche produit concernée.
     */
    public int getId_fiche_produit() {
        return id_fiche_produit;
    }

    /**
     * Méthode permettant de définir l'identifiant de la fiche produit concernée.
     * @param id_fiche_produit L'identifiant de la fiche produit concernée.
     */
    public void setId_fiche_produit(int id_fiche_produit) {
        this.id_fiche_produit = id_fiche_produit;
    }
}
