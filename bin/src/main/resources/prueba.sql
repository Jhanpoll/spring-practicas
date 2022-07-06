DROP TABLE IF EXISTS person;
CREATE TABLE person(
idPerson int auto_increment primary key,
nombre varchar(100),
apellido varchar(100),
nickname varchar(100)
);