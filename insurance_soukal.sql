-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Pon 18. bře 2024, 18:33
-- Verze serveru: 10.4.32-MariaDB
-- Verze PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `insurance_soukal`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `clients`
--

CREATE TABLE `clients` (
  `id_client` bigint(20) NOT NULL,
  `city` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `psc` int(11) NOT NULL,
  `street` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `time_of_addition` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `clients`
--

INSERT INTO `clients` (`id_client`, `city`, `email`, `name`, `phone_number`, `psc`, `street`, `surname`, `time_of_addition`) VALUES
(10, 'Praha 5', 'adamek1@icloud.com', 'Adámek', 123777888, 14144, 'Radlická 2828/45', 'Untermullerů', NULL),
(12, 'Praha 13', 'dadasadil@gamil.com', 'Daniel', 123456789, 13144, 'Nárožní 123', 'Sadil', NULL),
(17, 'Kladno', 'karel@gmail.com', 'Karel', 888277312, 23424, 'Kladenská 2933/12', 'Smetana', '2024-03-18 18:29:07');

-- --------------------------------------------------------

--
-- Struktura tabulky `insurances`
--

CREATE TABLE `insurances` (
  `id_insurance` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `subject_of_insurance` varchar(255) NOT NULL,
  `sum` int(11) NOT NULL,
  `time_of_addition` datetime DEFAULT NULL,
  `valid_from` date NOT NULL,
  `valid_to` date NOT NULL,
  `id_client` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `insurances`
--

INSERT INTO `insurances` (`id_insurance`, `name`, `subject_of_insurance`, `sum`, `time_of_addition`, `valid_from`, `valid_to`, `id_client`) VALUES
(100009, 'Pojištění vozidla', 'Alfa romeo 145', 10000000, NULL, '2024-03-22', '2025-03-05', 10),
(100020, 'Úrazové pojištění', 'Úmrtí', 1000000, '2024-03-18 18:29:39', '2024-03-22', '2027-03-19', 10),
(100021, 'Pojištění proti krádeži', 'Mobilní telefon', 50000, '2024-03-18 18:30:16', '2024-03-19', '2026-03-19', 12),
(100022, 'Pojištění majetku', 'Byt', 5000000, '2024-03-18 18:30:52', '2024-03-20', '2025-03-18', 17);

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexy pro tabulku `insurances`
--
ALTER TABLE `insurances`
  ADD PRIMARY KEY (`id_insurance`),
  ADD KEY `FKt4gqnwceyvvkc5idg1wm235eg` (`id_client`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `clients`
--
ALTER TABLE `clients`
  MODIFY `id_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pro tabulku `insurances`
--
ALTER TABLE `insurances`
  MODIFY `id_insurance` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100023;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `insurances`
--
ALTER TABLE `insurances`
  ADD CONSTRAINT `FKt4gqnwceyvvkc5idg1wm235eg` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
