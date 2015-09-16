
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>


<a href="<%=request.getContextPath()%>/projetf">vers Accueil</a>
	********

<h3>
	Création d'un compte.
</h3>

	<form:form method="POST" action="/projetf/utilisateur" modelAttribute="utilisateur">
		<table>
			
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
				<td><form:label path="mail">Entrez votre mail :</form:label></td>
				<td><form:input path="mail" /></td>
				<td><form:errors path="mail"></form:errors></td>
			</tr>			

			<tr>
				<td><form:label path="pseudo">Entrez votre pseudonyme :</form:label></td>
				<td><form:input path="pseudo" /></td>
				<td><form:errors path="pseudo"></form:errors></td>
			</tr>
			
			<tr>
				<td><form:label path="mdp">Entrez votre mot de passe :</form:label></td>
				<td><form:input path="mdp" /></td>
				<td><form:errors path="mdp"></form:errors></td>
			</tr>
			
		</table>

		<input type="submit" value="Register" />
	</form:form>
	</jsp:body>
</t:template>
	