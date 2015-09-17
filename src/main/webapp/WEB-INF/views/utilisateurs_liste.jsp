<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	
	<jsp:body>
	
	<h3>Liste des utilisateurs :</h3>

	<table cellspacing="2px" cellpadding="2px;" rules="all"
		style="border: solid 1px black;">

		<tr>
			<th> ID </th>
			<th> PRENOM </th>
			<th> NOM </th>
			<th> SOLDE </th>
			<th> PAIEMENT </th>
		</tr>


		<c:forEach items="${listeUtilisateurs}" var="utilisateur">

			<tr>
				<td> ${utilisateur.id} </td>
				<td> ${utilisateur.prenom} </td>
				<td> ${utilisateur.nom} </td>
				<td> ${utilisateur.solde} </td>
				<td><a href="#"> Paiement </a></td>
			</tr>

		</c:forEach>
	</table>
	
	</jsp:body>
	
</t:template>