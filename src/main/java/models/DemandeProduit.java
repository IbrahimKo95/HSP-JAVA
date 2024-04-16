package models;

/**
 * La classe DemandeProduit représente une demande de produit effectuée par un médecin.
 */
public class DemandeProduit {
    private int id; // Identifiant unique de la demande de produit.
    private String raison; // Raison de la demande.
    private int statut; // Statut de la demande.
    private int id_gs; // Identifiant du gestionnaire de stock associé à la demande.
    private int id_medecin; // Identifiant du médecin effectuant la demande.

    /**
     * Constructeur de la classe DemandeProduit.
     * @param id L'identifiant unique de la demande de produit.
     * @param raison La raison de la demande.
     * @param statut Le statut de la demande.
     * @param id_gs L'identifiant du gestionnaire de stock associé à la demande.
     * @param id_medecin L'identifiant du médecin effectuant la demande.
     */
    public DemandeProduit(int id, String raison, int statut, int id_gs, int id_medecin) {
        this.id = id;
        this.raison = raison;
        this.statut = statut;
        this.id_gs = id_gs;
        this.id_medecin = id_medecin;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la demande de produit.
     * @return L'identifiant de la demande de produit.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant de la demande de produit.
     * @param id L'identifiant de la demande de produit.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir la raison de la demande.
     * @return La raison de la demande.
     */
    public String getRaison() {
        return raison;
    }

    /**
     * Méthode permettant de définir la raison de la demande.
     * @param raison La raison de la demande.
     */
    public void setRaison(String raison) {
        this.raison = raison;
    }

    /**
     * Méthode permettant d'obtenir le statut de la demande.
     * @return Le statut de la demande.
     */
    public int getStatut() {
        return statut;
    }

    /**
     * Méthode permettant de définir le statut de la demande.
     * @param statut Le statut de la demande.
     */
    public void setStatut(int statut) {
        this.statut = statut;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du gestionnaire de stock associé à la demande.
     * @return L'identifiant du gestionnaire de stock associé à la demande.
     */
    public int getId_gs() {
        return id_gs;
    }

    /**
     * Méthode permettant de définir l'identifiant du gestionnaire de stock associé à la demande.
     * @param id_gs L'identifiant du gestionnaire de stock associé à la demande.
     */
    public void setId_gs(int id_gs) {
        this.id_gs = id_gs;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du médecin effectuant la demande.
     * @return L'identifiant du médecin.
     */
    public int getId_medecin() {
        return id_medecin;
    }

    /**
     * Méthode permettant de définir l'identifiant du médecin effectuant la demande.
     * @param id_medecin L'identifiant du médecin.
     */
    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }
}
