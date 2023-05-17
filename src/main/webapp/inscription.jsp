<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inscription</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		body {
			background: radial-gradient(#FFFFFF, #87CEEB);
		}
	</style>
</head>
<body>
<jsp:useBean id="user" class="tn.iit.projectjee.model.Model" scope="session"></jsp:useBean>
<div class="container mt-4 d-flex justify-content-center align-items-center">
	<form method="post" action="verif.jsp">
		<div class="form-group">
			<label for="nom"><strong>Nom:</strong></label>
			<input type="text" name="nom" class="form-control" value="${user.nom}">
		</div>
		<div class="form-group">
			<label for="prenom"><strong>Prénom:</strong></label>
			<input type="text" name="prenom" class="form-control" value="${user.prenom}">
		</div>
		<div class="form-group">
			<label for="login"><strong>Login:</strong></label>
			<input type="text" name="login" class="form-control" value="${user.login}">
		</div>
		<div class="form-group">
			<label for="pwd"><strong>Mot de passe:</strong></label>
			<input type="password" name="pwd" class="form-control" value="${user.pwd}">
		</div>
		<input type="submit" value="Valider" class="btn btn-success">
	</form>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
