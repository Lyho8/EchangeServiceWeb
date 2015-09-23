<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
		<h1>
			Liste des paiements
		</h1>
		
		<div class="row">
						
			  <div class="col-sm-2">
			  	<h3>Emis</h3>
			      <table class="table table-striped table-bordered">
			      	<tr>
			      		<th>Id</th>
			      		<th>Montant</th>
			      		<th>Message</th>
<%-- 			      		<th>Emetteur</th> --%>
			      		<th>Récepteur</th>
			      		<th>Statut</th>
			      		<th>Accepter</th>
			      		<th>Refuser</th>
			      	</tr>
			      	<c:forEach items="${ paiementsE }" var="p">
			      	<tr>			      	
			      		<td>${ p.id }</td>
			      		<td>${ p.montant }</td>
			      		<td>${ p.message }</td>
<%-- 			      		<td>${ p.emetteur.login }</td> --%>
			      		<td>${ p.recepteur.login }</td>
			      		<td>${ p.valide }</td>
			      		<td><c:if test="${ p.dateValidation==null }"><a href="<c:url value='/paiement/valider/${ p.id }' />">Accepter</a></c:if></td>
			      		<td><c:if test="${ p.dateValidation==null }"><a href="<c:url value='/paiement/refuser/${ p.id }' />">Refuser</a></c:if></td>
			      	</tr>
			      	</c:forEach>
			      </table>
			  </div>
			  
		  </div>
			  
		  <div class="row">
		  
			  <div class="col-sm-2">
			  	<h3>Reçus</h3>
			      <table class="table table-striped table-bordered">
			      	<tr>
			      		<th>Id</th>
			      		<th>Montant</th>
			      		<th>Message</th>
			      		<th>Emetteur</th>
<%-- 			      		<th>Recepteur</th> --%>
			      		<th>Statut</th>
			      	</tr>
			      	<c:forEach items="${ paiementsR }" var="p">
			      	<tr>			      	
			      		<td>${ p.id }</td>
			      		<td>${ p.montant }</td>
			      		<td>${ p.message }</td>
			      		<td>${ p.emetteur.login }</td>
<%-- 			      		<td>${ p.recepteur.login }</td> --%>
			      		<td>${ p.valide }</td>
			      	</tr>
			      	</c:forEach>
			      </table>
			  </div>
			  
		</div>
		
		<a href="<c:url value='/paiement/demande' />">Nouveau paiement</a>
		

    </jsp:body>
</t:template>
