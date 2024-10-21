<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="/estilos/estilos.css" rel="stylesheet"/>
	</head>
	<body>
		<h2>Lista de Artistas</h2>
		<ul>
		    <c:forEach var="artista" items="${artistas}">
		        <li>
		            <a href="/artistas/detalles/${artista.id}">${artista.nombre} ${artista.apellido}</a>
		        </li>
		    </c:forEach>
		</ul>
		
		<a href="/canciones">Ir a Canciones</a>
	</body>
</html>