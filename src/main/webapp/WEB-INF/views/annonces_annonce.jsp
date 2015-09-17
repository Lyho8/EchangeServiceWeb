<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
	
	<h1>${ annonce.type } de ${ annonce.auteur.login }</h1>
	
	<div>${ annonce.description }</div>
	<c:forEach items="${ annonce.commentaires }" var="commentaire">
		<p>${ commentaire.auteur.login } : ${ commentaire.contenu }</p>
	</c:forEach>
    </jsp:body>
</t:template>
