<%@ page import="tn.iit.projectjee.model.Model, java.util.List" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>Index</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
   <style>
      body {
         background: linear-gradient(to right, #FFFFFF, #87CEEB);
      }
   </style>
</head>
<body>
<script>
   function confirmDelete() {
      return confirm("Êtes-vous sûr de vouloir supprimer cet élément ?");
   }
</script>
<c:if test="${currentUser == null}">
   <c:redirect url="auth.jsp" />
</c:if>
<p class="text-right"><a href="Disconnect" class="btn btn-danger"><i class="fas fa-power-off"></i></a></p>
<div class="text-center">
   <h2 class="text-primary">Bienvenue <span class="text-uppercase">${currentUser.nom} ${currentUser.prenom}</span></h2>
   <br>
   <h2 class="text-primary">Que vous soyez nouveaux ici ou des habitués, <br>
      nous sommes heureux de vous accueillir.</h2>
   <br>
   <p class="lead"><strong>Vos Parametres sont :</strong></p>
   <ul class="list-unstyled">
      <li><strong>Login :</strong> <span class="text-danger"><strong>${currentUser.login}</strong></span></li>
      <li><strong>Mot de passe :</strong> <span class="text-success"><strong>${currentUser.pwd}</strong></span></li>
   </ul>
   <br>
</div>
<table class="table">
   <thead>
   <tr>
      <th>Nom</th>
      <th>Prénom</th>
      <th>Login</th>
      <th>Mot de passe</th>
      <th>Action</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${tUser}" var="user" varStatus="status">
      <tr>
         <td>${user.nom}</td>
         <td>${user.prenom}</td>
         <td>${user.login}</td>
         <td>${user.pwd}</td>
         <td>
            <a href="Update?pos=${status.index}" class="btn btn-primary"><i class="fas fa-pencil-alt"></i></a>
            <a href="Delete?pos=${status.index}" class="btn btn-danger" onclick="return confirmDelete();"><i class="fas fa-trash-alt"></i></a>
         </td>
      </tr>
   </c:forEach>
   </tbody>
</table>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>