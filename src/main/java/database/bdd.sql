CREATE TABLE Utilisateurs(
   id INT,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   role VARCHAR(255) NOT NULL,
   mdp VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(email)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;

CREATE TABLE Patients(
   id INT,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255) NOT NULL,
   num_secu VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   tel INT NOT NULL,
   adresse VARCHAR(255) NOT NULL,
   id_secretaire INT,
   PRIMARY KEY(id),
   FOREIGN KEY(id_secretaire) REFERENCES Utilisateurs(id)
);

CREATE TABLE Dossiers_patients(
   id INT,
   date_venue DATE NOT NULL,
   heure_venue TIME NOT NULL,
   gravite INT NOT NULL,
   symptomes TEXT NOT NULL,
   conclusion BOOLEAN,
   id_medecin INT,
   id_patient INT NOT NULL,
   id_secretaire INT,
   PRIMARY KEY(id),
   FOREIGN KEY(id_medecin) REFERENCES Utilisateurs(id),
   FOREIGN KEY(id_patient) REFERENCES Patients(id),
   FOREIGN KEY(id_secretaire) REFERENCES Utilisateurs(id)
);

CREATE TABLE Chambres(
   id VARCHAR(50),
   numero INT NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Demandes_produits(
   id INT,
   raison TEXT NOT NULL,
   statut INT NOT NULL,
   id_gs INT,
   id_medecin INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_gs) REFERENCES Utilisateurs(id),
   FOREIGN KEY(id_medecin) REFERENCES Utilisateurs(id)
);

CREATE TABLE Fiches_produits(
   id INT,
   libelle VARCHAR(255) NOT NULL,
   description TEXT NOT NULL,
   niv_dangerosite INT NOT NULL,
   qte_stock INT,
   id_gs INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_gs) REFERENCES Utilisateurs(id)
);

CREATE TABLE Fournisseurs(
   id INT,
   nom VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Commande_Produit(
   id INT,
   raison TEXT NOT NULL,
   statut INT NOT NULL,
   id_gs INT NOT NULL,
   id_fournisseur INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_gs) REFERENCES Utilisateurs(id),
   FOREIGN KEY(id_fournisseur) REFERENCES Fournisseurs(id)
);

CREATE TABLE Hospitalisations(
   id INT,
   date_hospitalisation DATE NOT NULL,
   heure_hospitalisation TIME NOT NULL,
   date_fin_hospitalisation DATETIME,
   id_chambre VARCHAR(50) NOT NULL,
   id_dossier INT NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(id_dossier),
   FOREIGN KEY(id_chambre) REFERENCES Chambres(id),
   FOREIGN KEY(id_dossier) REFERENCES Dossiers_patients(id)
);

CREATE TABLE Produits(
   id_fiche_produit INT,
   id_fournisseur INT,
   prix DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(id_fiche_produit, id_fournisseur),
   FOREIGN KEY(id_fiche_produit) REFERENCES Fiches_produits(id),
   FOREIGN KEY(id_fournisseur) REFERENCES Fournisseurs(id)
);

CREATE TABLE Demandes_concerne(
   id_demande_produit INT,
   id_fiche_produit INT,
   quantite VARCHAR(50),
   PRIMARY KEY(id_demande_produit, id_fiche_produit),
   FOREIGN KEY(id_demande_produit) REFERENCES Demandes_produits(id),
   FOREIGN KEY(id_fiche_produit) REFERENCES Fiches_produits(id)
);

CREATE TABLE Commandes_concerne(
   id_fiche_produit INT,
   id_commande INT,
   quantite VARCHAR(50),
   PRIMARY KEY(id_fiche_produit, id_commande),
   FOREIGN KEY(id_fiche_produit) REFERENCES Fiches_produits(id),
   FOREIGN KEY(id_commande) REFERENCES Commande_Produit(id)
);
