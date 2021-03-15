CREATE DATABASE IF NOT EXISTS gmoUserAccounts;

USE gmoUserAccounts;

DROP TABLE IF EXISTS `gmoUserAccounts`.`loginAccounts`;

CREATE TABLE `gmoUserAccounts`.`loginAccounts` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));