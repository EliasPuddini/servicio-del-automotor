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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla servicio_automotor.clientes: ~9 rows (aproximadamente)
INSERT INTO `clientes` (`id`, `dni`, `nombre`, `servicios_previos`, `tipo_cliente`) VALUES
	(1, 44395233, 'Elias', 0, 'Normal'),
	(2, 46854751, 'Lautaro', 0, 'Normal'),
	(3, 40215984, 'Ariel', 0, 'Normal'),
	(4, 22978154, 'Fernando', 0, 'Normal'),
	(5, 50497564, 'Martinez', 0, 'Normal'),
	(7, 25164875, 'Armando', 0, 'Normal'),
	(8, 22485764, 'Augusto', 1, 'Normal'),
	(9, 12345687, 'Martin', 1, 'Normal'),
	(10, 21354876, 'Hernesto', 1, 'Normal');

-- Volcando estructura para tabla servicio_automotor.servicio
CREATE TABLE IF NOT EXISTS `servicio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aceiteyfiltro` varchar(255) DEFAULT NULL,
  `alineacionybalanceo` varchar(255) DEFAULT NULL,
  `lavado` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla servicio_automotor.servicio: ~6 rows (aproximadamente)
INSERT INTO `servicio` (`id`, `aceiteyfiltro`, `alineacionybalanceo`, `lavado`, `precio`) VALUES
	(1, 'alto rendimiento para motor diesel', 'Con cambio de cubiertas', 'Lavado Completo', 54000),
	(2, 'bajo rendimiento para motor naftero', 'Sin cambio de cubiertas.', 'Lavado Basico', 24000),
	(3, 'no', 'no', 'Lavado Basico', 5000),
	(4, 'no', 'Con cambio de cubiertas.', 'no', 23500),
	(5, 'no', 'Con cambio de cubiertas.', 'no', 18540),
	(6, 'alto rendimiento para motor diesel', 'Sin cambio de cubiertas.', 'no', 72000),
	(8, 'Con cambio de cubiertas', 'alto rendimiento para motor diesel', 'Lavado Premium', 100000);

-- Volcando estructura para tabla servicio_automotor.turno
CREATE TABLE IF NOT EXISTS `turno` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `patente` varchar(255) DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  `servicio_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a0kvkgsvh16rye5pidm2h784y` (`cliente_id`),
  UNIQUE KEY `UK_ftaf8949jlemdd3rmo93h32vs` (`servicio_id`),
  CONSTRAINT `FKk0ocq8hmjgn0m8xaxj6oxvopv` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`id`),
  CONSTRAINT `FKm6wka9bmorib6a24gp5qd8l53` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla servicio_automotor.turno: ~6 rows (aproximadamente)
INSERT INTO `turno` (`id`, `fecha`, `patente`, `cliente_id`, `servicio_id`) VALUES
	(1, '2024-03-15 15:30:00.000000', 'AVC475', 1, 1),
	(2, '2024-03-21 12:00:00.000000', 'CD154VD', 2, 2),
	(3, '2024-03-25 16:15:00.000000', 'AX248CD', 7, 3),
	(4, '2024-03-05 12:20:00.000000', 'ZC957VS', 8, 4),
	(5, '2024-02-20 14:30:00.000000', 'SA687QW', 9, 5),
	(6, '2024-02-12 14:23:00.000000', 'XA965ZX', 10, 6);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
