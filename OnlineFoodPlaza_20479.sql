-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 20, 2017 at 09:49 AM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.4-7ubuntu2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `OnlineFoodPlaza_20479`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_20479`
--

CREATE TABLE `admin_20479` (
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_20479`
--

INSERT INTO `admin_20479` (`email`, `password`) VALUES
('madhuri@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `cart_20479`
--

CREATE TABLE `cart_20479` (
  `cart_id` int(11) NOT NULL,
  `foodid` int(11) DEFAULT NULL,
  `foodprice` double DEFAULT NULL,
  `foodname` varchar(500) DEFAULT NULL,
  `custemailid` varchar(500) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart_20479`
--

INSERT INTO `cart_20479` (`cart_id`, `foodid`, `foodprice`, `foodname`, `custemailid`, `quantity`) VALUES
(3, 2, 12, 'vadapav', 'madhuri123@yahoo.com', 2),
(6, 1, 0, NULL, 'kirti21896', 2),
(7, 1, 0, NULL, 'madhuri123@yahoo.com', 3),
(8, 3, 60, 'pavBhaji', 'madhuri123@yahoo.com', 3),
(9, 3, 60, 'pavBhaji', 'madhuri123@yahoo.com', 3),
(11, 2, 12, 'vadapav', 'kirti21896', 2),
(12, 3, 60, 'pavBhaji', 'kirti21896', 2);

-- --------------------------------------------------------

--
-- Table structure for table `customer_20479`
--

CREATE TABLE `customer_20479` (
  `custid` int(11) NOT NULL,
  `custname` varchar(50) DEFAULT NULL,
  `custadd` varchar(500) DEFAULT NULL,
  `custphone` mediumtext,
  `custpassword` varchar(50) DEFAULT NULL,
  `custemailid` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_20479`
--

INSERT INTO `customer_20479` (`custid`, `custname`, `custadd`, `custphone`, `custpassword`, `custemailid`) VALUES
(1, 'Madhuri', 'Kamothe\r\n', '9112676496', 'abc@123', 'madhuri@gmail.com'),
(2, 'kirti', 'kamothe', '4463', 'kirti', 'kirti@gmail.com'),
(3, 'preethi', 'kulaba', '546218', 'preethi', 'preethi@gmail.com'),
(4, 'mrudu', 'mulund', '4857814', 'dWS', 'mrudu@gmail.com'),
(5, 'madhuri', 'kamothe', '9112676496', '123456789', 'abc@gmail.com'),
(6, 'paresh', 'jalgaon', '9096278685', '9096278685', 'paresh@gmail.com'),
(7, 'ketan', 'pune', '9874563210', '123456', 'ketan@gmail.com'),
(8, 'akash', 'pen', '546231', '987456', 'akash@gmail.com'),
(9, 'vaishu', 'pune', '32564', '123', 'vaishu@gmail.com'),
(10, 'vaishali', 'puna', '1234567899', '123', 'vaishu@gmail.com'),
(12, 'madhuri', 'kamothe', '1234567890', '1423', 'abce@gmail.com'),
(14, 'aakash', 'pen', '7896541230', '45632', 'a@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `food_20479`
--

CREATE TABLE `food_20479` (
  `foodid` int(11) NOT NULL,
  `foodname` varchar(500) DEFAULT NULL,
  `foodprice` double DEFAULT NULL,
  `foodcategory` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_20479`
--

INSERT INTO `food_20479` (`foodid`, `foodname`, `foodprice`, `foodcategory`) VALUES
(2, 'vada', 14, 'breakfast'),
(3, 'pavbhaji', 50, 'veg'),
(5, 'poha', 20, 'Veg'),
(6, 'Fishcurry', 100, 'Non-veg');

-- --------------------------------------------------------

--
-- Table structure for table `order_20479`
--

CREATE TABLE `order_20479` (
  `orderid` int(11) NOT NULL,
  `custemailid` varchar(500) DEFAULT NULL,
  `totalbill` double DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_20479`
--

INSERT INTO `order_20479` (`orderid`, `custemailid`, `totalbill`, `status`, `date`) VALUES
(1, 'madhuri@gmail.com', 200, 'processing..', '2016-02-12'),
(3, 'paresh123@gmail.com', 204, 'processing', '2016-02-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart_20479`
--
ALTER TABLE `cart_20479`
  ADD PRIMARY KEY (`cart_id`);

--
-- Indexes for table `customer_20479`
--
ALTER TABLE `customer_20479`
  ADD PRIMARY KEY (`custid`);

--
-- Indexes for table `food_20479`
--
ALTER TABLE `food_20479`
  ADD PRIMARY KEY (`foodid`);

--
-- Indexes for table `order_20479`
--
ALTER TABLE `order_20479`
  ADD PRIMARY KEY (`orderid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart_20479`
--
ALTER TABLE `cart_20479`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `customer_20479`
--
ALTER TABLE `customer_20479`
  MODIFY `custid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `food_20479`
--
ALTER TABLE `food_20479`
  MODIFY `foodid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `order_20479`
--
ALTER TABLE `order_20479`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
