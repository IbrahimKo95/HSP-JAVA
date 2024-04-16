package models;

/**
 * La classe CommandeProduit représente une commande de produits au près d'un fournisseur.
 */
public class CommandeProduit {
    private int id; // Identifiant unique de la commande.
    private String raison; // Raison de la commande.
    private int statut; // Statut de la commande.
    private int id_gs; // Identifiant du gestionnaire de stock associé à la commande.
    private int id_fournisseur; // Identifiant du fournisseur auprès duquel la commande est passée.

    /**
     * Constructeur de la classe CommandeProduit.
     * @param id L'identifiant unique de la commande.
     * @param raison La raison de la commande.
     * @param statut Le statut de la commande.
     * @param id_gs L'identifiant du gestionnaire de stock associé à la commande.
     * @param id_fournisseur L'identifiant du fournisseur auprès duquel la commande est passée.
     */
    public CommandeProduit(int id, String raison, int statut, int id_gs, int id_fournisseur) {
        this.id = id;
        this.raison = raison;
        this.statut = statut;
        this.id_gs = id_gs;
        this.id_fournisseur = id_fournisseur;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la commande.
     * @return L'identifiant de la commande.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant de la commande.
     * @param id L'identifiant de la commande.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir la raison de la commande.
     * @return La raison de la commande.
     */
    public String getRaison() {
        return raison;
    }

    /**
     * Méthode permettant de définir la raison de la commande.
     * @param raison La raison de la commande.
     */
    public void setRaison(String raison) {
        this.raison = raison;
    }

    /**
     * Méthode permettant d'obtenir le statut de la commande.
     * @return Le statut de la commande.
     */
    public int getStatut() {
        return statut;
    }

    /**
     * Méthode permettant de définir le statut de la commande.
     * @param statut Le statut de la commande.
     */
    public void setStatut(int statut) {
        this.statut = statut;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du gestionnaire de stock associé à la commande.
     * @return L'identifiant du gestionnaire de stock associé à la commande.
     */
    public int getId_gs() {
        return id_gs;
    }

    /**
     * Méthode permettant de définir l'identifiant du gestionnaire de stock associé à la commande.
     * @param id_gs L'identifiant du gestionnaire de stock associé à la commande.
     */
    public void setId_gs(int id_gs) {
        this.id_gs = id_gs;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du fournisseur auprès duquel la commande est passée.
     * @return L'identifiant du fournisseur.
     */
    public int getId_fournisseur() {
        return id_fournisseur;
    }

    /**
     * Méthode permettant de définir l'identifiant du fournisseur auprès duquel la commande est passée.
     * @param id_fournisseur L'identifiant du fournisseur.
     */
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
}
