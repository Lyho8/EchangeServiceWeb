
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

		<input type="submit" value="Envoyer" />
	</form:form>
	
	
	<hr>
	<h3>Liste des utilisateurs :</h3>

	<table cellspacing="2px" cellpadding="2px;" rules="all"
		style="border: solid 1px black;">

		<tr>

			<th>ID</th>
			<th>PRENOM</th>
			<th>NOM</th>
			<th>SOLDE</th>
			<th>PAIEMENT</th>

		</tr>


		<c:forEach items="${listeUtilisateurs}" var="utilisateur">

			<tr>
				<td>${utilisateur.id}</td>
				<td>${utilisateur.prenom}</td>
				<td>${utilisateur.nom}</td>
				<td>${utilisateur.solde}</td>
				<td><a href="#"> Paiement </a></td>
			</tr>

		</c:forEach>


	</table>
	
	
	</jsp:body>
</t:template>
	