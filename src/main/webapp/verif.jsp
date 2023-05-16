<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="tn.iit.projectjee.model.Model" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
Vous avez saisi:<br>
Nom:${user.nom }
<br>
Prenom:${user.prenom }<br>
<br>
Login:${user.login }<br>
<br>
Password:${user.pwd }<br>
<br>
<a href="inscription.jsp">Corriger</a> / <a href="InscriptionController">valider</a>
</body>
</html>
