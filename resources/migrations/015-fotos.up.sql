CREATE TABLE `fotos` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fecha` date DEFAULT NULL,
  `enlace` text DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;