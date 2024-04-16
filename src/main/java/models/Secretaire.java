package models;

import java.util.ArrayList;

/**
 * La classe Secretaire représente une secrétaire travaillant à l'hôpital.
 * Elle hérite de la classe Utilisateur.
 */
public class Secretaire extends Utilisateur {

    /**
     * Constructeur de la classe Secretaire.
     * @param id L'identifiant de la secrétaire.
     * @param nom Le nom de la secrétaire.
     * @param prenom Le prénom de la secrétaire.
     * @param email L'email de la secrétaire.
     * @param mdp Le mot de passe de la secrétaire.
     * @param role Le rôle de la secrétaire.
     */
    public Secretaire(int id, String nom, String prenom, String email, String mdp, String role) {
        super(id, nom, prenom, email, mdp, role);
    }
}
