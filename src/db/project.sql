-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net--
-- Host: localhost
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project`
--
-- --------------------------------------------------------
--
-- Table structure for table `iceorder`
--

CREATE TABLE IF NOT EXISTS `iceorder` (
  `ordertime` varchar(60) DEFAULT NULL,
  `flavor` char(20) DEFAULT NULL,
  `toppings` varchar(60) DEFAULT NULL,  
  `phone` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `id` char(9) NOT NULL,
  `lastName` varchar(15) DEFAULT NULL,
  `firstName` varchar(15) DEFAULT NULL,  
  `city` varchar(20) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `telephone` char(10) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--


INSERT INTO `staff` (`id`, `lastName`, `firstName`, `city`, `state`, `telephone`, `email`) VALUES
('1', 'SomeLastname', 'Afirst',  'Lincroft', 'NJ', '7322242993', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;