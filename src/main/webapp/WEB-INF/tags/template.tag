<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta charset="utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<title></title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li role="presentation" <c:if test="${urlCourante=='home'}">class="active"</c:if>><a href="/projetf">Page d'accueil</a></li>
				<li role="presentation" <c:if test="${urlCourante=='annonces'}">class="active"</c:if>><a href="/projetf/annonces">Annonces</a></li>
				<sec:authorize access="isAnonymous()">
					<li role="presentation" <c:if test="${urlCourante=='inscriptionConnection'}">class="active"</c:if>><a href="/utilisateurs/inscription">Inscription</a></li>
				</sec:authorize>
			</ul>

			<!-- formulaire de connection et lien inscription  -->
			<sec:authorize access="isAnonymous()">
				<form class="navbar-form navbar-left" role="login" action="/projetf/j_spring_security_check" method="post">
					<div class="form-group">
						<input type="text" name="j_username" class="form-control" placeholder="Login"> <input type="password" name="j_password" class="form-control" placeholder="Mot de passe">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</sec:authorize>

			<!-- Menu de gestion des utilisateurs  -->
			<sec:authorize access="isAuthenticated()">
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				  <sec:authentication property="principal.username" />
				  <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li role="presentation"><a href="#">Publier une annonce</a></li>
					<li role="presentation"><a href="#">Messages</a></li>
					<li role="presentation"><a href="#">Faire un paiement</a></li>
					<li role="separator" class="divider"></li>
					<li role="presentation"><a href="<c:url value='/j_spring_security_logout'/>">Déconnexion</a></li>
				</ul>
			</div>
			</sec:authorize>

			<!-- Menu de gestion de l'admin  -->
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<ul class="dropdown-menu">
					<li role="presentation"><a href="#">Gérer les annonces</a></li>
					<li role="presentation"><a href="#">Gérer les utilisateurs</a></li>
				</ul>
			</sec:authorize>
		</div>
	</nav>
	<jsp:doBody />

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
