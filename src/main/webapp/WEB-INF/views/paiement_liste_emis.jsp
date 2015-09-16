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
			<c:forEach items="${ paiements }" var="p">			
			  <div class="col-sm-2">
			    <div class="thumbnail">
			      <table class="table table-striped table-bordered">
			      	<tr>
			      		<th>Id</th>
			      		<th>Montant</th>
			      	</tr>
			      	<tr>
			      		<td>${ p.id }</td>
			      		<td>${ p.montant }</td>
			      	</tr>
			      </table>
			    </div>
			  </div>
			</c:forEach>
		</div>
		

    </jsp:body>
</t:template>
