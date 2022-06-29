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
    <title>Registrar Genero</title>
</head>
<body>
    <nav>
        <div class="nav-wrapper">
          <a href="#" class="brand-logo">Generos</a>
          <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="genero?accion=index">Inicio</a></li>
            <li><a href="genero?accion=abrirFormulario">Crear genero</a></li>
            <li><a href="genero?accion=listar">Generos</a></li>
          </ul>
        </div>
      </nav>
    <h2 class="teal-text text-lighten-2">Registrar Genero</h2>
    <form method="get">
        <div class="row">
            <div class="input-field inline col s12">
                <input type="text" name="nombre" placeholder="Nombre del genero:">
            </div>
        </div>
        <div class="row">
            <input type="submit" name="accion" value="registrar" class="waves-effect waves-light btn-large">
        </div>
    </form>
</body>
</html>