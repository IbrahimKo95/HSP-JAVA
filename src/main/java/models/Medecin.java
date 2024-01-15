package models;

import java.util.ArrayList;

public class Medecin extends Utilisateur{

    public ArrayList<DemandeProduit> demandes_produits;

    public Medecin(int id, String nom, String prenom, String email, String mdp, String role, ArrayList<DemandeProduit> demandes_produits) {
        super(id, nom, prenom, email, mdp, role);
        this.demandes_produits = demandes_produits;
    }
}
