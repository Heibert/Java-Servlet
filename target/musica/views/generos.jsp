<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Assets/CSS/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Generos</title>
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
    <table class="striped">
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Estado</th>            
            <th>Activar/Desactivar</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
    <c:forEach var="Genero" items="${generos}">
    <tr>
            <td>
                ${Genero.getIdGenero()}
            </td>
            <td>
                ${Genero.getNombreGenero()}
            </td>
            <c:if test="${Genero.getEstadoGenero() == true}">
              <td><span class="green-text">Genero Activo</span></td> 
            </c:if>
        <c:if test="${Genero.getEstadoGenero() == false}">
            <td><span class="red-text">Genero Inactivo</span></td> 
        </c:if>
        <td>
        <c:if test="${Genero.getEstadoGenero() == true}">
           <a href="genero?accion=cEstado&id=${Genero.getIdGenero()}&Estado=true" class="btn red" > 
        Inactivar
        </a>
        </c:if>
        <c:if test="${Genero.getEstadoGenero() == false}">
            <a 
            class="btn green" href="genero?accion=cEstado&id=${Genero.getIdGenero()}&Estado=false">
        Activar
        </a>
        </c:if> 
        </td>
        <td>
        <a class="btn yellow" href="javascript:mostrar(${Genero.getIdGenero()})"><i class="material-icons">build</i></a>
        <div id="layout${Genero.getIdGenero()}" style="display:none;">
            <form>
              <div class="row">
                <label for="nombre${Genero.getIdGenero()}">Nombre</label>
                  <input type="text" id="nombre${Genero.getIdGenero()}" name="nombre" placeholder="${Genero.getNombreGenero()}">
              </div>
                    <c:if test="${Genero.getEstadoGenero() == true}">
                        <input type="checkbox" id="estado" checked="checked"/>
                     </c:if>
                     <c:if test="${Genero.getEstadoGenero() == false}">
                        <input type="checkbox" id="estado">
                    </c:if> 
                    <div class="row">
                      Activo
                    </div>
                    </label>
                    <button type="submit" class="btn" onclick="Editar(event,'${Genero.getIdGenero()}','genero')">Registrar cambios</button>
              </form>
            </div>
        </td>
        <td>
	    <a  class="btn red" onclick="alertaBorrar(event,'${Genero.getIdGenero()}','genero')"><i class="material-icons">delete_forever</i></a>
	    </td>
    </c:forEach>
</table>
<script>
function alertaBorrar(e,id,cont){
	e.preventDefault();
	console.log(cont);
  Swal.fire({
	  title: '¿Realmente quiere eliminarlo?',
	  text: "Es una accion permanente",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'BORRAR',
	  cancelButtonText: "Cancelar",
	}).then((result) => {
	  if (result.isConfirmed){
			ruta=cont+"?accion=eliminar&id="+id;
			console.log(ruta);
			window.setTimeout(function(){window.location.href = ruta},1500);
			Swal.fire({
			  position: 'top-end',
			  icon: 'success',
			  title: 'El registro ha sido borrado',
			  showConfirmButton: false,
			  timer: 1500
			})
          } 
        else {Swal.fire(
					'Cancelado', 
					'Cancelaste la eliminacion',
					'error');}
	});
};
function mostrar(id){
  var Mostrar=document.getElementById('layout'+id);
  if (Mostrar.style.display == "none") {
    Mostrar.style.display="block";
  } else {
    Mostrar.style.display="none";
  }
}
function Editar(e,id,controlador){
	e.preventDefault();
  var estado = document.getElementById("estado").checked;
  var nombre = document.getElementById('nombre'+id).value
	console.log(id);
  console.log(nombre);
	console.log(estado);
	Swal.fire({
	  title: '¿Desea editar el registro?',
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Si',
	  cancelButtonText: "No",
	}).then((result) => {
	  if (result.isConfirmed) {
        ruta = controlador+"?accion=editar&id="+id+"&nombre="+nombre+"&estado="+estado,
        window.setTimeout(function(){window.location.href = ruta},1500);
			Swal.fire({
			  position: 'top-end',
			  icon: 'success',
			  title: 'El registro ha sido editado',
			  showConfirmButton: false,
			  timer: 2000})} 
        else {Swal.fire(
					'Cancelado', 
					'La edicion fue descartada',
					'error');
                 }
	});
};
</script>
</body>
</html>