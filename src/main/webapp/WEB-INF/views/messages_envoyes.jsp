<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:template>
	<jsp:body>
<h1>
	Ma messagerie
</h1>

<c:import url="messages_menu.jsp">
	<c:param name="activetab" value="envoyes"/>
</c:import>

<div class="panel panel-sucess">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<p>Liste des messages envoyés</p>
			</div>
			
			<table class="table">
                        <tr>
	                        <td>Titre :</td>
	                        <td>Date :</td>
	                    </tr>
	                    <c:forEach items="${MesMessagesE}" var="monMessageE">
	                    <tr>
                        	<td>${monMessageE.titre}</td>
                        	<td>${monMessageE.dateCreation}</td>
                        	<td><a href="<c:url value='/messages/envoyes/voir/${monMessageE.id}' />" class="btn btn-primary" role="button">
                        		<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        	</a></td>
                        </tr>
					</c:forEach>
			</table>
			
</div>


    </jsp:body>
</t:template>
