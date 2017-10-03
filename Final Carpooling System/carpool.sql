-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2017 at 11:21 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carpool`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `BookingID` varchar(15) NOT NULL,
  `PassengerID` varchar(15) NOT NULL,
  `TripID` varchar(15) NOT NULL,
  `DepartDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `SpotsReserved` int(2) NOT NULL DEFAULT '0',
  `BookingStatus` varchar(10) NOT NULL DEFAULT 'Pending',
  `RatingForPassenger` float DEFAULT NULL,
  `RatingForDriver` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`BookingID`, `PassengerID`, `TripID`, `DepartDateTime`, `SpotsReserved`, `BookingStatus`, `RatingForPassenger`, `RatingForDriver`) VALUES
('B1P1U1', 'P1U1', 'FT1D1U1', '2017-10-03 07:00:00', 3, 'Confirmed', 0, 0),
('B2P1U1', 'P1U1', 'FT1D1U1', '2017-01-11 11:00:00', 5, 'pending', 0, 0),
('B3P1U1', 'P1U1', 'FT1D1U1', '2017-01-11 11:00:00', 3, 'pending', 0, 0),
('B4P1U1', 'P1U1', 'FT1D1U1', '2017-01-11 11:00:00', 3, 'pending', 4.5, 0),
('B5P1U1', 'P1U1', 'FT2D1U1', '2017-01-11 11:00:00', 5, 'pending', 4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `CarID` varchar(15) NOT NULL,
  `PlateNO` varchar(15) NOT NULL,
  `DriverID` varchar(15) NOT NULL,
  `Color` varchar(10) DEFAULT NULL,
  `Type` varchar(10) DEFAULT 'MINI',
  `AC/Non_AC` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`CarID`, `PlateNO`, `DriverID`, `Color`, `Type`, `AC/Non_AC`) VALUES
('C1D1U1', 'MH18LP5111', 'D1U1', 'Red', 'MINI', 1),
('C2D1U1', 'MH17LP9596', 'D1U1', 'White', 'Sedan', 1),
('C3D1U1', 'MH19Pl987', 'D1U1', 'Red', 'MINI', 0);

-- --------------------------------------------------------

--
-- Table structure for table `driverdetails`
--

