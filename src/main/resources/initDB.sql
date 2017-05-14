CREATE DATABASE IF NOT EXISTS trmsystem;

ALTER DATABASE trmsystem
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE trmsystem;

CREATE TABLE IF NOT EXISTS users (
   id                VARCHAR(36)  NOT NULL PRIMARY KEY,
   username          VARCHAR(50)  NOT NULL,
   first_name        VARCHAR(50)  NOT NULL,
   last_name         VARCHAR(50)  NOT NULL,
   birth_date        TIMESTAMP,
   password          VARCHAR(255) NOT NULL,
   usertype          VARCHAR(50)  NOT NULL,
   registration_date TIMESTAMP    NOT NULL,
   email             VARCHAR(255) NOT NULL,
   status            VARCHAR(50)  NOT NULL
) engine=InnoDB;