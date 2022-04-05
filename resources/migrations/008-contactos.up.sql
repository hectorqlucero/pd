CREATE TABLE contactos (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(100) DEFAULT NULL,
  `paterno` varchar(100) DEFAULT NULL,
  `materno` varchar(100) DEFAULT NULL,
  `whats_up` varchar(100) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8