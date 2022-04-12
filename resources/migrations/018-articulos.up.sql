CREATE TABLE articulos (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `imagen` text DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `precio` decimal(13, 2) DEFAULT 0,
  `contacto` varchar(300) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `whats_up` Varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8