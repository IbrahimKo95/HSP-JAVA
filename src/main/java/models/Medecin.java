package models;

import java.util.ArrayList;

/**
 * La classe Medecin représente un médecin travaillant à l'hôpital.
 * Elle hérite de la classe Utilisateur.
 */
public class Medecin extends Utilisateur {

    /**
     * Constructeur de la classe Medecin.
     * @param id L'identifiant du médecin.
     * @param nom Le nom du médecin.
     * @param prenom Le prénom du médecin.
     * @param email L'email du médecin.
     * @param mdp Le mot de passe du médecin.
     * @param role Le rôle du médecin.
     */
    public Medecin(int id, String nom, String prenom, String email, String mdp, String role) {
        super(id, nom, prenom, email, mdp, role);
    }
}
