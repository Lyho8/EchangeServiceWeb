<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
		<h1>
			Nouveau paiement
		</h1>
		
		<form:form method="post" action="/projetf/paiement/nouveau/1"
		modelAttribute="paiement">
		<table class="table table-striped table-bordered">
			<tr>
				<td><form:label path="id">
						Id :
					</form:label></td>
				<td>${ paiement.id }<form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="montant">
						Montant :
					</form:label></td>
				<td><form:input path="montant" /></td>
				<%--Show errors for name field --%>
				<td><form:errors path="montant" /></td>
			</tr>
			<tr>

				<td><form:label path="message">
						Message :
					</form:label></td>
				<td><form:input path="message" /></td>
				<%--Show errors for firstname field --%>
				<td><form:errors path="message" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Valider" /></td>
			</tr>
		</table>
	</form:form>
		

    </jsp:body>
</t:template>
