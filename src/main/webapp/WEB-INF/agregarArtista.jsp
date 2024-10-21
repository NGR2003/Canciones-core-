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
		<div>

				<h1>Registro</h1>

				<form:form action="/agregar/artista" method="POST" modelAttribute="nuevoArtista">
				
					<div>
						<form:label path="nombre"> Nombre: </form:label>
						<form:input path="nombre" />
						<form:errors path="nombre" />
					</div>
					<div>
						<form:label path="apellido"> Apellido: </form:label>
						<form:input path="apellido" />
						<form:errors path="apellido" />
					</div>
					<div>
						<form:label path="Biografía"> Biografía: </form:label>
						<form:input path="Biografía" />
						<form:errors path="Biografía" />
					</div>
					<button>
						Registrar
					</button>	
				</form:form>
			</div>
	</body>
</html>