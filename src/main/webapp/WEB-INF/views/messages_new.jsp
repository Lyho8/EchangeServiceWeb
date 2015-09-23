<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:template>
	<jsp:body>
<h1>
	Ma messagerie
</h1>

<c:import url="messages_menu.jsp">
	<c:param name="activetab" value="new"/>
</c:import>

<div class="panel panel-info">
	<c:url value="/messages/new" var="formaction" />
	<form:form method="post" modelAttribute="messagePrive"
				action="${formaction}">
		<form:hidden path="auteur.id"/>
		<div class="field_group">
			<form:label path="destinataires">
				Destinataire(s) : </form:label>
			<form:textarea path="destinataires" required="required" />
			<form:errors path="destinataires" />
		</div>
		<br>
		<div class="field_group">
			<form:label path="titre">
				Titre :</form:label>
			<form:input type="text" path="titre" />
			<form:errors path="titre" />
		</div>
		<br>
		<div class="field_group">
			<form:label path="contenu"> Contenu :</form:label>
			<form:textarea type="text" path="contenu" />
			<form:errors path="contenu" />
		</div>
		<br>
		<div class="field_group">
			<input type="submit" value="Save" />
		</div>
	</form:form>
</div>


    </jsp:body>
</t:template>
