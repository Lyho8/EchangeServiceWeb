<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
<h1>
	DTA Echange-Service
</h1>

<h2>Les derni�res demandes</h2>
<div class="row">
<c:forEach items="${demandes}" var="annonce">
  <div class="col-sm-2">
    <div class="thumbnail">
      <img src="${annonce.image}" alt="annonce de test">
      <div class="caption">
        <h3>${ annonce.type } de <a href="<c:url value="/utilisateurs/voir/${ annonce.auteur.id }" />">${ annonce.auteur.login }</a></h3>
        <p>${ annonce.categorie.libelle }</p>
        <p><a href="<c:url value="/annonces/voir/${ annonce.id }" />" class="btn btn-primary" role="button">Voir l'annonce</a></p>
      </div>
    </div>
  </div>
</c:forEach>
</div>

<h2>Les derni�res offres</h2>
<div class="row">
<c:forEach items="${offres}" var="annonce">
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

    </jsp:body>
</t:template>
