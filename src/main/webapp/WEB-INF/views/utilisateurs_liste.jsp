<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
	
	
	
	<h2>
		<em><spring:message code="utilisateurs.liste.titre" /></em>
	</h2>
	<br>
	<hr>
	<div class="container">
		<c:choose>
					
			<c:when test="${actif}">
				<spring:message code="utilisateurs.profil.actif" />
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3">
						<div class="panel panel-primary">
							<div class="panel-body">
				<table class="table table-striped table-bordered">

					<tr>
						<th> ID </th>
						<th> <spring:message code="utilisateurs.liste.attributPrenom" /> </th>
						<th> <spring:message code="utilisateurs.liste.attributNom" />  </th>
						<th> <spring:message code="utilisateurs.liste.attributSolde" />  </th>
						<th> <spring:message code="utilisateurs.liste.profil" />  </th>
						<th> <spring:message code="utilisateurs.liste.modifier" />  </th>
						<th> <spring:message code="utilisateurs.liste.desactiver" />  </th>
					</tr>
			
			
					<c:forEach items="${listeUtilisateurs}" var="utilisateur">
			
						<tr>
							<td> ${utilisateur.id} </td>
							<td> ${utilisateur.prenom} </td>
							<td> ${utilisateur.nom} </td>
							<td> ${utilisateur.solde} </td>
							<td> <a href="<c:url value='/utilisateurs/voir/${utilisateur.id}'/>">
									<spring:message code="utilisateurs.liste.profilVoir" />
								</a>
							</td>
							<td> <a href="<c:url value='/utilisateurs/actualiser/${utilisateur.id}' />">
									<img src="http://www.fengoffice.com/web/wiki/lib/exe/fetch.php/toolbar_edit.jpg">
								</a>
							</td>
							<td> <a href="<c:url value='/utilisateurs/statut/${utilisateur.id}' />">
									<img src="http://www.medoc-chandelliere.com/images/supprimer.gif"/>
								</a>
							</td>
						</tr>

					</c:forEach>
	
				</table>
				
				</div>
				</div>
				</div>
				</div>
				
				
			</c:when>
									
			<c:otherwise>
				<spring:message code="utilisateurs.profil.inactif" />
				
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3">
						<div class="panel panel-primary">
							<div class="panel-body">
				<table class="table table-striped table-bordered">

					<tr>
						<th> ID </th>
						<th> <spring:message code="utilisateurs.liste.attributPrenom" /> </th>
						<th> <spring:message code="utilisateurs.liste.attributNom" />  </th>
						<th> <spring:message code="utilisateurs.liste.attributSolde" />  </th>
						<th> <spring:message code="utilisateurs.liste.profil" />  </th>
						<th> <spring:message code="utilisateurs.liste.modifier" />  </th>
						<th> <spring:message code="utilisateurs.liste.activer" />  </th>
					</tr>
			
			
					<c:forEach items="${listeUtilisateurs}" var="utilisateur">
			
						<tr>
							<td> ${utilisateur.id} </td>
							<td> ${utilisateur.prenom} </td>
							<td> ${utilisateur.nom} </td>
							<td> ${utilisateur.solde} </td>
							<td> <a href="<c:url value='/utilisateurs/voir/${utilisateur.id}'/>">
									<spring:message code="utilisateurs.liste.profilVoir" />
								</a>
							</td>
							<td> <a href="<c:url value='/utilisateurs/actualiser/${utilisateur.id}' />">
									<img src="http://www.fengoffice.com/web/wiki/lib/exe/fetch.php/toolbar_edit.jpg">
								</a>
							</td>
							<td> <a href="<c:url value='/utilisateurs/statut/${utilisateur.id}' />">
									<img src="https://www.zotero.org/support/_media/add.png"/>
								</a>
							</td>
						</tr>
			
					</c:forEach>
				
				</table>
				</div>
				</div>
				</div>
				</div>
			
				
			</c:otherwise>
								
		</c:choose>
	</div>
	
	
	
	</jsp:body>

</t:template>