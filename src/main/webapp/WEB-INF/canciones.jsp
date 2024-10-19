<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Proyecto canciones</title>
		<link href="/estilos/estilos.css" rel="stylesheet"/>
	</head>
	<body>
		<h1> Canciones </h1>
		<div>
			<c:forEach items="${Canciones}" var="cancion">
				<li>${cancion.artista} - ${cancion.titulo}</li>
					<a href="/canciones/detalles/${cancion.id}">Detalle</a>
					<form action="formulario/editar/cancion/${cancion.id}">
						<button class="btn-editar">Editar</button>
					</form>
			</c:forEach>
				<form action="/agregar/cancion" method="GET">
					<button>
						Agregar Cancion
					</button>
				</form>
		</div>
	</body>
</html>