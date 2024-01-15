package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class DossierPatient {
    private int id;
    private LocalDate date_venue;
    private LocalTime heure_venue;
    private int gravite;
    private String symptomes;
    private boolean conclusion;
    private int id_medecin;
    private int id_patient;
    private int id_secretaire;
}
