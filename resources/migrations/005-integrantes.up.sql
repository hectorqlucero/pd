CREATE TABLE integrantes (
  `id` int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `titulo` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `paterno` varchar(100) DEFAULT NULL,
  `materno` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;