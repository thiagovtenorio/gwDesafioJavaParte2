CREATE SCHEMA `desafiogw` ;



CREATE TABLE `desafiogw`.`tbusuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(25) NULL,
  `email` VARCHAR(25) NULL,
  `senha` VARCHAR(25) NULL,
  `data_criacao` DATE NULL,
  `data_atualizacao` DATE NULL,
  `ultimo_login` DATE NULL,
  PRIMARY KEY (`id`));
