package models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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


    public int getId() {
        return id;
    }

    public LocalDate getDate_venue() {
        return date_venue;
    }

    public LocalTime getHeure_venue() {
        return heure_venue;
    }

    public int getGravite() {
        return gravite;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public int isConclusion() {
        return conclusion;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public int getId_patient() {
        return id_patient;
    }

    public int getId_secretaire() {
        return id_secretaire;
    }
}
