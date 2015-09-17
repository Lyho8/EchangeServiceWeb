<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:template>
	<jsp:body>
<h1>
	Page de gestion des messages
</h1>

<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a
				href="/projetf/messages/1">Messages reçus</a></li>
  <li role="presentation"><a href="/projetf/messages/envoyes/1">Messages envoyés</a></li>
  <li role="presentation"><a href="/projetf/messages/new/1">Nouveau message</a></li>
</ul>

<div class="panel panel-sucess">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<p>Liste des messages reçus</p>
			</div>
			
			<ul class="list-group">
				<li class="list-group-item"><c:forEach items="${MesMessagesR}"
						var="monMessageR">
                        Auteur :
                        ${monMessageR.auteur}
                        &nbsp;
                        Titre :
                        ${monMessageR.titre}
                        &nbsp;
                        Contenu :
                        ${monMessageR.contenu}
                        &nbsp;
						<a class="glyphicon glyphicon-trash"
							href="/projetf/messages/supprimer?id=${monMessageR.id}">Supprimer</a>
						<br>
					</c:forEach></li>

			</ul>
		</div>


    </jsp:body>
</t:template>
