<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
<h1>
	Liste des annonces <c:if test="${ not empty utilisateur }">de ${ utilisateur.login }</c:if>
</h1>

<c:choose>
<c:when test="${fn:length(annonces) gt 0}">
<div class="row">
<c:forEach items="${annonces}" var="annonce">
  <div class="col-sm-2">
    <div class="thumbnail">
      <img src="http://www.mot-a-mot.com/media/annonce/annonce_2.jpg" alt="annonce de test">
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
	<div class="alert alert-danger" role="alert">Cet utilisateur n'a posté aucune annonce.</div>
</c:otherwise>
</c:choose>

    </jsp:body>
</t:template>
