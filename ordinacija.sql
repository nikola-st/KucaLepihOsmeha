-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2018 at 04:06 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ordinacija`
--
CREATE DATABASE IF NOT EXISTS `ordinacija` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `ordinacija`;

-- --------------------------------------------------------

--
-- Table structure for table `bolesti`
--

CREATE TABLE `bolesti` (
  `id` int(11) NOT NULL,
  `sifra` varchar(50) NOT NULL,
  `naziv` varchar(255) NOT NULL,
  `opis` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bolesti`
--

INSERT INTO `bolesti` (`id`, `sifra`, `naziv`, `opis`) VALUES
(1, 'K02', 'Caries dentium', 'Karijes - kvar zuba'),
(2, 'K02.0', 'Caries adamantini dentium', 'Karijes gledji zuba'),
(3, 'K02.3', 'Caries dentium inhibita', 'Zaustavljen karijes zuba'),
(5, 'K03.3', 'Resorptio dentium pathologica', 'Patološka resorpcija zuba'),
(6, 'K03.4', 'Hypercaementosis', 'Hipercementoza - visak cementnog sastava zuba'),
(7, 'K03.5', 'Ancylosis dentis', 'Ankiloza zuba'),
(10, 'K02.2', 'Caries caementi dentium', 'Karijes cementa zuba'),
(11, 'K02.1', 'Caries dentini dentium', 'Karijes dentina zuba');

-- --------------------------------------------------------

--
-- Table structure for table `imasifru`
--

