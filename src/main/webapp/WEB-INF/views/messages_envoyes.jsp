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

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-body">
				<table class="table">
		                       <tr>
		                        <td><h4>Sujet :</h4></td>
		                        <td><h4>Date :</h4></td>
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
		</div>
	</div>
</div>


    </jsp:body>
</t:template>
