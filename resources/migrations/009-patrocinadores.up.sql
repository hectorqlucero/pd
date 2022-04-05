CREATE TABLE patrocinadores (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `imagen` text DEFAULT NULL,
  `comp` varchar(300) DEFAULT NULL,
  `contacto` varchar(300) DEFAULT NULL,
  `direccion` varchar(300) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `whats_up` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8