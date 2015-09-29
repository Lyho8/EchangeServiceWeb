<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
<h1>
	<c:choose>
		<c:when test="${ loggedID == utilisateur.id }">
			Vos annonces
		</c:when>
		<c:otherwise>
			Liste des annonces <c:if test="${ not empty utilisateur }">de ${ utilisateur.login }</c:if>
		</c:otherwise>
	</c:choose>
</h1>

<c:choose>
<c:when test="${fn:length(annonces) gt 0}">
<div class="row">
<c:forEach items="${annonces}" var="annonce">
  <div class="col-sm-2">
    <div class="thumbnail">
      <img src="${annonce.image}" alt="annonce de test">
      <div class="caption">
        <h3>${ annonce.type } de <a href="<c:url value="/utilisateurs/voir/${ annonce.auteur.id }" />">${ annonce.auteur.login }</a></h3>
        <p>${ annonce.categorie.libelle }</p>
        <p><a href="<c:url value="/annonces/voir/${ annonce.id }" />" class="btn btn-primary" role="button">Voir l'annonce</a> </p>
      </div>
    </div>
  </div>
</c:forEach>
</div>
</c:when>
<c:otherwise>
	<div class="alert alert-danger" role="alert">
		<c:choose>
			<c:when test="${ loggedID == utilisateur.id }">
				Vous n'avez posté aucune annonce.
			</c:when>
			<c:otherwise>
				Cet utilisateur n'a posté aucune annonce.
			</c:otherwise>
		</c:choose>
	</div>
</c:otherwise>
</c:choose>

    </jsp:body>
</t:template>
