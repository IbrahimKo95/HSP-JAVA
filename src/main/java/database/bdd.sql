-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 16 avr. 2024 à 16:58
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `rhp-java`
--

-- --------------------------------------------------------

--
-- Structure de la table `chambres`
--

DROP TABLE IF EXISTS `chambres`;
CREATE TABLE IF NOT EXISTS `chambres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commandes_concerne`
--

DROP TABLE IF EXISTS `commandes_concerne`;
CREATE TABLE IF NOT EXISTS `commandes_concerne` (
  `id_fiche_produit` int NOT NULL,
  `id_commande` int NOT NULL,
  `quantite` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_fiche_produit`,`id_commande`),
  KEY `id_commande` (`id_commande`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande_produit`
--

DROP TABLE IF EXISTS `commande_produit`;
CREATE TABLE IF NOT EXISTS `commande_produit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `raison` text NOT NULL,
  `statut` int NOT NULL,
  `id_gs` int NOT NULL,
  `id_fournisseur` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_gs` (`id_gs`),
  KEY `id_fournisseur` (`id_fournisseur`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `demandes_concerne`
--

DROP TABLE IF EXISTS `demandes_concerne`;
CREATE TABLE IF NOT EXISTS `demandes_concerne` (
  `id_demande_produit` int NOT NULL,
  `id_fiche_produit` int NOT NULL,
  `quantite` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_demande_produit`,`id_fiche_produit`),
  KEY `id_fiche_produit` (`id_fiche_produit`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `demandes_produits`
--

DROP TABLE IF EXISTS `demandes_produits`;
CREATE TABLE IF NOT EXISTS `demandes_produits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `raison` text NOT NULL,
  `statut` int NOT NULL,
  `id_gs` int DEFAULT NULL,
  `id_medecin` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_gs` (`id_gs`),
  KEY `id_medecin` (`id_medecin`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `dossiers_patients`
--

DROP TABLE IF EXISTS `dossiers_patients`;
CREATE TABLE IF NOT EXISTS `dossiers_patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_venue` date NOT NULL,
  `heure_venue` time NOT NULL,
  `gravite` int NOT NULL,
  `symptomes` text NOT NULL,
  `conclusion` int DEFAULT NULL,
  `id_medecin` int DEFAULT NULL,
  `id_patient` int NOT NULL,
  `id_secretaire` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_medecin` (`id_medecin`),
  KEY `id_patient` (`id_patient`),
  KEY `id_secretaire` (`id_secretaire`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fiches_produits`
--

DROP TABLE IF EXISTS `fiches_produits`;
CREATE TABLE IF NOT EXISTS `fiches_produits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `niv_dangerosite` int NOT NULL,
  `qte_stock` int DEFAULT NULL,
  `id_gs` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_gs` (`id_gs`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseurs`
--

DROP TABLE IF EXISTS `fournisseurs`;
CREATE TABLE IF NOT EXISTS `fournisseurs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hospitalisations`
--

DROP TABLE IF EXISTS `hospitalisations`;
CREATE TABLE IF NOT EXISTS `hospitalisations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_hospitalisation` date NOT NULL,
  `heure_hospitalisation` time NOT NULL,
  `date_fin_hospitalisation` datetime DEFAULT NULL,
  `id_chambre` int NOT NULL,
  `id_dossier` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_dossier` (`id_dossier`),
  KEY `id_chambre` (`id_chambre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `patients`
--

DROP TABLE IF EXISTS `patients`;
CREATE TABLE IF NOT EXISTS `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `num_secu` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` int NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `id_secretaire` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_secretaire` (`id_secretaire`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `id_fiche_produit` int NOT NULL,
  `id_fournisseur` int NOT NULL,
  `prix` decimal(15,2) NOT NULL,
  PRIMARY KEY (`id_fiche_produit`,`id_fournisseur`),
  KEY `id_fournisseur` (`id_fournisseur`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `role` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `mdp` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `nom`, `prenom`, `email`, `role`, `mdp`) VALUES
(1, 'Konaté', 'Ibrahim', 'i.konate@lprs.fr', 'gs', '098f6bcd4621d373cade4e832627b4f6'),
(15, 'Sekouri', 'Wail', 'w.sekouri@lprs.fr', 'medecin', 'a69c2e6990005408cead8fa029987bc7'),
(16, 'Goram', 'Noe', 'n.goram@lprs.fr', 'secretaire', 'fcacb45ae83c164467925d5566315c83'),
(18, 'Admin', 'Admin', 'admin@lprs.fr', 'admin', 'f6fdffe48c908deb0f4c3bd36c032e72');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
