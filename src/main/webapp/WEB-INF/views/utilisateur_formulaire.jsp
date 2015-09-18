
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>

<%-- <a href="<%=request.getContextPath()%>/projetf">vers Accueil</a>
	******** --%>
<h3> Création d'un compte. </h3>

	<form:form method="POST" action="/projetf/utilisateur/formulaire" modelAttribute="utilisateur">
	
		<table class="table table-bordered">
			
			<tr>
				<td><form:label path="prenom">Entrez votre prénom : </form:label></td>
				<td><form:input path="prenom" /></td>
 				<td><form:errors path="prenom"></form:errors></td>
			</tr>
			
			<tr>
				<td><form:label path="nom">Entrez votre nom :</form:label></td>
				<td><form:input path="nom" /></td>
 				<td><form:errors path="nom"></form:errors></td> 
			</tr>
			
			<tr>
				<td><form:label path="email">Entrez votre email :</form:label></td>
				<td><form:input path="email" /></td>
 				<td><form:errors path="email"></form:errors></td> 
			</tr>

			<tr>
				<td><form:label path="login">Entrez votre login :</form:label></td>
				<td><form:input path="login" /></td>
 				<td><form:errors path="login"></form:errors></td>
 			</tr>
			
			<tr>
				<td><form:label path="motDePasse">Entrez votre mot de passe :</form:label></td>
				<td><form:input path="motDePasse" /></td>
 				<td><form:errors path="motDePasse"></form:errors></td>
 			</tr>
			
		</table>
		
		<form:hidden path="id"/>

		<input type="submit" value="Envoyer" />
	</form:form>

	
	</jsp:body>
</t:template>



	