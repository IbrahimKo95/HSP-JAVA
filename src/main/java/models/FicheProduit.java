package models;

/**
 * La classe FicheProduit représente les informations détaillées d'un produit.
 */
public class FicheProduit {

    private int id; // Identifiant unique de la fiche produit.
    private String libelle; // Libellé du produit.
    private String description; // Description du produit.
    private int niv_dangerosite; // Niveau de dangerosité du produit.
    private int qte_stock; // Quantité en stock du produit.
    private int id_gs; // Identifiant du gestionnaire de stock associé au produit.

    /**
     * Constructeur de la classe FicheProduit.
     * @param id L'identifiant unique de la fiche produit.
     * @param libelle Le libellé du produit.
     * @param description La description du produit.
     * @param niv_dangerosite Le niveau de dangerosité du produit.
     * @param qte_stock La quantité en stock du produit.
     * @param id_gs L'identifiant du gestionnaire de stock associé au produit.
     */
    public FicheProduit(int id, String libelle, String description, int niv_dangerosite, int qte_stock, int id_gs) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.niv_dangerosite = niv_dangerosite;
        this.qte_stock = qte_stock;
        this.id_gs = id_gs;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la fiche produit.
     * @return L'identifiant de la fiche produit.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant de la fiche produit.
     * @param id L'identifiant de la fiche produit.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir le libellé du produit.
     * @return Le libellé du produit.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Méthode permettant de définir le libellé du produit.
     * @param libelle Le libellé du produit.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Méthode permettant d'obtenir la description du produit.
     * @return La description du produit.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Méthode permettant de définir la description du produit.
     * @param description La description du produit.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Méthode permettant d'obtenir le niveau de dangerosité du produit.
     * @return Le niveau de dangerosité du produit.
     */
    public int getNiv_dangerosite() {
        return niv_dangerosite;
    }

    /**
     * Méthode permettant de définir le niveau de dangerosité du produit.
     * @param niv_dangerosite Le niveau de dangerosité du produit.
     */
    public void setNiv_dangerosite(int niv_dangerosite) {
        this.niv_dangerosite = niv_dangerosite;
    }

    /**
     * Méthode permettant d'obtenir la quantité en stock du produit.
     * @return La quantité en stock du produit.
     */
    public int getQte_stock() {
        return qte_stock;
    }

    /**
     * Méthode permettant de définir la quantité en stock du produit.
     * @param qte_stock La quantité en stock du produit.
     */
    public void setQte_stock(int qte_stock) {
        this.qte_stock = qte_stock;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du gestionnaire de stock associé au produit.
     * @return L'identifiant du gestionnaire de stock associé au produit.
     */
    public int getId_gs() {
        return id_gs;
    }

    /**
     * Méthode permettant de définir l'identifiant du gestionnaire de stock associé au produit.
     * @param id_gs L'identifiant du gestionnaire de stock associé au produit.
     */
    public void setId_gs(int id_gs) {
        this.id_gs = id_gs;
    }
}
