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
<form method="post" action="verif.jsp">
		Nom  : <input name="nom" value='${user.nom }'><br>
		Prénom  : <input name="prenom" value='${user.prenom }'><br>
		Login  : <input name="login" value='${user.login }'><br>
		Mot de passe  : <input type="password" name="pwd" value='${user.pwd }'><br>
		<input type="submit" value="Valider">
</form>
</body>
</html>