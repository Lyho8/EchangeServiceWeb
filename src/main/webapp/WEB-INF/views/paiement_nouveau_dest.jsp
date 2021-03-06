<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
		<h1>
			Nouvelle demande de paiement
		</h1>
		
		<c:url value="/paiements/demande" var="formaction" />
		<form:form method="post" action="${formaction}"
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
				<td><form:errors path="montant" /></td>
			</tr>
			<tr>

				<td><form:label path="message">
						Message :
					</form:label></td>
				<td><form:input path="message" /></td>
				<td><form:errors path="message" /></td>
			</tr>
			<tr>
				<td><form:label path="emetteur.id"></form:label></td>
				<td><form:select path="emetteur.id">
					<form:options items="${ users }" itemLabel="login" itemValue="id" />
				</form:select></td>
			</tr>			
			<tr>
				<td><input type="submit" value="Valider" /></td>
			</tr>
		</table>
	</form:form>
		

    </jsp:body>
</t:template>
