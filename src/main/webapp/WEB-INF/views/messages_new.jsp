<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:template>
	<jsp:body>
<h1>
	Page de gestion des messages
</h1>

<ul class="nav nav-tabs">
  <li role="presentation"><a href="/projetf/messages">Messages reçus</a></li>
  <li role="presentation"><a href="/projetf/messages/envoyes">Messages envoyés</a></li>
  <li role="presentation" class="active"><a href="/projetf/messages/new/1">Nouveau message</a></li>
</ul>

<div class="panel panel-info">
	<form:form method="post" modelAttribute="messagePrive"
				action="/projetf/messages/new/envoie/1">
		<div class="field_group">
			<form:label path="destinataires">
				Destinataire(s) : </form:label>
			<form:input type="text" path="destinataires" required="required" />
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
			<form:input type="text" path="contenu" />
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
