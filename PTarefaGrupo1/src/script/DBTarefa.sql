SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbtarefa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbtarefa` DEFAULT CHARACTER SET latin1 ;
USE `dbtarefa` ;

-- -----------------------------------------------------
-- Table `dbtarefa`.`lista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtarefa`.`lista` (
  `idlista` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idlista`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dbtarefa`.`tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtarefa`.`tarefa` (
  `idtarefa` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NULL DEFAULT NULL,
  `prazo` DATE NULL DEFAULT NULL,
  `concluido` TINYINT(4) NULL DEFAULT NULL,
  `idlista` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idtarefa`),
  INDEX `FK_Lista_idx` (`idlista` ASC),
  CONSTRAINT `FK_Lista`
    FOREIGN KEY (`idlista`)
    REFERENCES `dbtarefa`.`lista` (`idlista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
