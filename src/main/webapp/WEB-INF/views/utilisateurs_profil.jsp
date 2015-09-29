<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
	
	<div class="container">
	
		<h2> ${utilisateur.prenom} ${ utilisateur.nom } </h2>
		<sec:authorize access="isAuthenticated()">
			<c:if test="${ loggedID == utilisateur.id }">
				<a href="<c:url value='/utilisateurs/actualiser/${utilisateur.id}' />"><spring:message code="utilisateurs.profil.editer" /></a><br>
			</c:if>
		</sec:authorize>
		<div class="row">
				<div class="col-sm-3">		
					<div class="jumbotron">
						<img src="http://angeoudemongif.a.n.pic.centerblog.net/d3e42620.gif" height="100" width="150" />
					</div>
				</div>
				<div class="col-sm-6">
					<div class="jumbotron">
						<p>
							<spring:message code="utilisateurs.profil.date" /><br> <fmt:formatDate type="both" value="${utilisateur.dateInscription}" />
						</p>
						<p><spring:message code="utilisateurs.profil.statut" />
							<c:choose>
							
								<c:when test="${ utilisateur.actif }">
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
						<p>
							<a href="<c:url value='/annonces/${utilisateur.id}' />">
								<c:choose>
									<c:when test="${ loggedID == utilisateur.id }">
										voir mes annonces
									</c:when>
									<c:otherwise>
										voir les annonces de cet utilisateur
									</c:otherwise>
								</c:choose>
							</a>
						</p>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<p>
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
						</p>
						</sec:authorize>
					</div>
					</div>
				</div>	
	
	</div>


	</jsp:body>

</t:template>