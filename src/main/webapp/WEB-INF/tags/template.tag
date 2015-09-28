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
<body ng-app="EchangeServiceWeb" ng-controller="MainController as mainCtl">
	<nav class="navbar navbar-default">
		<span style="float: right"><a href="?lang=fr">fr</a> | <a href="?lang=en">en</a></span>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/'}">class="active"</c:if>><a href="<c:url value='/' />">Page d'accueil</a></li>
				<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/annonces'}">class="active"</c:if>><a href="<c:url value='/annonces' />">Annonces</a></li>
				<sec:authorize access="isAnonymous()">
					<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/utilisateurs/enregistrer'}">class="active"</c:if>><a href="<c:url value='/utilisateurs/enregistrer' />">Inscription</a></li>
				</sec:authorize>
				<!-- Menu de gestion des utilisateurs  -->
				<sec:authorize access="isAuthenticated()">
					<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/annonces/nouvelle'}">class="active"</c:if>><a href="<c:url value='/annonces/nouvelle' />">Publier une annonce</a></li>
					<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/messages'}">class="active"</c:if>><a href="<c:url value='/messages' />">Ma messagerie</a></li>
					<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/paiements'}">class="active"</c:if>><a href="<c:url value='/paiements' />">Mes transactions</a></li>
					<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/paiements/demande'}">class="active"</c:if>><a href="<c:url value='/paiements/demande' />">Faire une demande de paiement</a></li>
					<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/paiements/direct'}">class="active"</c:if>><a href="<c:url value='/paiements/direct' />">Effectuer un paiement</a></li>
					<!-- Menu de gestion de l'admin  -->
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li role="separator" class="divider"></li>
						<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/utilisateurs/lister/inactifs' }">class="active"</c:if>><a href="<c:url value='/utilisateurs/lister/inactifs' />">Gérer les utilisateurs</a></li>
						<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/annonces/categorie'}">class="active"</c:if>><a href="<c:url value='/annonces/categorie' />">Gérer les catégories</a></li>
					</sec:authorize>
					<!--------------------------------->
					<li role="presentation"><a href="<c:url value='/utilisateurs/profil'/>"><sec:authentication property="principal.username" /> ({{ mainCtl.solde }})</a></li>
					<li role="presentation" <c:if test="${requestScope['javax.servlet.forward.request_uri']=='/projetf/j_spring_security_logout'}">class="active"</c:if>><a href="<c:url value='/j_spring_security_logout'/>">Déconnexion</a></li>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.6/angular.min.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/app.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/controllers/MainController.js' />"></script>
</body>
</html>