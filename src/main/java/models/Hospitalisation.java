package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Hospitalisation {
    private int id;
    private LocalDate date_hospitalisation;
    private LocalTime heure_hospitalisation;
    private LocalDate date_fin_hospitalisation;
    private int id_dossier;
    private Chambre chambres;
}
