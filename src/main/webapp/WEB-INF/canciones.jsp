<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Proyecto canciones</title>
	</head>
	<body>
		<h1> Canciones </h1>
		<div>
			<c:forEach items="${Canciones}" var="cancion">
				<li>${cancion.artista} - ${cancion.titulo}</li>
				<a href="/canciones/detalles/${cancion.id}">Detalle</a>
			</c:forEach>
			<div>
				<form action="/agregar/cancion" method="GET">
					<button>
						Agregar Cancion
					</button>
				</form>
			</div>
		</div>
	</body>
</html>