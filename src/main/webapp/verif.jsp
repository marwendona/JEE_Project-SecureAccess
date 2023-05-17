<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Verification</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background: conic-gradient(#FFFFFF, #87CEEB);
        }
    </style>
</head>
<body>
<jsp:useBean id="user" class="tn.iit.projectjee.model.Model" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<div class="container mt-4 d-flex justify-content-center align-items-center">
    <div>
        <h2 class="text-primary">Vous avez saisi :</h2>
        <br>
        <p><strong>Nom:</strong> ${user.nom}</p>
        <p><strong>Prénom:</strong> ${user.prenom}</p>
        <p><strong>Login:</strong> ${user.login}</p>
        <p><strong>Password:</strong> ${user.pwd}</p>
        <br>
        <p class="lead"><strong>Si vous souhaitez corriger ou confirmer les informations fournies, <br>
            veuillez cliquer sur les boutons correspondants.</strong></p>
        <br>
        <div class="d-flex justify-content-center">
            <a href="inscription.jsp" class="btn btn-primary mr-2">Corriger</a>
            <a href="InscriptionController" class="btn btn-success">Valider</a>
        </div>
    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>