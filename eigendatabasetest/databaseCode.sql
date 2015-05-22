-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 19 mei 2015 om 13:28
-- Serverversie: 5.5.34
-- PHP-versie: 5.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `karsbaj97_tzt`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `kredietomzetting`
--

CREATE TABLE IF NOT EXISTS `kredietomzetting` (
  `treinkoerier` int(11) NOT NULL AUTO_INCREMENT,
  `datum` datetime NOT NULL,
  `bedrag` double NOT NULL,
  `isafgehandeld` tinyint(1) DEFAULT NULL,
  `type` varchar(10) NOT NULL,
  `goedgekeurd` tinyint(1) NOT NULL,
  PRIMARY KEY (`treinkoerier`,`datum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `locatie`
--

CREATE TABLE IF NOT EXISTS `locatie` (
  `locatienr` int(11) NOT NULL AUTO_INCREMENT,
  `straat` varchar(50) NOT NULL,
  `huisnummer` varchar(5) NOT NULL,
  `plaats` varchar(25) NOT NULL,
  `postcode` varchar(9) NOT NULL,
  PRIMARY KEY (`locatienr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=64 ;

--
-- Gegevens worden uitgevoerd voor tabel `locatie`
--

INSERT INTO `locatie` (`locatienr`, `straat`, `huisnummer`, `plaats`, `postcode`) VALUES
(1, 'Stationsweg', '5B', 'Zwolle', '1234AB'),
(50, 'pOEPWEG', '4', 'Nunspeet', '8071 SN'),
(55, 'van der laenstraat', '15', 'Zwolle', '8012TA'),
(56, 'Voskuilersteeg', '3', 'Hattemerbroek', '8094PA'),
(57, 'tulpstraat', '53', 'Zwolle', '8012BG'),
(58, 'tulpstraat', '53', 'Zwolle', '8012BG'),
(59, 'Jan Hissink Jansenstraat', '6', 'Groningen', '9713HV'),
(60, '12333', '12', '123', '2121 sn'),
(61, '', '', '', ''),
(62, 'kaas', '4k', 'kaaaaaas', '8012 kas'),
(63, 'Hoge Bijsselsepad', '4', 'Nunspeet', '8071sn');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `pakket`
--

CREATE TABLE IF NOT EXISTS `pakket` (
  `pakketID` int(11) NOT NULL AUTO_INCREMENT,
  `gewicht` double NOT NULL,
  `formaat` varchar(50) NOT NULL,
  `opmerking` varchar(200) DEFAULT NULL,
  `kosten` double DEFAULT NULL,
  `orderID` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pakketID`),
  KEY `fk_Pakket_Order1_idx` (`orderID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Gegevens worden uitgevoerd voor tabel `pakket`
--

INSERT INTO `pakket` (`pakketID`, `gewicht`, `formaat`, `opmerking`, `kosten`, `orderID`, `status`) VALUES
(1, 200, '20x20x13', 'Breekbaar', 2, 1, 'Aangemeld'),
(2, 300, '20x20x13', 'Zwaar', 2, 1, 'Verzonden'),
(23, 5, 'Lengte 12cm Breedte 12cm Hoogte 10cm', 'breekbaar', NULL, 7, ' ');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `probleem`
--

CREATE TABLE IF NOT EXISTS `probleem` (
  `probleemID` int(11) NOT NULL AUTO_INCREMENT,
  `beschrijving` varchar(500) NOT NULL,
  `datum` datetime NOT NULL,
  `titel` varchar(45) NOT NULL,
  `afgehandeld` tinyint(1) NOT NULL,
  `pakketID` int(11) DEFAULT NULL,
  `trajectID` int(11) DEFAULT NULL,
  PRIMARY KEY (`probleemID`),
  KEY `fk_probleem_pakket1_idx` (`pakketID`),
  KEY `fk_probleem_traject1_idx` (`trajectID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `reis`
--

CREATE TABLE IF NOT EXISTS `reis` (
  `reisID` int(11) NOT NULL AUTO_INCREMENT,
  `beginlocatie` int(11) NOT NULL,
  `eindlocatie` int(11) NOT NULL,
  `vertrektijd` datetime DEFAULT NULL,
  `aankomsttijd` datetime DEFAULT NULL,
  `koerierID` int(11) NOT NULL,
  `weekelijks` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`reisID`),
  UNIQUE KEY `trajectid_UNIQUE` (`reisID`),
  KEY `fk_voorkeurstraject_stakeholder1_idx` (`koerierID`),
  KEY `fk_reis_locatie1_idx` (`beginlocatie`),
  KEY `fk_reis_locatie2_idx` (`eindlocatie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Gegevens worden uitgevoerd voor tabel `reis`
--

INSERT INTO `reis` (`reisID`, `beginlocatie`, `eindlocatie`, `vertrektijd`, `aankomsttijd`, `koerierID`, `weekelijks`) VALUES
(1, 1, 50, '2015-05-20 06:00:00', '2015-05-20 07:00:00', 1, NULL),
(2, 59, 63, '2015-05-19 10:00:00', '2015-05-19 15:00:00', 48, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `stakeholder`
--

CREATE TABLE IF NOT EXISTS `stakeholder` (
  `stakeholderID` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `naam` varchar(30) NOT NULL,
  `achternaam` varchar(30) DEFAULT NULL,
  `emailadres` varchar(40) NOT NULL,
  `telefoonnr` varchar(20) DEFAULT NULL,
  `idkaart` varchar(200) DEFAULT NULL,
  `ovkaart` varchar(200) DEFAULT NULL,
  `krediet` double DEFAULT NULL,
  `wachtwoord` varchar(50) DEFAULT NULL,
  `locatie` int(11) DEFAULT NULL,
  `snelheid` double DEFAULT NULL,
  `rekeningnr` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stakeholderID`),
  UNIQUE KEY `emailadres` (`emailadres`),
  KEY `fk_Stakeholder_Locatie1_idx` (`locatie`),
  KEY `fk_Stakeholder_StakeholderType1_idx` (`type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=109 ;

--
-- Gegevens worden uitgevoerd voor tabel `stakeholder`
--

INSERT INTO `stakeholder` (`stakeholderID`, `type`, `naam`, `achternaam`, `emailadres`, `telefoonnr`, `idkaart`, `ovkaart`, `krediet`, `wachtwoord`, `locatie`, `snelheid`, `rekeningnr`) VALUES
(1, 2, 'Test', 'Tester', 'test', '636546686', 'link naar IDkaartscan', 'link naar OVscan', 1337, 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3', 1, NULL, 'NL99 INGB 123456789'),
(4, 1, 'Kars', 'Barendrecht', 'kars-93@hotmail.com', '0618884901', NULL, NULL, NULL, 'f39e7a7a9b170335306b711135df17b698d1c27a', 1, NULL, NULL),
(6, 1, 'Michiel', 'Janssen', 'michielmetmij@hotmail.com', '0681106418', NULL, NULL, NULL, '37923c8fa86bed47abdba1417c052cf9b8368753', 1, NULL, NULL),
(17, 1, 'Twan', 'van Gelder', 'TNvGelder@gmail.com', '023423423', NULL, NULL, NULL, '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 1, NULL, NULL),
(19, 1, 'Jasper', 'Folkertsma', 'jasperfolkertsma@gmail.com', '06-123456', NULL, NULL, NULL, 'd9ff1b0937787f14be61bd7b7fa1506bd57c32c1', 1, NULL, NULL),
(43, 1, 'Youri Jan Gerrit', 'van Dorp', 'yourivandorp@gmail.com', '0613052882', NULL, NULL, NULL, 'c2068385fc236200d7604b9a92ae0e124f52ae43', 50, NULL, NULL),
(48, 1, 'Edwin', 'van Halem', 'edwinvanhalem@gmail.com', '0629532920', NULL, NULL, NULL, '25c57b0ee911ae516903bb6c1cf638441b77cdd4', 55, NULL, NULL),
(49, 1, 'test2', 'tester', 'test2@test.nl', '06', NULL, NULL, NULL, 'ab4d8d2a5f480a137067da17100271cd176607a1', 58, NULL, NULL),
(51, 3, '1', '1212', '12', NULL, NULL, NULL, NULL, NULL, 60, NULL, NULL),
(88, 4, 'De Fietskoeriers', NULL, 'defietskoeriers@live.nl', '0381234567', NULL, NULL, NULL, NULL, NULL, NULL, 'NL29INGB0001234567'),
(89, 4, 'Bodekoeriers', NULL, 'bodekoeriers@live.nl', '0389876543', NULL, NULL, NULL, NULL, NULL, NULL, 'NL29INGB00037489988'),
(90, 4, 'Pietersen Transport BV', NULL, 'pietersentransportbv@live.nl', '033845715962', NULL, NULL, NULL, NULL, NULL, NULL, 'NL21INGB000147852369'),
(91, 3, '', '', '', NULL, NULL, NULL, NULL, NULL, 61, NULL, NULL),
(92, 4, 'Henkie', 'Hank', 'henkie@gmail.com', '06-68485552', 'link', 'link', 10.1, 'wachtwoord1', 1, 19.2, 'NL24INGB0148574474'),
(102, 4, 'jaspah', NULL, 'jaspah@GGWP.uk', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(103, 4, 'richard', NULL, 'mailRichard@richard.nl', '06-79874654651', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(104, 4, 'henk', NULL, 'mail@henkie.com', '06-795465112', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(105, 4, 'testing', NULL, 'em;laijd;lkjaoisj@adkjf.com', '06854651321', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(106, 4, 'tester', NULL, 't@t.nl', '516513206435', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(107, 3, 'kas', 'kas', 'kaas@kas.nl', NULL, NULL, NULL, NULL, NULL, 62, NULL, NULL),
(108, 3, 'youri', 'van dorp', 'killmonster007@gmail.com', NULL, NULL, NULL, NULL, NULL, 63, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `stakeholdertype`
--

CREATE TABLE IF NOT EXISTS `stakeholdertype` (
  `typeID` int(11) NOT NULL,
  `typenaam` varchar(45) NOT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `stakeholdertype`
--

INSERT INTO `stakeholdertype` (`typeID`, `typenaam`) VALUES
(1, 'gebruiker'),
(2, 'geverifieerd'),
(3, 'ontvanger'),
(4, 'koeriersdienst');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `tarief`
--

CREATE TABLE IF NOT EXISTS `tarief` (
  `koeriersID` int(11) NOT NULL AUTO_INCREMENT,
  `km` int(11) NOT NULL,
  `prijs` double NOT NULL,
  `extraprijs` double NOT NULL,
  PRIMARY KEY (`koeriersID`,`km`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `traject`
--

CREATE TABLE IF NOT EXISTS `traject` (
  `trajectID` int(11) NOT NULL AUTO_INCREMENT,
  `pakketID` int(11) NOT NULL,
  `afhaaltijd` datetime DEFAULT NULL,
  `aflevertijd` datetime DEFAULT NULL,
  `reisID` int(11) NOT NULL,
  PRIMARY KEY (`trajectID`),
  KEY `fk_traject_voorkeurstraject1_idx` (`reisID`),
  KEY `fk_traject_pakket1_idx` (`pakketID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `verzendorder`
--

CREATE TABLE IF NOT EXISTS `verzendorder` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `klantID` int(11) NOT NULL,
  `aanmeldtijd` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `definitief` tinyint(1) NOT NULL,
  `beginlocatie` int(11) NOT NULL,
  `eindlocatie` int(11) NOT NULL,
  `afstand` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `orderID_UNIQUE` (`orderID`),
  KEY `fk_Order_Stakeholder1_idx` (`klantID`),
  KEY `fk_verzendorder_locatie1_idx` (`eindlocatie`),
  KEY `fk_verzendorder_locatie2_idx` (`beginlocatie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Gegevens worden uitgevoerd voor tabel `verzendorder`
--

INSERT INTO `verzendorder` (`orderID`, `klantID`, `aanmeldtijd`, `definitief`, `beginlocatie`, `eindlocatie`, `afstand`) VALUES
(1, 1, '2015-05-12 16:32:14', 1, 1, 50, NULL),
(7, 43, '2015-05-19 11:09:05', 1, 50, 63, NULL);

--
-- Beperkingen voor gedumpte tabellen
--

--
-- Beperkingen voor tabel `kredietomzetting`
--
ALTER TABLE `kredietomzetting`
  ADD CONSTRAINT `fk_KredietOmzetting_Stakeholder1` FOREIGN KEY (`treinkoerier`) REFERENCES `stakeholder` (`stakeholderID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `pakket`
--
ALTER TABLE `pakket`
  ADD CONSTRAINT `fk_Pakket_Order1` FOREIGN KEY (`orderID`) REFERENCES `verzendorder` (`orderID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `probleem`
--
ALTER TABLE `probleem`
  ADD CONSTRAINT `fk_probleem_pakket1` FOREIGN KEY (`pakketID`) REFERENCES `pakket` (`pakketID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_probleem_traject1` FOREIGN KEY (`trajectID`) REFERENCES `traject` (`trajectID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `reis`
--
ALTER TABLE `reis`
  ADD CONSTRAINT `fk_voorkeurstraject_stakeholder1` FOREIGN KEY (`koerierID`) REFERENCES `stakeholder` (`stakeholderID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reis_locatie1` FOREIGN KEY (`beginlocatie`) REFERENCES `locatie` (`locatienr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reis_locatie2` FOREIGN KEY (`eindlocatie`) REFERENCES `locatie` (`locatienr`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `stakeholder`
--
ALTER TABLE `stakeholder`
  ADD CONSTRAINT `fk_Stakeholder_Locatie1` FOREIGN KEY (`locatie`) REFERENCES `locatie` (`locatienr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Stakeholder_StakeholderType1` FOREIGN KEY (`type`) REFERENCES `stakeholdertype` (`typeID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `tarief`
--
ALTER TABLE `tarief`
  ADD CONSTRAINT `fk_Tarief_Stakeholder1` FOREIGN KEY (`koeriersID`) REFERENCES `stakeholder` (`stakeholderID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `traject`
--
ALTER TABLE `traject`
  ADD CONSTRAINT `fk_traject_voorkeurstraject1` FOREIGN KEY (`reisID`) REFERENCES `reis` (`reisID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_traject_pakket1` FOREIGN KEY (`pakketID`) REFERENCES `pakket` (`pakketID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Beperkingen voor tabel `verzendorder`
--
ALTER TABLE `verzendorder`
  ADD CONSTRAINT `fk_Order_Stakeholder1` FOREIGN KEY (`klantID`) REFERENCES `stakeholder` (`stakeholderID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_verzendorder_locatie1` FOREIGN KEY (`eindlocatie`) REFERENCES `locatie` (`locatienr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_verzendorder_locatie2` FOREIGN KEY (`beginlocatie`) REFERENCES `locatie` (`locatienr`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
