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
		<span style="float: right"><h2><a href="utilisateurs/profil"><sec:authentication property="principal.username" /></a></h2> <a href="?lang=fr">fr</a> | <a href="?lang=en">en</a></span>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li role="presentation" <c:if test="${urlCourante=='home'}">class="active"</c:if>><a href="<c:url value='/' />">Page d'accueil</a></li>
				<li role="presentation" <c:if test="${urlCourante=='annonces'}">class="active"</c:if>><a href="<c:url value='/annonces' />">Annonces</a></li>
				<sec:authorize access="isAnonymous()">
					<li role="presentation" <c:if test="${urlCourante=='inscriptionConnection'}">class="active"</c:if>><a href="<c:url value='/utilisateurs/enregistrer' />">Inscription</a></li>
				</sec:authorize>
				<!-- Menu de gestion des utilisateurs  -->
				<sec:authorize access="isAuthenticated()">
				<li role="presentation">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						  <sec:authentication property="principal.username" />
						  <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li role="presentation"><a href="<c:url value='/annonces/nouvelle' />">Publier une annonce</a></li>
							<li role="presentation"><a href="<c:url value='/messages' />">Messages privés</a></li>
							<li role="presentation"><a href="<c:url value='/paiements' />">Mes transactions</a></li>
							<li role="presentation"><a href="<c:url value='/paiements/demande' />">Emettre une demande de paiement</a></li>
							<li role="presentation"><a href="<c:url value='/paiements/direct' />">Effectuer un paiement</a></li>
							<!-- Menu de gestion de l'admin  -->
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<li role="separator" class="divider"></li>
								<li role="presentation"><a href="<c:url value='/utilisateurs/lister' />">Gérer les utilisateurs</a></li>
								<li role="presentation"><a href="<c:url value='/annonces/categorie' />">Gérer les catégories</a></li>
							</sec:authorize>
							<li role="separator" class="divider"></li>
							<li role="presentation"><a href="<c:url value='/j_spring_security_logout'/>">Déconnexion</a></li>
						</ul>
					</div>
				</li>
				</sec:authorize>		
			</ul>

			<!-- formulaire de connection et lien inscription  -->
			<sec:authorize access="isAnonymous()">
				<form class="navbar-form navbar-left" role="login" action="<c:url value='/j_spring_security_check' />" method="post">
					<div class="form-group">
						<input type="text" name="j_username" class="form-control" placeholder="Login"> <input type="password" name="j_password" class="form-control" placeholder="Mot de passe">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</sec:authorize>
		</div>
	</nav>
	<jsp:doBody />

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
