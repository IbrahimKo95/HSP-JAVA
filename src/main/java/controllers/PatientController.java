package controllers;

import database.Bdd;
import models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe gère les opérations liées aux patients dans l'application.
 */
public class PatientController {

    /**
     * Récupère un patient spécifique par son identifiant.
     *
     * @param id L'identifiant du patient à récupérer.
     * @return Le patient correspondant à l'identifiant spécifié.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public Patient getById(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recuperer = co.prepareStatement(
                "SELECT * FROM patients  WHERE id = ?");
        recuperer.setInt(1, id);
        ResultSet res = recuperer.executeQuery();
        res.next();
        return new Patient(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getInt(8));
    }

    /**
     * Récupère tous les patients enregistrés dans la base de données.
     *
     * @return Une liste contenant tous les patients enregistrés.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<Patient> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recuperer = co.prepareStatement(
                "SELECT * FROM patients");
        ResultSet res = recuperer.executeQuery();
        ArrayList<Patient> Patients = new ArrayList<>();
        while (res.next()) {
            Patients.add(new Patient(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getInt(8)));
        }
        return Patients;
    }

    /**
     * Ajoute un nouveau patient à la base de données.
     *
     * @param prenom        Le prénom du patient.
     * @param nom           Le nom du patient.
     * @param num_secu      Le numéro de sécurité sociale du patient.
     * @param email         L'adresse email du patient.
     * @param adresse       L'adresse du patient.
     * @param telephone     Le numéro de téléphone du patient.
     * @param id_secretaire L'identifiant de la secrétaire associée au patient.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void add(String prenom, String nom, String num_secu, String email, String adresse, String telephone, int id_secretaire) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement add = co.prepareStatement(
                "INSERT INTO patients (nom, prenom, num_secu, email, adresse, tel) VALUES (?,?,?,?,?,?)");
        add.setString(1, nom);
        add.setString(2, prenom);
        add.setString(3, num_secu);
        add.setString(4, email);
        add.setString(5, adresse);
        add.setString(6, telephone);
        add.executeUpdate();
    }
}
