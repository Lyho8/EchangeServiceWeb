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
			      <table class="table table-striped table-bordered">
			      	<tr>
			      		<th>Id</th>
			      		<th>Montant</th>
			      		<th>Message</th>
			      		<th>Emetteur</th>
			      		<th>Recepteur</th>
			      	</tr>
			      	<c:forEach items="${ paiements }" var="p">
			      	<tr>			      	
			      		<td>${ p.id }</td>
			      		<td>${ p.montant }</td>
			      		<td>${ p.message }</td>
			      		<td>${ p.emetteur.login }</td>
			      		<td>${ p.recepteur.login }</td>
			      	</tr>
			      	</c:forEach>
			      </table>
			  </div>
			
		</div>
		
		<a href="/projetf/paiement/nouveau">Nouveau paiement pour utilisateur au choix</a>
		<a href="/projetf/paiement/nouveau/1">Nouveau paiement pour utilisateur 1</a>
		

    </jsp:body>
</t:template>
