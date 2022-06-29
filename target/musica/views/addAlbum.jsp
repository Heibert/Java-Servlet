<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="./Assets/CSS/materialize.css">
    <title>Registrar Album</title>
</head>
<body>
    <nav>
        <div class="nav-wrapper">
          <a href="#" class="brand-logo">Album</a>
          <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="album?accion=index">Inicio</a></li>
            <li><a href="album?accion=abrirForm">Crear Album</a></li>
            <li><a href="album?accion=listar">Albums</a></li>
          </ul>
        </div>
      </nav>
    <h2 class="teal-text text-lighten-2">Registrar Album</h2>
    <form method="get">
        <div class="row">
            <div class="input-field inline col s12">
                <input type="text" name="nombreAlbum" placeholder="Nombre del album:">
            </div>
        </div>
        <div class="row">
            <label>Id del artista</label>
            <div class="input-field inline col s12">
                <input type="number" name="idArtista" placeholder="Id del artista">
            </div>
        </div>
        <div class="row">
            <label>Id del genero</label>
            <div class="input-field inline col s12">
                <input type="number" name="idGenero" placeholder="Id del genero">
            </div>
        </div>
<!--         <div class="row">
            <label>Estado</label>
            <div class="input-field inline col s12">
                <input type="checkbox" id="estado" name="estado">
            </div>
        </div> -->
        <div class="row">
            <input type="submit" name="accion" value="registrar" class="waves-effect waves-light btn-large">
        </div>
    </form>
</body>
</html>