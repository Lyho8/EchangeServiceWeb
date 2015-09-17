<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li role="presentation"
					<c:if test="${urlCourante=='home'}">class="active"</c:if>><a
					href="/projetf">Page d'accueil</a></li>
				<li role="presentation"
					<c:if test="${urlCourante=='annonces'}">class="active"</c:if>><a
					href="/projetf/annonces">Annonces</a></li>
				<li role="presentation"
					<c:if test="${urlCourante=='inscriptionConnection'}">class="active"</c:if>><a
					href="#">Inscription/Connection</a></li>
			</ul>
			<!-- formulaire de connection et lien inscription  -->
			<c:if test="${userConnecte==false}">class="active"
			<form class="navbar-form navbar-left" role="login">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Login">
					<input type="text" class="form-control" placeholder="Mot de passe">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			</c:if>
			<!-- Menu de gestion des utilisateurs  -->
			<c:if test="${userConnecte==true}">
				<ul class="dropdown-menu">
					<li role="presentation"><a href="#">Publier une annonce</a></li>
					<li role="presentation"><a href="#">Messages</a></li>
					<li role="presentation"><a href="#">Faire un paiement</a></li>
				</ul>
			</c:if>
						<!-- Menu de gestion de l'admin  -->
			<c:if test="${userConnecte==true}">
				<ul class="dropdown-menu">
					<li role="presentation"><a href="#">Gérer les annonces</a></li>
					<li role="presentation"><a href="#">Gérer les utilisateurs</a></li>
				</ul>
			</c:if>
		</div>
	</nav>
	<jsp:doBody />
</body>
</html>
