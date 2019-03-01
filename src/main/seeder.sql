show databases;

CREATE DATABASE IF NOT EXISTS student_information;
USE student_information;

DROP TABLE IF EXISTS students;

CREATE TABLE IF NOT EXISTS students(
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  school_yr VARCHAR(10),
  campus VARCHAR(10),
  sId VARCHAR(10),
  entry_date VARCHAR(20),
  grade_Level VARCHAR(10),
  first_name VARCHAR(100),
  middle_name VARCHAR(100),
  last_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO students (school_yr, campus, s_id, entry_date, grade_level,first_name, middle_name, last_name) VALUES
    ('2019', '105', '025676', '2018-08-27', '4', 'Belinda', null, 'Guzman'),
    ('2019', '041', '010081', '2018-08-27', '6', 'Brittany', 'Martinez', 'Cordova'),
    ('2019', '041', '010094', '2018-08-27', '6', 'Claire', null, 'Genz'),
    ('2019', '041', '010106', '2018-08-27', '7', 'Daira', 'Salazar', 'Lopez'),
    ('2019', '105', '019610', '2018-08-27', '4', 'Daisy', null, 'Herrera'),
    ('2019', '105', '025629', '2018-08-27', '4', 'Daniela', null, 'Gomez'),
    ('2019', '105', '025837', '2018-08-27', '3', 'Evelyn', null, 'Estrada'),
    ('2019', '105', '019647', '2018-08-27', '4', 'Faviola', null, 'Pilar'),
    ('2019', '001', '016555', '2018-08-27', '12', 'Francisco', 'Salas', 'Uhl'),
    ('2019', '001', '016569', '2018-09-06', '11', 'Isaiah', null, 'Jimenez'),
    ('2019', '105', '020071', '2018-08-27', '04', 'Jacob', null, 'Perry'),
    ('2019', '001', '016588', '2018-08-27', '12', 'Jessica', null, 'Ontiveros'),
    ('2019', '041', '010093', '2018-08-27', '6', 'Kyle', null, 'Lowe'),
    ('2019', '041', '010012', '2018-08-27', '6', 'Lauren', null, 'Cervantes'),
    ('2019', '105', '025825', '2018-08-27', '3', 'Luis', 'Angel', 'Amador'),
    ('2019', '001', '016031', '2018-09-05', '11', 'Marcel', null, 'Moore'),
    ('2019', '041', '010048', '2018-08-27', '7', 'Oneida', null, 'Ortiz'),
    ('2019', '041', '010056', '2018-08-27', '6', 'Patric', null, 'Lamson'),
    ('2019', '001', '016265', '2018-08-27', '12', 'Shaun', null, 'Herrera'),
    ('2019', '001', '016486', '2018-08-27', '11', 'Tyler', null, 'Namatka'),
    ('2019', '001', '016497', '2018-10-05', '11', 'Weston', null, 'Williams');

select * from students;

SELECT user, host FROM mysql.user;