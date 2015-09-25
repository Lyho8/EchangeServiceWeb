<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
	
		<h1>			
			<c:if test="${!en_attente}">Historique des transactions</c:if>
			<c:if test="${en_attente}">Transactions en attente</c:if>
		</h1>

<c:if test="${!en_attente}">		
	<c:import url="paiements_menu.jsp">
		<c:param name="activetab" value="historique"/>
	</c:import>
</c:if>

<c:if test="${en_attente}">
	<c:import url="paiements_menu.jsp">
		<c:param name="activetab" value="en_attente"/>
	</c:import>
</c:if>

		<div class="row">
						
			  <div class="col-sm-6 col-sm-offset-3">
			  	<c:if test="${en_attente}"><h3>Demandes reçues</h3></c:if>
			  	<c:if test="${!en_attente}"><h3>Paiements émis</h3></c:if>
			      <table class="table table-striped table-bordered">
			      	<tr>
			      		<th>Id</th>
			      		<th>Montant</th>
			      		<th>Message</th>
			      		<th>Récepteur</th>
			      		<c:if test="${en_attente}"><th>Date d'émission</th></c:if>
			  			<c:if test="${!en_attente}"><th>Date de validation</th></c:if>
			      		<th>Statut</th>
			      		<c:if test="${en_attente}"><th>Accepter</th></c:if>
			      		<c:if test="${en_attente}"><th>Refuser</th></c:if>
			      	</tr>
			      	<c:forEach items="${ paiementsE }" var="p">
			      	<tr>			      	
			      		<td>${ p.id }</td>
			      		<td>${ p.montant }</td>
			      		<td>${ p.message }</td>
			      		<td>${ p.recepteur.login }</td>
			      		<c:if test="${en_attente}"><td><fmt:formatDate type="both" value="${ p.dateDemande }" /></td></c:if>
			  			<c:if test="${!en_attente}"><td><fmt:formatDate type="both" value="${ p.dateValidation }" /></td></c:if>
			      		<c:if test="${p.valide}"><td>Validé</td></c:if>
			  			<c:if test="${!p.valide}"><c:if test="${en_attente}"><td>En attente</td></c:if></c:if>
			  			<c:if test="${!p.valide}"><c:if test="${!en_attente}"><td>Refusé</td></c:if></c:if>
			      		<c:if test="${en_attente}"><td><c:if test="${ p.dateValidation==null }"><a href="<c:url value='/paiements/valider/${ p.id }' />">Accepter</a></c:if></td></c:if>
			      		<c:if test="${en_attente}"><td><c:if test="${ p.dateValidation==null }"><a href="<c:url value='/paiements/refuser/${ p.id }' />">Refuser</a></c:if></td></c:if>
			      	</tr>
			      	</c:forEach>
			      </table>
			  </div>
			  
		  </div>
			  
		  <div class="row">
		  
			  <div class="col-sm-6 col-sm-offset-3">
			  	<c:if test="${en_attente}"><h3>Demandes émises</h3></c:if>
			  	<c:if test="${!en_attente}"><h3>Paiements reçus</h3></c:if>
			      <table class="table table-striped table-bordered">
			      	<tr>
			      		<th>Id</th>
			      		<th>Montant</th>
			      		<th>Message</th>
			      		<th>Emetteur</th>
			      		<c:if test="${en_attente}"><th>Date d'émission</th></c:if>
			  			<c:if test="${!en_attente}"><th>Date de validation</th></c:if>
			      		<th>Statut</th>
			      	</tr>
			      	<c:forEach items="${ paiementsR }" var="p">
			      	<tr>			      	
			      		<td>${ p.id }</td>
			      		<td>${ p.montant }</td>
			      		<td>${ p.message }</td>
			      		<td>${ p.emetteur.login }</td>
			      		<c:if test="${en_attente}"><td><fmt:formatDate type="both" value="${ p.dateDemande }" /></td></c:if>
			  			<c:if test="${!en_attente}"><td><fmt:formatDate type="both" value="${ p.dateValidation }" /></td></c:if>
			  			<c:if test="${p.valide}"><td>Validé</td></c:if>
			  			<c:if test="${!p.valide}"><c:if test="${en_attente}"><td>En attente</td></c:if></c:if>
			  			<c:if test="${!p.valide}"><c:if test="${!en_attente}"><td>Refusé</td></c:if></c:if>
			      	</tr>
			      	</c:forEach>
			      </table>
			  </div>
			  
		</div>		

    </jsp:body>
</t:template>
