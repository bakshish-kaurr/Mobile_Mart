-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 11, 2025 at 05:08 AM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `inventory_master`
--

-- --------------------------------------------------------

--
-- Table structure for table `party`
--

CREATE TABLE IF NOT EXISTS `party` (
  `d_id` int(20) NOT NULL,
  `d_name` varchar(20) NOT NULL,
  `company` varchar(20) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `city` varchar(20) NOT NULL,
  `balance` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `party`
--

INSERT INTO `party` (`d_id`, `d_name`, `company`, `mobile`, `city`, `balance`) VALUES
(201, 'x1', 'Samsung', '8968596000', 'fatehabad', '253593.00'),
(202, 'x2', 'Realme', '9879679686', 'delhi', '71807.80'),
(203, 'x3', 'Vivo', '9876965777', 'mumbai', '104595.80'),
(204, 'x4', 'OnePlus', '8796879678', 'hisar', '202295.00'),
(205, 'Sunil Kumar', 'Realme', '1212121212', 'ratia', '160993.00');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `d_id` int(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `bal` varchar(40) NOT NULL,
  `paid` varchar(40) NOT NULL,
  `updated_bal` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`d_id`, `name`, `bal`, `paid`, `updated_bal`) VALUES
(201, 'x1', '253593.00', '12000', '241593.00'),
(202, 'x2', '111807.80', '40000', '71807.80'),
(204, 'x4', '262295.00', '60000', '202295.00'),
(205, 'Sunil Kumar', '260993.00', '100000', '160993.00');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE IF NOT EXISTS `purchase` (
  `sr_no` int(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `d_id` int(20) NOT NULL,
  `balance` decimal(15,2) NOT NULL,
  `company` varchar(20) NOT NULL,
  `model` varchar(40) NOT NULL,
  `mrp` decimal(15,2) NOT NULL,
  `cp` decimal(15,2) NOT NULL,
  `qty` int(20) NOT NULL,
  `amt` decimal(15,2) NOT NULL,
  `updated_bal` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`sr_no`, `date`, `d_id`, `balance`, `company`, `model`, `mrp`, `cp`, `qty`, `amt`, `updated_bal`) VALUES
(401, '06-06-2025', 201, '10000.00', 'Samsung', 'Samsung Galaxy S24 Ultra', '90299.00', '63209.30', 1, '63209.30', '73209.30'),
(402, '06-06-2025', 201, '73209.30', 'Samsung', 'Samsung Galaxy A55 5G', '27999.00', '19599.30', 2, '39198.60', '112407.90'),
(403, '06-06-2025', 201, '112407.90', 'Samsung', 'Samsung Galaxy M14 5G', '13899.00', '9729.30', 3, '29187.90', '141595.80'),
(404, '06-06-2025', 201, '141595.80', 'Samsung', 'Samsung Galaxy Z Flip5', '39999.00', '27999.30', 4, '111997.20', '253593.00'),
(405, '06-06-2025', 202, '20000.00', 'Realme', 'Realme 11 Pro+ 5G', '32999.00', '23099.30', 2, '46198.60', '66198.60'),
(406, '06-06-2025', 202, '66198.60', 'Realme', 'Realme C55', '16289.00', '11402.30', 4, '45609.20', '111807.80'),
(407, '06-06-2025', 203, '15000.00', 'Vivo', 'Vivo V29 Pro', '31999.00', '22399.30', 2, '44798.60', '59798.60'),
(408, '06-06-2025', 203, '59798.60', 'Vivo', 'Vivo Y100', '15999.00', '11199.30', 4, '44797.20', '104595.80'),
(409, '06-06-2025', 204, '30000.00', 'OnePlus', 'OnePlus Nord 3 5G', '22925.00', '16047.50', 2, '32095.00', '62095.00'),
(410, '06-06-2025', 204, '62095.00', 'OnePlus', 'OnePlus Open', '71500.00', '50050.00', 2, '100100.00', '162195.00'),
(411, '06-06-2025', 204, '162195.00', 'OnePlus', 'OnePlus Open', '71500.00', '50050.00', 2, '100100.00', '262295.00'),
(412, '09-06-2025', 205, '30000.00', 'Realme', 'Realme 11 Pro+ 5G', '32999.00', '23099.30', 10, '230993.00', '260993.00');

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE IF NOT EXISTS `sale` (
  `bill_no` int(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `cust_name` varchar(20) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `company` varchar(20) NOT NULL,
  `model` varchar(30) NOT NULL,
  `total_qty` int(20) NOT NULL,
  `sale_qty` int(20) NOT NULL,
  `amt` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`bill_no`, `date`, `cust_name`, `mob`, `company`, `model`, `total_qty`, `sale_qty`, `amt`) VALUES
(601, '06-06-2025', 'amit', '8745867476', 'Samsung', 'Samsung Galaxy Z Flip5', 4, 1, 39999),
(602, '06-06-2025', 'rohit', '7865868555', 'OnePlus', 'OnePlus Open', 4, 2, 143000),
(603, '09-06-2025', 'aman', '1111111111', 'Realme', 'Realme 11 Pro+ 5G', 12, 3, 98997);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `sr_no` int(20) NOT NULL,
  `company` varchar(40) NOT NULL,
  `model` varchar(40) NOT NULL,
  `mrp` varchar(40) NOT NULL,
  `qty` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`sr_no`, `company`, `model`, `mrp`, `qty`) VALUES
(501, 'Samsung', 'Samsung Galaxy S24 Ultra', '90299', '1'),
(502, 'Samsung', 'Samsung Galaxy A55 5G', '27999', '2'),
(503, 'Samsung', 'Samsung Galaxy M14 5G', '13899', '3'),
(504, 'Samsung', 'Samsung Galaxy Z Flip5', '39999', '3'),
(505, 'Realme', 'Realme 11 Pro+ 5G', '32999', '9'),
(506, 'Realme', 'Realme C55', '16289', '4'),
(507, 'Vivo', 'Vivo V29 Pro', '31999', '2'),
(508, 'Vivo', 'Vivo Y100', '15999', '4'),
(509, 'OnePlus', 'OnePlus Nord 3 5G', '22925', '2'),
(510, 'OnePlus', 'OnePlus Open', '71500', '2');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `mobile` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `mobile`, `city`) VALUES
(101, 'Admin', 'admin11', '9679797967', 'hisar'),
(102, 'mohit', 'mt', '8768768786', 'sirsa'),
(104, 'bakshish', 'baksh123', '5767868888', 'hisar'),
(105, 'deepak', 'a', '1111111111', 'sirsa');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
