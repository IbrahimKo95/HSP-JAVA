package models;

public class DemandeProduit {
    private int id;
    private String raison;
    private int statut;

    private int id_gs;

    private int id_medecin;

    public DemandeProduit(int id, String raison, int statut, int id_gs, int id_medecin) {
        this.id = id;
        this.raison = raison;
        this.statut = statut;
        this.id_gs = id_gs;
        this.id_medecin = id_medecin;
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

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }
}
