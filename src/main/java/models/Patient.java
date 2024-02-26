package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private String numSecu;
    private String email;
    private int tel;
    private String adresse;
    private int id_secretaire;

    public Patient(int id, String nom, String prenom, String numSecu, String email, int tel, String adresse, int id_secretaire) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.numSecu=numSecu;
        this.email=email;
        this.tel=tel;
        this.adresse=adresse;
        this.id_secretaire=id_secretaire;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId_secretaire() {
        return id_secretaire;
    }

    public void setId_secretaire(int id_secretaire) {
        this.id_secretaire = id_secretaire;
    }
}

