package models;

import java.util.ArrayList;

public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private int numSecu;
    private String email;
    private int tel;
    private String adresse;
    private int id_secretaire;
    private ArrayList<DossierPatient> dossiers_patients;
}
