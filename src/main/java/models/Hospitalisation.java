package models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La classe Hospitalisation représente une hospitalisation d'un patient dans une chambre de l'hôpital.
 */
public class Hospitalisation {
    private int id; // Identifiant unique de l'hospitalisation.
    private LocalDate date_hospitalisation; // Date de début de l'hospitalisation.
    private LocalTime heure_hospitalisation; // Heure de début de l'hospitalisation.
    private LocalDate date_fin_hospitalisation; // Date de fin de l'hospitalisation.
    private int id_dossier; // Identifiant du dossier médical du patient hospitalisé.
    private int id_chambre; // Identifiant de la chambre dans laquelle le patient est hospitalisé.

    public Hospitalisation(int id, LocalDate date_hospitalisation, LocalTime heure_hospitalisation, LocalDate date_fin_hospitalisation, int id_dossier, int id_chambre) {
        this.id = id;
        this.date_hospitalisation = date_hospitalisation;
        this.heure_hospitalisation = heure_hospitalisation;
        this.date_fin_hospitalisation = date_fin_hospitalisation;
        this.id_dossier = id_dossier;
        this.id_chambre = id_chambre;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de l'hospitalisation.
     * @return L'identifiant de l'hospitalisation.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant de l'hospitalisation.
     * @param id L'identifiant de l'hospitalisation.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir la date de début de l'hospitalisation.
     * @return La date de début de l'hospitalisation.
     */
    public LocalDate getDate_hospitalisation() {
        return date_hospitalisation;
    }

    /**
     * Méthode permettant de définir la date de début de l'hospitalisation.
     * @param date_hospitalisation La date de début de l'hospitalisation.
     */
    public void setDate_hospitalisation(LocalDate date_hospitalisation) {
        this.date_hospitalisation = date_hospitalisation;
    }

    /**
     * Méthode permettant d'obtenir l'heure de début de l'hospitalisation.
     * @return L'heure de début de l'hospitalisation.
     */
    public LocalTime getHeure_hospitalisation() {
        return heure_hospitalisation;
    }

    /**
     * Méthode permettant de définir l'heure de début de l'hospitalisation.
     * @param heure_hospitalisation L'heure de début de l'hospitalisation.
     */
    public void setHeure_hospitalisation(LocalTime heure_hospitalisation) {
        this.heure_hospitalisation = heure_hospitalisation;
    }

    /**
     * Méthode permettant d'obtenir la date de fin de l'hospitalisation.
     * @return La date de fin de l'hospitalisation.
     */
    public LocalDate getDate_fin_hospitalisation() {
        return date_fin_hospitalisation;
    }

    /**
     * Méthode permettant de définir la date de fin de l'hospitalisation.
     * @param date_fin_hospitalisation La date de fin de l'hospitalisation.
     */
    public void setDate_fin_hospitalisation(LocalDate date_fin_hospitalisation) {
        this.date_fin_hospitalisation = date_fin_hospitalisation;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du dossier médical du patient hospitalisé.
     * @return L'identifiant du dossier médical.
     */
    public int getId_dossier() {
        return id_dossier;
    }

    /**
     * Méthode permettant de définir l'identifiant du dossier médical du patient hospitalisé.
     * @param id_dossier L'identifiant du dossier médical.
     */
    public void setId_dossier(int id_dossier) {
        this.id_dossier = id_dossier;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la chambre dans laquelle le patient est hospitalisé.
     * @return L'identifiant de la chambre.
     */
    public int getId_chambre() {
        return id_chambre;
    }

    /**
     * Méthode permettant de définir l'identifiant de la chambre dans laquelle le patient est hospitalisé.
     * @param id_chambre L'identifiant de la chambre.
     */
    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }
}
