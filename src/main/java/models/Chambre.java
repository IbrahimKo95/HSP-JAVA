package models;

/**
 * Classe Chambre représentant une chambre dans un contexte d'hôpital.
 * Chaque chambre est identifiée par un ID unique et un numéro.
 */
public class Chambre {
    private int id;
    private int numero;

    /**
     * Récupère l'ID de la chambre.
     * @return l'ID de la chambre.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'ID de la chambre.
     * @param id l'ID de la chambre à définir.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Récupère le numéro de la chambre.
     * @return le numéro de la chambre.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Définit le numéro de la chambre.
     * @param numero le numéro de la chambre à définir.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
}