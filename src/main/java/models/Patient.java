package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private String num_secu;
    private String email;
    private int tel;
    private String adresse;
    private int id_secretaire;

    public Patient(int id, String nom, String prenom, String num_secu, String email, int tel, String adresse, int id_secretaire) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.num_secu=num_secu;
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

    public String getNum_secu() {
        return num_secu;
    }

    public void setNum_secu(String num_secu) {
        this.num_secu = num_secu;
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

