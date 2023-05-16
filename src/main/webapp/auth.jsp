<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:if test=${not empty erreur }">
	${erreur }
	</c:if> <%--  nejem ne7i cond--%>

<p align=right><a href=inscription.jsp>Inscription</a></p>
<form method="post" action="AuthController">
		Login  : <input name="login"><br>
		Mot de passe  : <input type="password" name="pwd"><br>
		<input type="submit" value="Valider">
</form>
</body>
</html>