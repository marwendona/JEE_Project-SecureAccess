<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Authentification</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		body {
			background: linear-gradient(to right, #FFFFFF, #87CEEB);
		}
	</style>
</head>
<body>
<c:if test="${not empty erreur}">
	<div class="${erreurStyle}">${erreur}</div>
</c:if>
<div class="container mt-4 d-flex justify-content-center align-items-center">
	<form method="post" action="AuthController" class="mt-4">
		<div class="form-group">
			<label for="login"><strong>Login:</strong></label>
			<input type="text" name="login" class="form-control">
		</div>
		<div class="form-group">
			<label for="pwd"><strong>Mot de passe:</strong></label>
			<input type="password" name="pwd" class="form-control">
		</div>
		<input type="submit" value="Valider" class="btn btn-success">
		<a class="btn btn-primary" href="inscription.jsp" role="button">Inscription</a>
	</form>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
