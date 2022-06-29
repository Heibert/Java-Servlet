Create database `Musica`;
USE musica;
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
  estadoGenero boolean NOT NULL,
  PRIMARY key(id_Genero)
);
CREATE Table album (
  idAlbum int AUTO_INCREMENT PRIMARY KEY,
  anoPublicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estadoAlbum BOOLEAN,
  nombreAlbum VARCHAR(30) NOT NULL,
  idArtista INTEGER NOT NULL,
  idGenero INTEGER NOT NULL
);