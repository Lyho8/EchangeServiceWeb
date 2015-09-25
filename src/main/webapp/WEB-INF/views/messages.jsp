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
	<c:param name="activetab" value="recus"/>
</c:import>


<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
		<div class="panel panel-primary">
			<div class="panel-body">
				<table class="table">
                    <tr>
                     <td><h4>Auteur :</h4></td>
                     <td><h4>Sujet :</h4></td>
                     <td><h4>Date :</h4></td>
                 </tr>
                 <c:forEach items="${MesMessagesR}" var="monMessageR">
                 <tr>
                    	<td>${monMessageR.auteur.login}</td>
                    	<td>${monMessageR.titre}</td>
                    	<td>${monMessageR.dateCreation}</td>
                    	<td>
                    		<c:if test="${monMessageR.lu == true}"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if>
                    		<c:if test="${monMessageR.lu == false}"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if>
                    	</td>
                    	<td><a href="<c:url value='/messages/voir/${monMessageR.id}' />" class="btn btn-primary" role="button">
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
