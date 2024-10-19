<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalle Cancion</title>
		<link href="/estilos/estilos.css" rel="stylesheet"/>
	</head>
	<body>
    <h2>Detalle de la Canción</h2>
    <p><strong>Título:</strong> ${cancion.titulo}</p>
    <p><strong>Artista:</strong> ${cancion.artista}</p>
    <p><strong>Álbum:</strong> ${cancion.album}</p>
    <p><strong>Género:</strong> ${cancion.genero}</p>
    <p><strong>Idioma:</strong> ${cancion.idioma}</p>
    <p><strong>Fecha de Creación:</strong> ${cancion.fechaCreacion}</p>
    <p><strong>Fecha de Actualización:</strong> ${cancion.fechaActualizacion}</p>
    
    <div>
    	<a href="/canciones" class="btn-volver">Volver a lista de canciones</a>
    	<form action="/eliminar/cancion/${cancion.id}" method="POST">
    	<input type="hidden" name="_method" value="DELETE"/>
    	<button class="btn-eliminar">
    		Eliminar Pelicula
    	</button>
    </form>
    </div>
</body>
</html>