package models;

import java.util.ArrayList;

/**
 * La classe Utilisateur représente un utilisateur du système.
 */
public class Utilisateur {

    private int id; // Identifiant unique de l'utilisateur.
    private String nom; // Nom de l'utilisateur.
    private String prenom; // Prénom de l'utilisateur.
    private String email; // Adresse email de l'utilisateur.
    private String mdp; // Mot de passe de l'utilisateur.
    private String role; // Rôle de l'utilisateur dans le système.

    /**
     * Constructeur de la classe Utilisateur.
     * @param id L'identifiant de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param email L'email de l'utilisateur.
     * @param mdp Le mot de passe de l'utilisateur.
     * @param role Le rôle de l'utilisateur.
     */
    public Utilisateur(int id, String nom, String prenom, String email, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    /**
     * Méthode permettant d'obtenir l'identifiant de l'utilisateur.
     * @return L'identifiant de l'utilisateur.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode permettant de définir l'identifiant de l'utilisateur.
     * @param id L'identifiant de l'utilisateur.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode permettant d'obtenir le nom de l'utilisateur.
     * @return Le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de définir le nom de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode permettant d'obtenir le prénom de l'utilisateur.
     * @return Le prénom de l'utilisateur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Méthode permettant de définir le prénom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode permettant d'obtenir l'email de l'utilisateur.
     * @return L'email de l'utilisateur.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Méthode permettant de définir l'email de l'utilisateur.
     * @param email L'email de l'utilisateur.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Méthode permettant d'obtenir le mot de passe de l'utilisateur.
     * @return Le mot de passe de l'utilisateur.
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Méthode permettant de définir le mot de passe de l'utilisateur.
     * @param mdp Le mot de passe de l'utilisateur.
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Méthode permettant d'obtenir le rôle de l'utilisateur.
     * @return Le rôle de l'utilisateur.
     */
    public String getRole() {
        return role;
    }

    /**
     * Méthode permettant de définir le rôle de l'utilisateur.
     * @param role Le rôle de l'utilisateur.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
