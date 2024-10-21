<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle del Artista</title>
    <link href="/estilos/estilos.css" rel="stylesheet"/>
</head>
<body>
    <h2>Detalle del Artista</h2>

    <!-- Mostrar información del artista -->
    <p><strong>Nombre:</strong> ${artista.nombre} ${artista.apellido}</p>
    <p><strong>Biografía:</strong> ${artista.biografía}</p>

    <h3>Canciones del Artista</h3>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
            <li>${cancion.titulo}</li>
        </c:forEach>
    </ul>

    <!-- Enlace para volver a la lista de artistas -->
    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>
