<%@ page import="tn.iit.projectjee.model.Model, java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${currentUser== null}">
<c:redirect url="auth.jsp">
</c:redirect></c:if>

<%-- <%if (session.getAttribute("currentUser") == null) {
	response.sendRedirect("auth.jsp");

} else { 
	Model u = (Model) session.getAttribute("currentUser");
	List<Model> lu = (List) application.getAttribute("tUser");
--%>
<p align="right"><a href="Disconnect">Déconnexion</a></p>
Bienvenue ${currentUser.nom} ${currentUser.prenom}"
<br>Vos Prarmètres sont : <br>
&nbsp&nbsp&nbspLogin : ${currentUser.login}
&nbsp&nbsp&nbspMot de passe : ${currentUser.pwd}

<table border>
<tr><th>Nom</th><th>Prénom</th><th>Login</th><th>Mot de passe</th><th>Action</th></tr>
<c:forEach items="${tUser}" var="user" varStatus="status">

<tr><td>${user.nom} </td>
<td>${user.prenom} </td>
<td>${user.login}</td>
<td>${user.pwd}</td>
<td><a href="Delete?pos=${status.index}">Supp</a>/<a href="Update?pos=${status.index}">Modif</a> </td>
</tr>
</c:forEach>
</table>

</body>
</html>