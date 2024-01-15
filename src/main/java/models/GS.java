package models;

import java.util.ArrayList;

public class GS extends Utilisateur {
    public ArrayList<FicheProduit> fiches_produits;

    public GS(int id, String nom, String prenom, String email, String mdp, String role, ArrayList<FicheProduit> fiches_produits) {
        super(id, nom, prenom, email, mdp, role);
        this.fiches_produits = fiches_produits;
    }

}
