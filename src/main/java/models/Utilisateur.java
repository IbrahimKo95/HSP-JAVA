package models;

import java.util.ArrayList;

public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String role;

    public Utilisateur(int id, String nom, String prenom, String email, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }
}
