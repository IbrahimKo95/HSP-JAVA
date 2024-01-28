package models;

public class FicheProduit {

    private int id;

    private String libelle;

    private String description;

    private int niv_dangerosite;

    private int qte_stock;

    private int id_gs;

    public FicheProduit(int id, String libelle, String description, int niv_dangerosite, int qte_stock, int id_gs) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.niv_dangerosite = niv_dangerosite;
        this.qte_stock = qte_stock;
        this.id_gs = id_gs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNiv_dangerosite() {
        return niv_dangerosite;
    }

    public void setNiv_dangerosite(int niv_dangerosite) {
        this.niv_dangerosite = niv_dangerosite;
    }

    public int getQte_stock() {
        return qte_stock;
    }

    public void setQte_stock(int qte_stock) {
        this.qte_stock = qte_stock;
    }

    public int getId_gs() {
        return id_gs;
    }

    public void setId_gs(int id_gs) {
        this.id_gs = id_gs;
    }
}
