<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:template>
	<jsp:body>
<h1>
	Ma messagerie
</h1>

<ul class="nav nav-tabs">
  <li role="presentation"><a href="/projetf/messages/1">Messages reçus</a></li>
  <li role="presentation" class="active"><a
				href="/projetf/messages/envoyes/1">Messages envoyés</a></li>
  <li role="presentation"><a href="/projetf/messages/new/1">Nouveau message</a></li>
</ul>

<div class="panel panel-sucess">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<p>Liste des messages envoyés</p>
			</div>
			
			<table class="table">
                        <tr>
	                        <td>Auteur :</td>
	                        <td>Titre :</td>
	                        <td>Date :</td>
	                    </tr>
	                    <c:forEach items="${MesMessagesE}" var="monMessageE">
	                    <tr>
                        	<td>${monMessageE.auteur.login}</td>
                        	<td>${monMessageE.titre}</td>
                        	<td>${monMessageE.dateCreation}</td>
                        	<td><a href="/projetf/message/voir/${id}" class="btn btn-primary" role="button">
                        		<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        	</a></td>
                        </tr>
					</c:forEach>
			</table>
			
</div>


    </jsp:body>
</t:template>
