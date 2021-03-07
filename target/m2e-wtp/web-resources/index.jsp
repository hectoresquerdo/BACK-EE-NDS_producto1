<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a la app</title>
</head>
<body>
	<h1>Identifíquese</h1>
	<form action="Login" method="POST">
		Usuario <input type="text" id="nombre" name="nombre">
		Contraseña <input type=text id="pass" name="pass"> 
		<input type="submit" value="OK">
	</form>
</body>
</html>