CREATE TABLE veterinarias (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `imagen` text DEFAULT NULL,
  `comp` varchar(300) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `direccion` varchar(300) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `urgencias` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8