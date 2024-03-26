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
                "SELECT*FROM dossiers_patients WHERE id_medecin is null");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<DossierPatient> dossierPatients = new ArrayList<>();
        while(res.next()){
            dossierPatients.add(new DossierPatient(res.getInt(1), res.getDate(2).toLocalDate(), res.getTime(3).toLocalTime(), res.getInt(4), res.getString(5), res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9)));
        }

        return dossierPatients;
    }

   public ArrayList<DossierPatient> getByIdMed(int id) throws SQLException {
       Bdd bdd = new Bdd();
       Connection co = bdd.getInstance();
       PreparedStatement recuperer = co.prepareStatement(
               "SELECT*FROM dossiers_patients  WHERE id_medecin = ?");
       recuperer.setInt(1, id);
       ResultSet res = recuperer.executeQuery();
       ArrayList<DossierPatient> dossierPatients = new ArrayList<>();
       while(res.next()){
           dossierPatients.add(new DossierPatient(res.getInt(1), res.getDate(2).toLocalDate(), res.getTime(3).toLocalTime(), res.getInt(4), res.getString(5), res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9)));
       }
       return dossierPatients;

   }

   public void  insertId(int id,int idP) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement insert = co.prepareStatement(
                "UPDATE dossiers_patients SET id_medecin = ? WHERE id = ?");
       insert.setInt(1, id);
       insert.setInt(2, idP);
       insert.executeUpdate();

   }
   public void nullId(int idP) throws SQLException {
       Bdd bdd = new Bdd();
       Connection co = bdd.getInstance();
       PreparedStatement insert = co.prepareStatement(
               "UPDATE dossiers_patients SET id_medecin =  NULL  WHERE id = ?");
       insert.setInt(1, idP);
       insert.executeUpdate();
   }

   public void conclusion1(int idD) throws SQLException {
       Bdd bdd = new Bdd();
       Connection co = bdd.getInstance();
       PreparedStatement insert = co.prepareStatement(
               "UPDATE dossiers_patients SET conclusion =  ? WHERE id = ? ");
       insert.setInt(1, 1);
       insert.setInt(2,idD);
       insert.executeUpdate();
   }

    public void conclusion2(int idD) throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement insert = co.prepareStatement(
                "UPDATE dossiers_patients SET conclusion =  ? WHERE id = ? ");
        insert.setInt(1, 2);
        insert.setInt(2,idD);
        insert.executeUpdate();
    }
}

