package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * La classe Patient représente un patient de l'hôpital.
 */
public class Patient {

    private int id; // Identifiant unique du patient.
    private String nom; // Nom du patient.
    private String prenom; // Prénom du patient.
    private String num_secu; // Numéro de sécurité sociale du patient.
    private String email; // Adresse email du patient.
    private int tel; // Numéro de téléphone du patient.
    private String adresse; // Adresse du patient.
    private int id_secretaire; // Identifiant de la secrétaire associée au patient.

    /**
     * Constructeur de la classe Patient.
     * @param id L'identifiant unique du patient.
     * @param nom Le nom du patient.
     * @param prenom Le prénom du patient.
     * @param num_secu Le numéro de sécurité sociale du patient.
     * @param email L'adresse email du patient.
     * @param tel Le numéro de téléphone du patient.
     * @param adresse L'adresse du patient.
     * @param id_secretaire L'identifiant de la secrétaire associée au patient.
     */
    public Patient(int id, String nom, String prenom, String num_secu, String email, int tel, String adresse, int id_secretaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.num_secu = num_secu;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.id_secretaire = id_secretaire;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du patient.
     * @return L'identifiant du patient.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant du patient.
     * @param id L'identifiant du patient.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir le nom du patient.
     * @return Le nom du patient.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de définir le nom du patient.
     * @param nom Le nom du patient.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode permettant d'obtenir le prénom du patient.
     * @return Le prénom du patient.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Méthode permettant de définir le prénom du patient.
     * @param prenom Le prénom du patient.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode permettant d'obtenir le numéro de sécurité sociale du patient.
     * @return Le numéro de sécurité sociale du patient.
     */
    public String getNum_secu() {
        return num_secu;
    }

    /**
     * Méthode permettant de définir le numéro de sécurité sociale du patient.
     * @param num_secu Le numéro de sécurité sociale du patient.
     */
    public void setNum_secu(String num_secu) {
        this.num_secu = num_secu;
    }

    /**
     * Méthode permettant d'obtenir l'adresse email du patient.
     * @return L'adresse email du patient.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Méthode permettant de définir l'adresse email du patient.
     * @param email L'adresse email du patient.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Méthode permettant d'obtenir le numéro de téléphone du patient.
     * @return Le numéro de téléphone du patient.
     */
    public int getTel() {
        return tel;
    }

    /**
     * Méthode permettant de définir le numéro de téléphone du patient.
     * @param tel Le numéro de téléphone du patient.
     */
    public void setTel(int tel) {
        this.tel = tel;
    }

    /**
     * Méthode permettant d'obtenir l'adresse du patient.
     * @return L'adresse du patient.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Méthode permettant de définir l'adresse du patient.
     * @param adresse L'adresse du patient.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de la secrétaire associée au patient.
     * @return L'identifiant de la secrétaire associée au patient.
     */
    public int getId_secretaire() {
        return id_secretaire;
    }

    /**
     * Méthode permettant de définir l'identifiant de la secrétaire associée au patient.
     * @param id_secretaire L'identifiant de la secrétaire associée au patient.
     */
    public void setId_secretaire(int id_secretaire) {
        this.id_secretaire = id_secretaire;
    }
}
