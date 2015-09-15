<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
	<div>
		<ul class="nav nav-pills">
		  <li role="presentation" <c:if test="${urlCourante=='home'}">class="active"</c:if>><a href="#">Page d'accueil</a></li>
		  <li role="presentation" <c:if test="${urlCourante=='annonces'}">class="active"</c:if>><a href="#">Annonces</a></li>
		  <li role="presentation" <c:if test="${urlCourante=='inscriptionConnection'}">class="active"</c:if>><a href="#">Inscription/Connection</a></li>
		</ul>
		<c:if test="${userConnecter==true}">
			<ul class="dropdown-menu">
		      <li role="presentation" ><a href="#">Publier une annonce</a></li>
			  <li role="presentation" ><a href="#">Messages</a></li>
			  <li role="presentation" ><a href="#">Faire un paiement</a></li>
		    </ul>
	    </c:if>
	</div>
	<jsp:doBody />
</body>
</html>
