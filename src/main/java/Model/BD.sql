Create database `Musica`
CREATE TABLE Disquera(
  id_Disquera int NOT NULL AUTO_INCREMENT,
  nitDisquera varchar(20) NOT NULL,
  nombreDisquera varchar(100) NOT NULL,
  telefonoDisquera varchar(15) NOT NULL,
  direccionDisquera varchar(100) NOT NULL,
  estadoDisquera varchar(10) NOT NULL,
  PRIMARY key(id_Disquera)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
Create TABLE Genero(
  id_Genero int NOT NULL AUTO_INCREMENT,
  nombreGenero varchar(30) NOT NULL,
  estadoGenero boolean(1) NOT NULL,
  PRIMARY key(id_Genero)
)