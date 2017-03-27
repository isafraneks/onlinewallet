SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ow` DEFAULT CHARACTER SET utf8 ;
USE `ow` ;

-- -----------------------------------------------------
-- Table `ow`.`client`
-- All clients of OnlineWallet
-- -----------------------------------------------------
DROP TABLE IF EXISTS client ;

CREATE TABLE IF NOT EXISTS client (
  idClient INT(10) NOT NULL AUTO_INCREMENT,
  FirstName CHAR(32) NOT NULL,
  LastName CHAR(32) NOT NULL,
  Sts CHAR(7) NOT NULL,
  PRIMARY KEY (idClient)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

-- -----------------------------------------------------
-- Table `ow`.`account`
-- All accounts of clients
-- -----------------------------------------------------
DROP TABLE IF EXISTS account ;

CREATE TABLE IF NOT EXISTS account (
  idAccount INT(10) NOT NULL AUTO_INCREMENT,
  AccountNumber CHAR(30) NOT NULL,
  idClient INT(10) NOT NULL,
  Balance DECIMAL NOT NULL,
  Sts CHAR(7) NOT NULL,
  PRIMARY KEY (idAccount),
  FOREIGN KEY (idClient) REFERENCES client(idClient)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

-- -----------------------------------------------------
-- Table `ow`.`trn`
-- Transaction headers
-- -----------------------------------------------------
DROP TABLE IF EXISTS trn;

CREATE TABLE IF NOT EXISTS trn (
  idTrn INT(10) NOT NULL AUTO_INCREMENT,
  Dt DATETIME,
  Sts CHAR(7) NOT NULL,
  Rem VARCHAR(500),
  PRIMARY KEY (idTrn)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

-- -----------------------------------------------------
-- Table `ow`.`trnln`
-- Transaction lines
-- -----------------------------------------------------
DROP TABLE IF EXISTS trnln ;

CREATE TABLE IF NOT EXISTS trnln (
  idTrn INT(10) NOT NULL,
  lnTrn INT(10) NOT NULL,
  idAccount INT(10),
  Dr DECIMAL,
  Cr DECIMAL,
  PRIMARY KEY (idTrn, lnTrn),
  FOREIGN KEY (idAccount) REFERENCES account(idAccount)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;





-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
    `UserID` INT(11) NOT NULL AUTO_INCREMENT,
    `FirstName` CHAR(32) NOT NULL,
    `LastName` CHAR(32) NOT NULL,
    PRIMARY KEY (`UserID`)
  )
  ENGINE = InnoDB
  AUTO_INCREMENT = 1002;




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;