CREATE TABLE `imasifru` (
  `id` int(11) NOT NULL,
  `id_pregleda` int(11) NOT NULL,
  `id_bolesti` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `imasifru`
--

INSERT INTO `imasifru` (`id`, `id_pregleda`, `id_bolesti`) VALUES
(1, 2, 1),
(2, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `lekar`
--

CREATE TABLE `lekar` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lekar`
--

INSERT INTO `lekar` (`id`, `username`, `pass`) VALUES
(1, 'marija', 'bosnic');

-- --------------------------------------------------------

--
-- Table structure for table `pacijenti`
--

CREATE TABLE `pacijenti` (
  `id` int(11) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `adresa` varchar(100) NOT NULL,
  `telefon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pacijenti`
--

INSERT INTO `pacijenti` (`id`, `ime`, `prezime`, `adresa`, `telefon`) VALUES
(1, 'Nikola', 'Stojicevic', 'Vidikovacki venac 14a/II', '063281450'),
(2, 'Jelena', 'Tanaskovic', 'Branka Sotre 1a', '063525099'),
(59, 'Milica', 'Vukojevic', 'Omladinska 1', '0641115549'),
(60, 'dr Svetlana', 'Jevremovic', 'Cara Dusana 34', '061234567'),
(61, 'Nikola ', 'Nikolic', 'Gospodara Vucica 234', '065444999'),
(62, 'Milica', 'Milic', 'Makedonska 27', '061299333'),
(63, 'Petar', 'Petrovic', 'Savski nasip', '12345677');

-- --------------------------------------------------------

--
-- Table structure for table `pregledi`
--

CREATE TABLE `pregledi` (
  `id` int(11) NOT NULL,
  `datum` varchar(30) NOT NULL,
  `nalaz` text NOT NULL,
  `id_pacijenta` int(11) DEFAULT NULL,
  `id_lekara` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pregledi`
--

INSERT INTO `pregledi` (`id`, `datum`, `nalaz`, `id_pacijenta`, `id_lekara`) VALUES
(1, '2017-07-10', 'Nalaz uredan. Kamenac na 5 desno.', 1, 1),
(2, '2017-07-08', 'Karijes na 4 levo', 2, 1),
(3, '22.9.2017', 'Nalaz', 60, 1),
(11, '19.09.2017', 'Plomba', 59, 1),
(13, '20.09.2017', 'Plomba na 22', 59, 1),
(14, '21.09.2017', 'Plomba na 12', 59, 1),
(15, '24.07.2017', 'Nalaz', 2, 1),
(16, '11.09.2016', 'N', 62, 1),
(17, '22.9.2017', 'Pregled', 63, 1),
(18, '22.9.2017', 'ssss', 1, 1),
(19, '21.09.2017', 'test', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reklamacija`
--

CREATE TABLE `reklamacija` (
  `id` int(11) NOT NULL,
  `datum` varchar(30) NOT NULL,
  `opis` varchar(100) NOT NULL,
  `status` varchar(30) NOT NULL,
  `id_pacijenta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reklamacija`
--

INSERT INTO `reklamacija` (`id`, `datum`, `opis`, `status`, `id_pacijenta`) VALUES
(11, '19.09.2017', 'aaaaa', 'neresena', 59),
(12, '19.09.2017', 'aaaaa', 'neresena', 61),
(13, '22.9.2017', 'afaf', 'neresena', 59);

-- --------------------------------------------------------

--
-- Table structure for table `stavkapregleda`
--

CREATE TABLE `stavkapregleda` (
  `id` int(11) NOT NULL,
  `id_pregleda` int(11) NOT NULL,
  `id_usluge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stavkapregleda`
--

INSERT INTO `stavkapregleda` (`id`, `id_pregleda`, `id_usluge`) VALUES
(1, 2, 1),
(2, 2, 2),
(3, 2, 4),
(4, 1, 1),
(5, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `usluge`
--

CREATE TABLE `usluge` (
  `id` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL,
  `cena` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usluge`
--

INSERT INTO `usluge` (`id`, `naziv`, `cena`) VALUES
(1, 'Stomatoloski pregled', 1000),
(2, 'Amalgamski ispun jednopovršinski (crna plomba)', 1600),
(3, 'Kompozitni ispun jednopovrsinski (bela plomba)', 200),
(4, 'Direktno prekrivanje pulpe', 1000),
(5, 'Endodontsko lecenje zuba po seansi', 1000),
(6, 'Punjenje zuba po kanalu', 800),
(7, 'Lecenje gangrene po seansi', 800),
(8, 'Nadogradnja zuba sa kocicem (jedan komad)', 2000),
(9, 'Inlej keramicki', 9600),
(10, 'Inlej kompoznitni', 9600);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bolesti`
--
ALTER TABLE `bolesti`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `imasifru`
--
ALTER TABLE `imasifru`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pregled_bolesti` (`id_bolesti`),
  ADD KEY `FK_bolesti_pregled` (`id_pregleda`);

--
-- Indexes for table `lekar`
--
ALTER TABLE `lekar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pacijenti`
--
ALTER TABLE `pacijenti`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pregledi`
--
ALTER TABLE `pregledi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pregled_pacijent` (`id_pacijenta`) USING BTREE,
  ADD KEY `FK_pregled_lekar` (`id_lekara`) USING BTREE;

--
-- Indexes for table `reklamacija`
--
ALTER TABLE `reklamacija`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_reklamacija_pacijent` (`id_pacijenta`);

--
-- Indexes for table `stavkapregleda`
--
ALTER TABLE `stavkapregleda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pregled` (`id_pregleda`),
  ADD KEY `FK_usluge` (`id_usluge`);

--
-- Indexes for table `usluge`
--
ALTER TABLE `usluge`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bolesti`
--
ALTER TABLE `bolesti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `imasifru`
--
ALTER TABLE `imasifru`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `lekar`
--
ALTER TABLE `lekar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `pacijenti`
--
ALTER TABLE `pacijenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
--
-- AUTO_INCREMENT for table `pregledi`
--
ALTER TABLE `pregledi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `reklamacija`
--
ALTER TABLE `reklamacija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `stavkapregleda`
--
ALTER TABLE `stavkapregleda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `usluge`
--
ALTER TABLE `usluge`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `imasifru`
--
ALTER TABLE `imasifru`
  ADD CONSTRAINT `FK_bolesti_pregled` FOREIGN KEY (`id_pregleda`) REFERENCES `pregledi` (`id`),
  ADD CONSTRAINT `FK_pregled_bolesti` FOREIGN KEY (`id_bolesti`) REFERENCES `bolesti` (`id`);

--
-- Constraints for table `pregledi`
--
ALTER TABLE `pregledi`
  ADD CONSTRAINT `FK_pacijent_lekar` FOREIGN KEY (`id_lekara`) REFERENCES `lekar` (`id`),
  ADD CONSTRAINT `FK_pacijent_pregled` FOREIGN KEY (`id_pacijenta`) REFERENCES `pacijenti` (`id`);

--
-- Constraints for table `reklamacija`
--
ALTER TABLE `reklamacija`
  ADD CONSTRAINT `FK_reklamacija_pacijent` FOREIGN KEY (`id_pacijenta`) REFERENCES `pacijenti` (`id`);

--
-- Constraints for table `stavkapregleda`
--
ALTER TABLE `stavkapregleda`
  ADD CONSTRAINT `FK_pregled` FOREIGN KEY (`id_pregleda`) REFERENCES `pregledi` (`id`),
  ADD CONSTRAINT `FK_usluge` FOREIGN KEY (`id_usluge`) REFERENCES `usluge` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
