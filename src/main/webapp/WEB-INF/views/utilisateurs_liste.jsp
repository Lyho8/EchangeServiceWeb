<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	
	<jsp:body>
	
	<h3>Liste des utilisateurs :</h3>

	<table class="table table-bordered">

		<tr>
			<th> ID </th>
			<th> PRENOM </th>
			<th> NOM </th>
			<th> SOLDE </th>
			<th> MODIFIER </th>
			<th> SUPPRIMER </th>
		</tr>


		<c:forEach items="${listeUtilisateurs}" var="utilisateur">

			<tr>
				<td> ${utilisateur.id} </td>
				<td> ${utilisateur.prenom} </td>
				<td> ${utilisateur.nom} </td>
				<td> ${utilisateur.solde} </td>
				<td><a href="utilisateurModifier?id=${utilisateur.id}"> Modifier </a></td>
				<td><a href="utilisateurSupprimer?id=${utilisateur.id}"> Supprimer </a></td>
			</tr>

		</c:forEach>
	</table>
	
	</jsp:body>
	
</t:template>