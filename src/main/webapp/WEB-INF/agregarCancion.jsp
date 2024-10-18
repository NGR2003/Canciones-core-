<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<div>
				<h1>Agregar Cancion</h1>
			</div>
			<div>
				<form:form action="/agregar/cancion" method="POST" modelAttribute="cancion">
				
					<div>
						<form:label path="titulo"> Titulo: </form:label>
						<form:input path="titulo" />
						<form:errors path="titulo" />
					</div>
					<div>
						<form:label path="artista"> Artista: </form:label>
						<form:input path="artista" />
						<form:errors path="artista" />
					</div>
					<div>
						<form:label path="album"> Album: </form:label>
						<form:input path="album" />
						<form:errors path="album" />
					</div>
					<div>
						<form:label path="genero"> Género: </form:label>
						<form:input path="genero" />
						<form:errors path="genero" />
					</div>
					<div>
						<form:label path="idioma"> Idioma: </form:label>
						<form:input path="idioma" />
						<form:errors path="idioma" />
					</div>
					<button>
						Agregar
					</button>	
				</form:form>
				<a href="/canciones">Volver a Lista de Canciones</a>
			</div>
		</div>
	</body>
</html>