package controllers;

import database.Bdd;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class HospitalisationController {

    public void valideHospitalisation (LocalDate dateHospitalisation, LocalTime heureHospitalisation, LocalDate dateFinHospitalisation, int idChambre, int idDossier) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement add = co.prepareStatement(
                "INSERT INTO hospitalisations (date_hospitalisation, heure_hospitalisation,date_fin_hospitalisation,id_chambre,id_dossier) VALUES (?,?,?,?,?)");

        add.setDate(1, Date.valueOf(dateHospitalisation));
        add.setTime(2, Time.valueOf(heureHospitalisation));
        add.setDate(3, Date.valueOf(dateFinHospitalisation));
        add.setInt(4, idChambre);
        add.setInt(5, idDossier);

        add.executeUpdate();
    }
}
