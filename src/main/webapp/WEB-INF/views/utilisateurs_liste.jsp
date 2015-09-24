<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
	
	<h2>
		<em> Liste des utilisateurs : </em>
	</h2>
	<br>
	<hr>
	
	<div class="row">
  	<div class="col-sm-6">
    <div class="jumbotron">

	<div class="container">
	<h3>Liste des utilisateurs actifs:</h3>

	<table class="table table-bordered ">

		<tr>
			<th> ID </th>
			<th> PRENOM </th>
			<th> NOM </th>
			<th> SOLDE </th>
			<th> PROFIL </th>
			<th> MODIFIER </th>
			<th> DESACTIVER </th>
		</tr>


		<c:forEach items="${listeUtilisateursActifs}" var="utilisateur">

			<tr>
				<td> ${utilisateur.id} </td>
				<td> ${utilisateur.prenom} </td>
				<td> ${utilisateur.nom} </td>
				<td> ${utilisateur.solde} </td>
				<td> <a href="<c:url value='/utilisateurs/voir/${utilisateur.id}'/>">voir</a></td>
				<td> <a href="<c:url value='/utilisateurs/actualiser/${utilisateur.id}' />">modifier</a></td>
				<td> <a href="<c:url value='/utilisateurs/statut/${utilisateur.id}' />">desactiver</a></td>
			</tr>

		</c:forEach>
	
	</table>
	
	</div>
	
	</div>
	</div>
	
	<div class="col-sm-6">
    <div class="jumbotron">
	
	<div class="container">
	<h3>Liste des utilisateurs inactifs:</h3>
	
	
	<table class="table table-bordered ">

		<tr>
			<th> ID </th>
			<th> PRENOM </th>
			<th> NOM </th>
			<th> SOLDE </th>
			<th> PROFIL </th>
			<th> MODIFIER </th>
			<th> ACTIVER </th>
		</tr>


		<c:forEach items="${listeUtilisateursInactifs}" var="utilisateur">

			<tr>
				<td> ${utilisateur.id} </td>
				<td> ${utilisateur.prenom} </td>
				<td> ${utilisateur.nom} </td>
				<td> ${utilisateur.solde} </td>
				<td> <a href="<c:url value='/utilisateurs/voir/${utilisateur.id}'/>">voir</a></td>
				<td> <a href="<c:url value='/utilisateurs/actualiser/${utilisateur.id}' />">modifier</a></td>
				<td> <a href="<c:url value='/utilisateurs/statut/${utilisateur.id}' />">activer</a></td>
			</tr>

		</c:forEach>
	
	</table>
	
	</div>
	
	</div>
	</div>
	
	
	</div>


	</jsp:body>

</t:template>