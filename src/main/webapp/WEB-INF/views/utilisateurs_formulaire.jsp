
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>

	<c:url value="/utilisateurs/enregistrer" var="formaction" />
	<form:form method="POST" action="${formaction}" modelAttribute="utilisateur">
	
	<div class="container">
	
	<div class="jumbotron">
	
	<h3> Entrez vos coordonnées :</h3>
	
		<table class="table table-bordered">
			
			<tr>
				<td><form:label path="prenom">Entrez votre prénom :</form:label></td>
				<td><form:input path="prenom" /></td>
			</tr>
			
			<tr>
				<td><form:label path="nom">Entrez votre nom :</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>
			
			<tr>
				<td><form:label path="email">Entrez votre email :</form:label></td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td><form:label path="login">Entrez votre login :</form:label></td>
				<td><form:input path="login" /></td>
 			</tr>

 		<c:if test="${utilisateur.id==0}">		
 			<tr>
				<td><form:label path="motDePasse">Entrez votre mot de passe :</form:label></td>
				<td><form:password path="motDePasse" /></td>
 			</tr>
 		</c:if>
 		
		</table>
	
		<form:hidden path="id" />
		<c:if test="${utilisateur.id != 0}">
			<form:hidden path="motDePasse" />
		</c:if>

		<input type="submit" value="Envoyer" />
		
		</div>
		</div>
	</form:form>

	
	</jsp:body>
</t:template>



