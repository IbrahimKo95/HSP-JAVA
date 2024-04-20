package controllers;

import database.Bdd;
import models.Chambre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChambresController {
    public ArrayList<Chambre> getAllEmptyChambre() throws SQLException {
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererTout = co.prepareStatement(
                "SELECT chambres.* FROM chambres LEFT JOIN hospitalisations ON chambres.id = hospitalisations.id_chambre WHERE hospitalisations.id_chambre IS NULL;");
        ResultSet res = recupererTout.executeQuery();
        ArrayList<Chambre> chambres = new ArrayList<>();
        while (res.next()) {
            int id = res.getInt("id");
            int numero = res.getInt("numero");
            chambres.add(new Chambre(id,numero));
        }
        return chambres;
    }
    public int getByNumero(int numero) throws SQLException{
        Bdd bdd = new Bdd();
        Connection co = bdd.getInstance();
        PreparedStatement recupererId = co.prepareStatement(
                "SELECT id FROM chambres WHERE numero = ?");
        recupererId.setInt(1, numero);
        int idChambre = -1;
        try (ResultSet res = recupererId.executeQuery()) {
            if (res.next()) {
                idChambre = res.getInt("id");
            }
        }

        return idChambre;
    }


}
