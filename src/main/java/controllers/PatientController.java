package controllers;

import database.Bdd;
import models.DossierPatient;
import models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientController {
    public Patient getById(int id) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recuperer = co.prepareStatement(
                "SELECT*FROM patients  WHERE id = ?");
        recuperer.setInt(1, id);
        ResultSet res = recuperer.executeQuery();
        res.next();
        ArrayList<Patient> Patients = new ArrayList<>();

        return new Patient(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getInt(8));

    }
}

