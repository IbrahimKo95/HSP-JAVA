package controllers;

import database.Bdd;
import models.DossierPatient;
import models.FicheProduit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DossierPatientController {
    public ArrayList<DossierPatient> getAll() throws SQLException  {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT*FROM dossiers_patients");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<DossierPatient> dossierPatients = new ArrayList<>();
        while(res.next()){
            dossierPatients.add(new DossierPatient(res.getInt(1), res.getDate(2).toLocalDate(), res.getTime(3).toLocalTime(), res.getInt(4), res.getString(5), res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9)));
        }
        return dossierPatients;
    }

}

