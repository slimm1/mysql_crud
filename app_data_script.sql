-- CREACION DE BASE DE DATOS CON DOS TABLAS ENLAZADAS PARA PRACTIOCA DE CRUD CON DAO EN JAVA CON MYSQL ------------

DROP DATABASE IF EXISTS app_data;

CREATE DATABASE app_data;

USE app_data;

-- creacion de tablas ----------------------------------

CREATE OR REPLACE TABLE user_(
	user_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(20) NOT NULL,
	user_pass VARCHAR(50) NOT NULL,
	user_email VARCHAR(50) NOT NULL,
	birthDate DATE NOT NULL,
	upcoming_show INT UNSIGNED
);

CREATE OR REPLACE TABLE show_(
	show_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	show_name VARCHAR(50) NOT NULL,
	show_datetime DATETIME NOT NULL,
	genre VARCHAR(20)
);

-- añadir claves foráneas.

ALTER TABLE user_ ADD CONSTRAINT fk_user_show FOREIGN KEY(upcoming_show) REFERENCES show_(show_id);

-- insertar par de datos

INSERT INTO show_(show_name, show_datetime, genre) 
VALUES('El rey león', '2024-04-19 13:08:22', 'Musical'), ('El amanecer de los tuertos', '2024-04-19 13:08:22', 'Comedia');

INSERT INTO user_(user_name, birthDate, user_email, user_pass, upcoming_show)
VALUES('slimm1','1996-01-18','tini.ramonda@gmail.com','1234',2); 