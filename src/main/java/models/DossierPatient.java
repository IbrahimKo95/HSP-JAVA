package models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe DossierPatient représentant un dossier patient dans un contexte d'hôpital.
 * Chaque dossier patient est identifié par un ID, une date et heure de venue, une gravité, des symptômes, une conclusion, un ID de médecin, un ID de patient et un ID de secrétaire.
 */
public class DossierPatient {
    private int id;
    private LocalDate date_venue;
    private LocalTime heure_venue;
    private int gravite;
    private String symptomes;
    private int conclusion;
    private int id_medecin;
    private int id_patient;
    private int id_secretaire;

    /**
     * Constructeur de la classe DossierPatient.
     * @param id l'ID du dossier patient.
     * @param date_venue la date de venue du patient.
     * @param heure_venue l'heure de venue du patient.
     * @param gravite la gravité de l'état du patient.
     * @param symptomes les symptômes du patient.
     * @param conclusion la conclusion du médecin.
     * @param id_medecin l'ID du médecin en charge.
     * @param id_patient l'ID du patient.
     * @param id_secretaire l'ID de la secrétaire en charge.
     */
    public DossierPatient(int id, LocalDate date_venue, LocalTime heure_venue, int gravite, String symptomes, int conclusion, int id_medecin, int id_patient, int id_secretaire) {
        this.id = id;
        this.date_venue = date_venue;
        this.heure_venue = heure_venue;
        this.gravite =gravite;
        this.symptomes = symptomes;
        this.id_medecin = id_medecin;
        this.id_patient = id_patient;
        this.id_secretaire = id_secretaire;
    }

    /**
     * Récupère l'ID du dossier patient.
     * @return l'ID du dossier patient.
     */
    public int getId() {
        return id;
    }

    /**
     * Récupère la date de venue du patient.
     * @return la date de venue du patient.
     */
    public LocalDate getDate_venue() {
        return date_venue;
    }

    /**
     * Récupère l'heure de venue du patient.
     * @return l'heure de venue du patient.
     */
    public LocalTime getHeure_venue() {
        return heure_venue;
    }

    /**
     * Récupère la gravité de l'état du patient.
     * @return la gravité de l'état du patient.
     */
    public int getGravite() {
        return gravite;
    }

    /**
     * Récupère les symptômes du patient.
     * @return les symptômes du patient.
     */
    public String getSymptomes() {
        return symptomes;
    }

    /**
     * Récupère la conclusion du médecin.
     * @return la conclusion du médecin.
     */
    public int isConclusion() {
        return conclusion;
    }

    /**
     * Récupère l'ID du médecin en charge.
     * @return l'ID du médecin en charge.
     */
    public int getId_medecin() {
        return id_medecin;
    }

    /**
     * Récupère l'ID du patient.
     * @return l'ID du patient.
     */
    public int getId_patient() {
        return id_patient;
    }

    /**
     * Récupère l'ID de la secrétaire en charge.
     * @return l'ID de la secrétaire en charge.
     */
    public int getId_secretaire() {
        return id_secretaire;
    }
}