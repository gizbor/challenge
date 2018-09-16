SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS fingerprint;
CREATE DATABASE fingerprint;

USE fingerprint;

CREATE USER 'fingerprint'@'localhost' IDENTIFIED BY 'fingerprint';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Table structure for table `finger_print_log`
--

CREATE TABLE `finger_print_log` (
  `id` int(11) NOT NULL,
  `n_order` int(11) DEFAULT NULL,
  `result` char(1) DEFAULT NULL,
  `row_1` varchar(255) DEFAULT NULL,
  `row_2` varchar(255) DEFAULT NULL,
  `row_3` varchar(255) DEFAULT NULL,
  `row_4` varchar(255) DEFAULT NULL,
  `row_5` varchar(255) DEFAULT NULL,
  `row_6` varchar(255) DEFAULT NULL,
  `row_7` varchar(255) DEFAULT NULL,
  `row_8` varchar(255) DEFAULT NULL
) DEFAULT CHARSET=latin1;

--
-- Indexes for table `finger_print_log`
--
ALTER TABLE `finger_print_log`
  ADD PRIMARY KEY (`id`);


# Privileges for `fingerprint`@`%`

GRANT ALL PRIVILEGES ON *.* TO 'fingerprint'@'%' IDENTIFIED BY PASSWORD '*E11DE736CD6A93714404EB670E55D5E7A7F30B5E' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON `fingerprint`.* TO 'fingerprint'@'%';
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
