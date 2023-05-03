-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 04 mai 2023 à 00:08
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `j2ee_guichet_licence`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`) VALUES
(1, 'admin1@gmail.com', 'admin1');

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE `candidat` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `anneeBac` int(11) NOT NULL,
  `anneeDiplome` int(11) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `cne` varchar(255) DEFAULT NULL,
  `dataNaissance` date DEFAULT NULL,
  `diplome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etablissement` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `intituleBac` varchar(255) DEFAULT NULL,
  `intituleFiliere` varchar(255) DEFAULT NULL,
  `lieuNaissance` varchar(255) DEFAULT NULL,
  `moyenne1` double NOT NULL,
  `moyenne2` double NOT NULL,
  `moyenneSortie` double NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nomArabe` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `prenomArabe` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `idCandidature` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `candidat`
--

INSERT INTO `candidat` (`id`, `adresse`, `anneeBac`, `anneeDiplome`, `cin`, `cne`, `dataNaissance`, `diplome`, `email`, `etablissement`, `etat`, `intituleBac`, `intituleFiliere`, `lieuNaissance`, `moyenne1`, `moyenne2`, `moyenneSortie`, `nom`, `nomArabe`, `password`, `prenom`, `prenomArabe`, `telephone`, `ville`, `idCandidature`) VALUES
(2, '203 Bloc 3 Riyad Safi', 2017, 2021, 'HH180380', 'k142037530', '1999-11-11', 'DUT', '14e8f74260@catdogmail.live', 'EST Safi', b'0', 'Bac Sciences et Technologies Électriques', 'Génie Informatique', 'Safi', 13.5, 14.6, 14.05, 'Yassir', 'مرفوق', 'k142037530', 'Yassir', 'ياسر', '0642848255', 'Safi', 1),
(3, 'safi 203', 2017, 2021, 'HH190380', 'k12345678', '1999-11-11', 'DUT', 'bd2bdebe77@catdogmail.live', 'est', b'0', 'elect', 'info', 'safi', 13.5, 14.6, 14, 'merfouk', 'مرفوق', 'k12345678', 'yassir', 'ياسر', '0632167777', 'safi', 1);

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

CREATE TABLE `candidature` (
  `id` int(11) NOT NULL,
  `dateConcour` date DEFAULT NULL,
  `dateLimite` date DEFAULT NULL,
  `dateOuverture` date DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `nom` varchar(1000) DEFAULT NULL,
  `idFiliere` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `candidature`
--

INSERT INTO `candidature` (`id`, `dateConcour`, `dateLimite`, `dateOuverture`, `description`, `nom`, `idFiliere`) VALUES
(1, '2022-05-20', '2022-05-15', '2022-04-15', '', 'LP Metiers de l\'informatique candidature 2022', 1),
(2, '2022-05-20', '2022-05-15', '2022-04-15', '', 'LP de Gestion Comptable et Financière candidature 2022', 3),
(4, '2022-05-20', '2022-05-15', '2022-04-15', '', 'LP de Mécatronique candidature 2022', 5);

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `id` int(11) NOT NULL,
  `Description` varchar(5000) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`id`, `Description`, `nom`) VALUES
