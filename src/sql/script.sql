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

  CREATE TABLE `desafiogw`.`tbtelefoneusuario` (
  `ddd` INT NULL,
  `telefone` VARCHAR(45) NULL,
  `idusuario` INT NULL,
  INDEX `id_idx` (`idusuario` ASC) VISIBLE,
  CONSTRAINT `id`
    FOREIGN KEY (`idusuario`)
    REFERENCES `desafiogw`.`tbusuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `desafiogw`.`tbusuario` 
CHANGE COLUMN `senha` `senha` VARCHAR(150) NULL DEFAULT NULL ,
CHANGE COLUMN `salt` `salt` VARCHAR(150) NULL DEFAULT NULL ;
