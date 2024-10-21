<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Proyecto canciones</title>
		<link href="/estilos/estilos.css" rel="stylesheet"/>
	</head>
	<body>
		<h1> Canciones </h1>
		<div class="contenedor-canciones">
			<c:forEach items="${Canciones}" var="cancion">
				<li class="cancion-item">
					${cancion.artista.nombre} ${cancion.artista.apellido} - ${cancion.titulo}
					<div class="acciones-cancion">
						<a href="/canciones/detalles/${cancion.id}" class="btn-detalle">Detalle</a>
						<form action="formulario/editar/cancion/${cancion.id}">
							<button class="btn-editar">Editar</button>
						</form>
					</div>
				</li>
			</c:forEach>

			<div class="acciones-principales">
				<form action="/agregar/cancion" method="GET">
					<button class="btn-agregar">Agregar Canción</button>
				</form>
				<form action="/registro">
					<button class="btn-agregar-artista">Agregar Artista</button>
				</form>
				<a href="/artistas" class="btn-lista-artista">Lista de Artistas</a>
			</div>
		</div>
	</body>
</html>
