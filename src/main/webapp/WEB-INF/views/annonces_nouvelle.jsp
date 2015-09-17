<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
<h1>
	Ajout d'une tâche
</h1>

<form:form method="post" modelAttribute="annonce" action="/projetf/annonces/nouvelle">
	<form:hidden path="id" />
	<form:hidden path="auteur.id" />
	<table id="form">
		<tr>
			<td>Type:</td>
			<td><form:select path="type">
				<form:options/>
			</form:select></td>
			<td><form:errors path="type" /></td>
		</tr>
		<tr>
			<td>Message:</td>
			<td><form:textarea path="description" /></td>
			<td><form:errors path="description" /></td>
		</tr>
		<tr>
			<td>Catégorie:</td>
			<td><form:select path="categorie">
				<form:options items="${categories}" itemLabel="libelle" itemValue="id" />
			</form:select></td>
			<td><form:errors path="categorie" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Créer annonce" /></td>
		</tr>
	</table>
</form:form>

    </jsp:body>
</t:template>
