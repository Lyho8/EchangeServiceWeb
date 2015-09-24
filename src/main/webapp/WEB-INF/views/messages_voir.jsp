<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:template>
	<jsp:body>
	
<h1>
	Ma messagerie
</h1>

<c:import url="messages_menu.jsp">
</c:import>

<div class="row">
  <div class="col-sm-4 col-sm-offset-4">	
	<div class="panel panel-info">
	  <div class="panel-heading">Sujet : ${ messagePrive.titre }</div>
	  <div class="panel-body">
	  <ul class="list-group">
	    <li class="list-group-item">Auteur : ${ messagePrive.auteur.login }</li>
	    <li class="list-group-item">Destinataire(s) :
		    <c:forEach items="${messagePrive.destinataires}" var="monDestinataire">
		    	 ${ monDestinataire.login } ,
		    </c:forEach>
	    </li>
	  </ul>
	    <div class="panel panel-default">
	      <div class="panel-heading">Contenu du message :</div>
		  <div class="panel-body">
		    ${ messagePrive.contenu }
		  </div>
		</div>
	  </div>
	</div>
  </div>
</div>
 
 
	
    </jsp:body>
</t:template>