CREATE TABLE `driverdetails` (
  `DriverID` varchar(15) NOT NULL,
  `UserID` varchar(15) NOT NULL,
  `LicenceNO` varchar(15) NOT NULL,
  `Lic_issueDate` date NOT NULL,
  `Lic_expiryDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driverdetails`
--

INSERT INTO `driverdetails` (`DriverID`, `UserID`, `LicenceNO`, `Lic_issueDate`, `Lic_expiryDate`) VALUES
('D1U1', 'U1', 'Ap1098765', '2017-10-01', '2017-10-31');

-- --------------------------------------------------------

--
-- Table structure for table `passengerdetails`
--

CREATE TABLE `passengerdetails` (
  `PassengerID` varchar(15) NOT NULL,
  `UserID` varchar(15) NOT NULL,
  `IDproof` varchar(10) NOT NULL DEFAULT 'AADHAR',
  `PAN/AADHAR NO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Passenger details';

--
-- Dumping data for table `passengerdetails`
--

INSERT INTO `passengerdetails` (`PassengerID`, `UserID`, `IDproof`, `PAN/AADHAR NO`) VALUES
('P1U1', 'U1', 'AADHAR', '1234567890');

-- --------------------------------------------------------

--
-- Table structure for table `ridedetails`
--

CREATE TABLE `ridedetails` (
  `RideID` varchar(15) NOT NULL,
  `BookingId` varchar(15) NOT NULL,
  `PickUpSrc` varchar(20) NOT NULL,
  `DropDest` varchar(20) NOT NULL,
  `CheckInTime` varchar(15) NOT NULL,
  `DistTravelled` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trip`
--

CREATE TABLE `trip` (
  `TripID` varchar(15) NOT NULL,
  `DriverID` varchar(15) NOT NULL,
  `CarID` varchar(15) NOT NULL,
  `StartPoint` varchar(30) NOT NULL,
  `DestPoint` varchar(30) NOT NULL,
  `MeetingPoints` varchar(1000) DEFAULT NULL,
  `DateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Frequency` varchar(10) DEFAULT 'One time',
  `EndDate` date DEFAULT NULL,
  `SpotsAvailable` int(2) NOT NULL,
  `Preferences` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`TripID`, `DriverID`, `CarID`, `StartPoint`, `DestPoint`, `MeetingPoints`, `DateTime`, `Frequency`, `EndDate`, `SpotsAvailable`, `Preferences`) VALUES
('FT1D1U1', 'D1U1', 'C2D1U1', 'Pune', 'Mumbai', 'Pune', '2017-01-11 11:00:00', 'Daily', '2017-01-11', 1, NULL),
('FT2D1U1', 'D1U1', 'C3D1U1', 'Pune', 'Mumbai', '', '2017-01-11 11:00:00', NULL, '2017-01-11', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` varchar(15) NOT NULL,
  `Firstname` varchar(10) NOT NULL,
  `Middlename` varchar(10) DEFAULT NULL,
  `Lastname` varchar(10) NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(56) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `PhoneNo` varchar(15) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='User Information';

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `Firstname`, `Middlename`, `Lastname`, `Username`, `Password`, `Email`, `PhoneNo`) VALUES
('U1', 'Arihant', 'r', 'jain', 'uari', 'arihantjain', 'arijain34@gmail.com', '7350522332'),
('U2', 'charmi', NULL, 'valecha', 'charmi', 'charmi', 'charmivalecha22@gmail.com', '9988776655');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`BookingID`),
  ADD KEY `PassengerID` (`PassengerID`),
  ADD KEY `TripID` (`TripID`),
  ADD KEY `FK7786033AAE932917` (`PassengerID`),
  ADD KEY `FK7786033A2160300E` (`TripID`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`CarID`),
  ADD UNIQUE KEY `plateno` (`PlateNO`),
  ADD KEY `DriverID` (`DriverID`),
  ADD KEY `FK107B4CFEEE4A5` (`DriverID`);

--
-- Indexes for table `driverdetails`
--
ALTER TABLE `driverdetails`
  ADD PRIMARY KEY (`DriverID`),
  ADD UNIQUE KEY `LicenceNO` (`LicenceNO`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `FK62105D1A2321CDDA` (`UserID`);

--
-- Indexes for table `passengerdetails`
--
ALTER TABLE `passengerdetails`
  ADD PRIMARY KEY (`PassengerID`),
  ADD UNIQUE KEY `identity` (`PAN/AADHAR NO`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `FKC2781C682321CDDA` (`UserID`);

--
-- Indexes for table `ridedetails`
--
ALTER TABLE `ridedetails`
  ADD PRIMARY KEY (`RideID`),
  ADD KEY `BookingId` (`BookingId`),
  ADD KEY `FKC362024ACBED4704` (`BookingId`);

--
-- Indexes for table `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`TripID`),
  ADD KEY `DriverID` (`DriverID`),
  ADD KEY `FK27E845CFEEE4A5` (`DriverID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `phone` (`PhoneNo`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `FK7786033A2160300E` FOREIGN KEY (`TripID`) REFERENCES `trip` (`TripID`),
  ADD CONSTRAINT `FK7786033AAE932917` FOREIGN KEY (`PassengerID`) REFERENCES `passengerdetails` (`PassengerID`),
  ADD CONSTRAINT `fk_passenger_book_id` FOREIGN KEY (`PassengerID`) REFERENCES `passengerdetails` (`PassengerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_trip_book_id` FOREIGN KEY (`TripID`) REFERENCES `trip` (`TripID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `FK107B4CFEEE4A5` FOREIGN KEY (`DriverID`) REFERENCES `driverdetails` (`DriverID`),
  ADD CONSTRAINT `fk_driver_car_id` FOREIGN KEY (`DriverID`) REFERENCES `driverdetails` (`DriverID`) ON UPDATE CASCADE;

--
-- Constraints for table `driverdetails`
--
ALTER TABLE `driverdetails`
  ADD CONSTRAINT `FK62105D1A2321CDDA` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`),
  ADD CONSTRAINT `fk_driver_user_id` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON UPDATE CASCADE;

--
-- Constraints for table `passengerdetails`
--
ALTER TABLE `passengerdetails`
  ADD CONSTRAINT `FKC2781C682321CDDA` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`),
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON UPDATE CASCADE;

--
-- Constraints for table `ridedetails`
--
ALTER TABLE `ridedetails`
  ADD CONSTRAINT `FKC362024ACBED4704` FOREIGN KEY (`BookingId`) REFERENCES `bookings` (`BookingID`),
  ADD CONSTRAINT `fk_ride_book_id` FOREIGN KEY (`BookingId`) REFERENCES `bookings` (`BookingID`) ON UPDATE CASCADE;

--
-- Constraints for table `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `FK27E845CFEEE4A5` FOREIGN KEY (`DriverID`) REFERENCES `driverdetails` (`DriverID`),
  ADD CONSTRAINT `fk_trip_driver_id` FOREIGN KEY (`DriverID`) REFERENCES `driverdetails` (`DriverID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
