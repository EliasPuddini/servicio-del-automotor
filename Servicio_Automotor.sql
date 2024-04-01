-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para servicio_automotor
CREATE DATABASE IF NOT EXISTS `servicio_automotor` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `servicio_automotor`;

-- Volcando estructura para tabla servicio_automotor.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dni` double DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `servicios_previos` int NOT NULL,
  `tipo_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_m6ysdwsqke00e5piajbvgn6lg` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla servicio_automotor.clientes: ~4 rows (aproximadamente)
INSERT INTO `clientes` (`id`, `dni`, `nombre`, `servicios_previos`, `tipo_cliente`) VALUES
	(1, 44395233, 'Elias_Puddini', 1, 'Normal'),
	(2, 48512465, 'Lautaro_Puddini', 0, 'Normal'),
	(3, 40254987, 'Franco_Puddini', 0, 'Normal'),
	(4, 30215485, 'Hernan_Castilla', 0, 'Normal'),
	(5, 28154965, 'Leon_Puddini', 0, 'Normal'),
	(6, 30210548, 'Armando_Maradona', 1, 'Normal');

-- Volcando estructura para tabla servicio_automotor.servicio
CREATE TABLE IF NOT EXISTS `servicio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aceiteyfiltro` varchar(255) DEFAULT NULL,
  `alineacionybalanceo` varchar(255) DEFAULT NULL,
  `lavado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla servicio_automotor.servicio: ~60 rows (aproximadamente)
INSERT INTO `servicio` (`id`, `aceiteyfiltro`, `alineacionybalanceo`, `lavado`) VALUES
	(1, 'alto rendimiento para motor diesel', 'Con cambio de cubiertas.', 'Lavado Basico'),
	(2, 'alto rendimiento para motor diesel', 'Con cambio de cubiertas.', 'Lavado Completo'),
	(3, 'alto rendimiento para motor diesel', 'Con cambio de cubiertas.', 'Lavado Premium'),
	(4, 'alto rendimiento para motor diesel', 'Con cambio de cubiertas.', 'no'),
	(5, 'alto rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'Lavado Basico'),
	(6, 'alto rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'Lavado Completo'),
	(7, 'alto rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'Lavado Premium'),
	(8, 'alto rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'no'),
	(9, 'alto rendimiento para motor diesel', 'no', 'Lavado Basico'),
	(10, 'alto rendimiento para motor diesel', 'no', 'Lavado Completo'),
	(11, 'alto rendimiento para motor diesel', 'no', 'Lavado Premium'),
	(12, 'alto rendimiento para motor diesel', 'no', 'no'),
	(13, 'bajo rendimiento para motor diesel', 'Con cambio de cubiertas.', 'Lavado Basico'),
	(14, 'bajo rendimiento para motor diesel', 'Con cambio de cubiertas.', 'Lavado Completo'),
	(15, 'bajo rendimiento para motor diesel', 'Con cambio de cubiertas.', 'Lavado Premium'),
	(16, 'bajo rendimiento para motor diesel', 'Con cambio de cubiertas.', 'no'),
	(17, 'bajo rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'Lavado Basico'),
	(18, 'bajo rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'Lavado Completo'),
	(19, 'bajo rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'Lavado Premium'),
	(20, 'bajo rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'no'),
	(21, 'bajo rendimiento para motor diesel', 'no', 'Lavado Basico'),
	(22, 'bajo rendimiento para motor diesel', 'no', 'Lavado Completo'),
	(23, 'bajo rendimiento para motor diesel', 'no', 'Lavado Premium'),
	(24, 'bajo rendimiento para motor diesel', 'no', 'no'),
	(25, 'alto rendimiento para motor naftero', 'Con cambio de cubiertas.', 'Lavado Basico'),
	(26, 'alto rendimiento para motor naftero', 'Con cambio de cubiertas.', 'Lavado Completo'),
	(27, 'alto rendimiento para motor naftero', 'Con cambio de cubiertas.', 'Lavado Premium'),
	(28, 'alto rendimiento para motor naftero', 'Con cambio de cubiertas.', 'no'),
	(29, 'alto rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'Lavado Basico'),
	(30, 'alto rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'Lavado Completo'),
	(31, 'alto rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'Lavado Premium'),
	(32, 'alto rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'no'),
	(33, 'alto rendimiento para motor naftero', 'no', 'Lavado Basico'),
	(34, 'alto rendimiento para motor naftero', 'no', 'Lavado Completo'),
	(35, 'alto rendimiento para motor naftero', 'no', 'Lavado Premium'),
	(36, 'alto rendimiento para motor naftero', 'no', 'no'),
	(37, 'bajo rendimiento para motor naftero', 'Con cambio de cubiertas.', 'Lavado Basico'),
	(38, 'bajo rendimiento para motor naftero', 'Con cambio de cubiertas.', 'Lavado Completo'),
	(39, 'bajo rendimiento para motor naftero', 'Con cambio de cubiertas.', 'Lavado Premium'),
	(40, 'bajo rendimiento para motor naftero', 'Con cambio de cubiertas.', 'no'),
	(41, 'bajo rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'Lavado Basico'),
	(42, 'bajo rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'Lavado Completo'),
	(43, 'bajo rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'Lavado Premium'),
	(44, 'bajo rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'no'),
	(45, 'bajo rendimiento para motor naftero', 'no', 'Lavado Basico'),
	(46, 'bajo rendimiento para motor naftero', 'no', 'Lavado Completo'),
	(47, 'bajo rendimiento para motor naftero', 'no', 'Lavado Premium'),
	(48, 'bajo rendimiento para motor naftero', 'no', 'no'),
	(49, 'no', 'Con cambio de cubiertas.', 'Lavado Basico'),
	(50, 'no', 'Con cambio de cubiertas.', 'Lavado Completo'),
	(51, 'no', 'Con cambio de cubiertas.', 'Lavado Premium'),
	(52, 'no', 'Con cambio de cubiertas.', 'no'),
	(53, 'no', 'Sin cambio de cubiertas.', 'Lavado Basico'),
	(54, 'no', 'Sin cambio de cubiertas.', 'Lavado Completo'),
	(55, 'no', 'Sin cambio de cubiertas.', 'Lavado Premium'),
	(56, 'no', 'Sin cambio de cubiertas.', 'no'),
	(57, 'no', 'no', 'Lavado Basico'),
	(58, 'no', 'no', 'Lavado Completo'),
	(59, 'no', 'no', 'Lavado Premium'),
	(60, 'no', 'no', 'no');

-- Volcando estructura para tabla servicio_automotor.turno
CREATE TABLE IF NOT EXISTS `turno` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `patente` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `cliente_id` bigint DEFAULT NULL,
  `servicio_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a0kvkgsvh16rye5pidm2h784y` (`cliente_id`),
  UNIQUE KEY `UK_ftaf8949jlemdd3rmo93h32vs` (`servicio_id`),
  CONSTRAINT `FKk0ocq8hmjgn0m8xaxj6oxvopv` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`id`),
  CONSTRAINT `FKm6wka9bmorib6a24gp5qd8l53` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla servicio_automotor.turno: ~2 rows (aproximadamente)
INSERT INTO `turno` (`id`, `fecha`, `patente`, `precio`, `cliente_id`, `servicio_id`) VALUES
	(1, '2024-03-17 15:30:00.000000', 'ABC457', 250000, 1, 1),
	(2, '2024-03-25 15:00:00.000000', 'CSX598', 84500, 6, 51);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
