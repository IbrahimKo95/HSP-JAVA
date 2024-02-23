package models;

public class CommandeProduit {
    private int id;
    private String raison;
    private int statut;
    private int id_gs;
    private int id_fournisseur;

    public CommandeProduit(int id, String raison, int statut, int id_gs, int id_fournisseur) {
        this.id = id;
        this.raison = raison;
        this.statut = statut;
        this.id_gs = id_gs;
        this.id_fournisseur = id_fournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getId_gs() {
        return id_gs;
    }

    public void setId_gs(int id_gs) {
        this.id_gs = id_gs;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
}
