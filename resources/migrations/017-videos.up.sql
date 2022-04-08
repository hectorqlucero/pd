CREATE TABLE `videos` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fecha` date DEFAULT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  `enlace` text DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;