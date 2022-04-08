CREATE TABLE cuentas (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `pais_id` int NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `cuenta_numero` varchar(300) DEFAULT NULL,
  `transferencia` varchar(200) DEFAULT NULL,
  `deposito_directo` varchar(200) DEFAULT NULL,
  `numero_tarjeta` varchar(100) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8