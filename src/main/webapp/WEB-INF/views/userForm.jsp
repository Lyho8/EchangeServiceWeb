<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>
<h1>
	SignIn 
</h1>

	<form:form method="POST" action="" modelAttribute="">
		<table>
			
			<tr>
				<td><form:label path="pseudo">Entrez votre identifiant : </form:label></td>
				<td><form:input path="pseudo" /></td>
				<td><form:errors path="pseudo"></form:errors></td>
			</tr>
			
			<tr>
				<td><form:label path="mdp">Entrez votre mot de passe :</form:label></td>
				<td><form:input path="mdp" /></td>
				<td><form:errors path="mdp"></form:errors></td>
			</tr>
			
		</table>

		<input type="submit" value="SignIn" />
	</form:form>
</jsp:body>
</t:template>