(1, 'La licence professionnelle en Métiers de l’informatique forme en une année (2 semestres) des professionnels dans le domaine des NTIC capables  d’assumer la tâche d’un chef de projet pouvant réaliser des solutions informatiques à savoir :\r\n\r\n-Concevoir et modéliser un système d’information\r\n\r\n-Développer des applications orientées objet (JAVA)\r\n\r\n-Développer des applications distribuées (j2EE)\r\n\r\n-Développer des interfaces Web\r\n\r\n-Administrer des infrastructures réseaux\r\n\r\n-Utiliser des bases de données relationnels-objet\r\n\r\n-Concevoir et implémenter des entrepôts de données.', 'LP de Métiers de l’informatique'),
(3, 'DUT TECHNIQUES DE MANAGEMENT\r\nObjectifs    \r\nLe management, dans le domaine des entreprises, consiste après avoir procédé aux études des situations et des besoins de services sur les plans commercial, administratif, productif…, à faire des choix d’ordre financier mais aussi, d’investissements, de ressources humaines .…etc.). L’objectif est de permettre à l’entreprise, dans son ensemble, d’avoir les meilleurs résultats possibles sur ses marchés.\r\n\r\nAvec l’essor technologique, le management se trouve confronté à des changements dans des domaines aussi divers que : la communication, la conduite de projets, le Marketing, la finance, les relations entre les clients et les fournisseurs.  D’où les grands enjeux de demain en matière de formation des techniciens supérieurs dans le domaine de techniques de management.\r\n\r\nLa filière DUT « Techniques de Management », (TM) forme en 2 ans, (4 semestres), des techniciens supérieurs, destinés à assurer dans les entreprises les fonctions d’encadrement et de responsabilité dans le domaine de la gestion des entreprises des secteurs privé et public, des collectivités, etc…..', 'LP de Gestion Comptable et Financière'),
(4, 'La filière Licence Professionnelle « Métrologie Qualité Sécurité Environnement » (MQSE) forme en une année (2 semestres) des cadres moyens capables d’assurer des fonctions techniques et managerielles dans les domaines de la métrologie, la qualité, la sécurité, et l’environnement au sein des entreprises et des administrions publiques ou semi- publiques.', 'LP de Métrologie Qualité Sécurité Environnement'),
(5, 'La licence professionnelle en Mécatronique se propose de compléter la formation des techniciens supérieurs possédant une spécialité de base centrée sur la mécanique, l’électronique et l’automatique pour leur apporter les connaissances technologiques transversales essentielles dans un contexte de conception et fabrication intégrée de systèmes complexes automatisés.\r\n\r\nCette filière forme en une année (2 semestres) des cadres moyens capables de concevoir et de développer des systèmes mécaniques intégrés, de contrôler et de commander des systèmes complexes mécatroniques. Ils pourront intervenir à la fois sur la mécanique, l’électronique et l’informatique et gérer les différentes étapes de projets industriels.', 'LP de Mécatronique');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `id` int(11) NOT NULL,
  `Description` varchar(5000) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `idFiliere` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`id`, `Description`, `nom`, `idFiliere`) VALUES
(1, 'C1 : la méthode MERISE\r\n\r\nC2 : Le langage UML', 'Outils et méthodes de conception des systèmes d’info', 1),
(2, 'C1 : programmation orientée objet', 'Programmation orientée objet', 1),
(3, 'C1 : programmation web en PHP\r\n\r\nC2 : le langage XML', 'Technologie Web', 1),
(4, 'C1 : entrepôts  de données\r\n\r\nC2 : systèmes d’aide à la décision', 'Informatique décisionnelle', 1),
(5, 'C1 : bases de données avancées', 'Bases de données avancées', 1),
(6, 'C1 : Programmation avancée', 'Programmation avancée : J2EE', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jl20d0ecx48g7qwy1dxe2akre` (`email`);

--
-- Index pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_o9sfa02xm1y0gq6k46667i8jy` (`cin`),
  ADD UNIQUE KEY `UK_7g5ku4jmschu5sttr0hvh9ggo` (`cne`),
  ADD UNIQUE KEY `UK_2bmoqqpwp003sjjlkqfm545n1` (`email`),
  ADD KEY `FK_1gx10l5aajg2upe9dnt2cmvvg` (`idCandidature`);

--
-- Index pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_k00r851ao8wr4e2pbpty6opw9` (`idFiliere`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ml67pqfv6121pj4fi0qnqtiol` (`nom`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_sy1o833sbpohig2lpvypd87hi` (`idFiliere`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `candidat`
--
ALTER TABLE `candidat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `candidature`
--
ALTER TABLE `candidature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD CONSTRAINT `FK_1gx10l5aajg2upe9dnt2cmvvg` FOREIGN KEY (`idCandidature`) REFERENCES `candidature` (`id`);

--
-- Contraintes pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD CONSTRAINT `FK_k00r851ao8wr4e2pbpty6opw9` FOREIGN KEY (`idFiliere`) REFERENCES `filiere` (`id`);

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `FK_sy1o833sbpohig2lpvypd87hi` FOREIGN KEY (`idFiliere`) REFERENCES `filiere` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
