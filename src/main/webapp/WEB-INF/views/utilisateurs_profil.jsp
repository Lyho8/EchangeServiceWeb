<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
	
	<div class="container">
	
		<h2> ${utilisateur.prenom} ${ utilisateur.nom } </h2>
		<a href="<c:url value='/utilisateurs/actualiser/${utilisateur.id}' />"><spring:message code="utilisateurs.profil.editer" /></a><br>
		<div class="row">
				<div class="col-sm-3">		
					<div class="jumbotron">
						<img src="http://angeoudemongif.a.n.pic.centerblog.net/d3e42620.gif" height="100" width="150" />
					</div>
				</div>
				<div class="col-sm-6">
					<div class="jumbotron">
						<p>
							<spring:message code="utilisateurs.profil.date" /><br> ${utilisateur.dateInscription}.
						</p>
						<p><spring:message code="utilisateurs.profil.statut" />
							<c:choose>
							
								<c:when test="${utilisateur.actif}">
									<spring:message code="utilisateurs.profil.actif" />
								</c:when>
								
								<c:otherwise>
									<spring:message code="utilisateurs.profil.inactif" />
								</c:otherwise>
							
							</c:choose>
						</p>
						<p>
							login : ${ utilisateur.login }
						</p>
						<p>
							E-Mail : ${ utilisateur.email }
						</p>
						<p>
							<em><spring:message code="utilisateurs.profil.soldeRestant" /></em>  ${utilisateur.solde} crédits.
						</p>
							<a href="<c:url value='/utilisateurs/statut/${utilisateur.id}' />">
							<c:choose>
							
								<c:when test="${utilisateur.actif}">
									<spring:message code="utilisateurs.profil.desactiver" />
								</c:when>
								
								<c:otherwise>
									<spring:message code="utilisateurs.profil.activer" />
								</c:otherwise>
							
							</c:choose>
							</a>
					</div>
					</div>
				</div>	
	
	</div>

<!-- 	url vers annonces /annonces/id
 -->
	</jsp:body>

</t:template>