package controllers;

import database.Bdd;
import models.DossierPatient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe gère les opérations liées aux dossiers patients dans l'application.
 */
public class DossierPatientController {

    /**
     * Récupère tous les dossiers patients où le champ id_medecin est nul.
     *
     * @return Une liste contenant tous les dossiers patients sans médecin assigné.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<DossierPatient> getAll() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT * FROM dossiers_patients WHERE id_medecin IS NULL");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<DossierPatient> dossierPatients = new ArrayList<>();
        while (res.next()) {
            dossierPatients.add(new DossierPatient(res.getInt(1), res.getDate(2).toLocalDate(), res.getTime(3).toLocalTime(), res.getInt(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getInt(9)));
        }

        return dossierPatients;
    }

    /**
     * Récupère tous les dossiers patients associés à un médecin spécifique.
     *
     * @param id L'identifiant du médecin.
     * @return Une liste contenant tous les dossiers patients associés au médecin spécifié.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public ArrayList<DossierPatient> getByIdMed(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recuperer = co.prepareStatement(
                "SELECT * FROM dossiers_patients WHERE id_medecin = ?");
        recuperer.setInt(1, id);
        ResultSet res = recuperer.executeQuery();
        ArrayList<DossierPatient> dossierPatients = new ArrayList<>();
        while (res.next()) {
            dossierPatients.add(new DossierPatient(res.getInt(1), res.getDate(2).toLocalDate(), res.getTime(3).toLocalTime(), res.getInt(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getInt(9)));
        }
        return dossierPatients;
    }

    /**
     * Associe un médecin à un dossier patient en mettant à jour le champ id_medecin.
     *
     * @param id  L'identifiant du médecin.
     * @param idP L'identifiant du dossier patient.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void insertId(int id, int idP) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement insert = co.prepareStatement(
                "UPDATE dossiers_patients SET id_medecin = ? WHERE id = ?");
        insert.setInt(1, id);
        insert.setInt(2, idP);
        insert.executeUpdate();
    }

    /**
     * Dissocie un médecin d'un dossier patient en mettant à jour le champ id_medecin à NULL.
     *
     * @param idP L'identifiant du dossier patient.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void nullId(int idP) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement insert = co.prepareStatement(
                "UPDATE dossiers_patients SET id_medecin =  NULL  WHERE id = ?");
        insert.setInt(1, idP);
        insert.executeUpdate();
    }

    /**
     * Marque un dossier patient comme conclu avec un premier type de conclusion.
     *
     * @param idD L'identifiant du dossier patient.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void conclusion1(int idD) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement insert = co.prepareStatement(
                "UPDATE dossiers_patients SET conclusion =  ? WHERE id = ? ");
        insert.setInt(1, 1);
        insert.setInt(2, idD);
        insert.executeUpdate();
    }

    /**
     * Marque un dossier patient comme conclu avec un deuxième type de conclusion.
     *
     * @param idD L'identifiant du dossier patient.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void conclusion2(int idD) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement insert = co.prepareStatement(
                "UPDATE dossiers_patients SET conclusion =  ? WHERE id = ? ");
        insert.setInt(1, 2);
        insert.setInt(2, idD);
        insert.executeUpdate();
    }

    /**
     * Ajoute un nouveau dossier patient à la base de données.
     *
     * @param gravite     La gravité du dossier patient.
     * @param symptome    Les symptômes du patient.
     * @param id_secretaire L'identifiant de la secrétaire associée au dossier patient.
     * @param id_patient  L'identifiant du patient.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void add(int gravite, String symptome, int id_secretaire, int id_patient) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement insert = co.prepareStatement(
                "INSERT INTO dossiers_patients (gravite, symptomes, date_venue, heure_venue, id_secretaire, conclusion, id_patient) VALUES (?,?,CURRENT_DATE,CURRENT_TIME,?,0, ?) ");
        insert.setInt(1, gravite);
        insert.setString(2, symptome);
        insert.setInt(3, id_secretaire);
        insert.setInt(4, id_patient);
        insert.executeUpdate();
    }
}
