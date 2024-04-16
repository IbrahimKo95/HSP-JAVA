package models;

import java.util.ArrayList;

/**
 * La classe GS représente un gestionnaire de stock.
 * Elle hérite de la classe Utilisateur.
 */
public class GS extends Utilisateur {
    /**
     * Constructeur de la classe GS.
     * @param id L'identifiant du gestionnaire de stock.
     * @param nom Le nom du gestionnaire de stock.
     * @param prenom Le prénom du gestionnaire de stock.
     * @param email L'email du gestionnaire de stock.
     * @param mdp Le mot de passe du gestionnaire de stock.
     * @param role Le rôle du gestionnaire de stock.
     */
    public GS(int id, String nom, String prenom, String email, String mdp, String role) {
        super(id, nom, prenom, email, mdp, role);
    }

}