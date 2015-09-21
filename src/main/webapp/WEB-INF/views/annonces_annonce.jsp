<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:template>
	<jsp:body>
	
	<div class="row">
  <div class="col-sm-2">
    <div class="thumbnail">
      <img src="http://www.mot-a-mot.com/media/annonce/annonce_2.jpg"
						alt="annonce de test">
      <div class="caption">
        <h3>${ annonce.type } de ${ annonce.auteur.login }</h3>
        <p>${ annonce.description }</p>
      </div>
      
	<!-- affichage des commentaires de l'annonce -->
	<c:forEach items="${ annonce.commentaires }" var="commentaire">
		<div class="panel panel-default">
		  <div class="panel-heading">${ commentaire.auteur.login }</div>
		  <div class="panel-body"> ${ commentaire.contenu }</div>
		</div>
	</c:forEach>
	
	<!-- formulaire pour ajouter un commentaire sur l'annonce -->
	<div class="panel panel-info">
		<form:form method="post" modelAttribute="commentaire"
 							action="/projetf/annonces/voir/${id}">  
<%--  			<form:hidden path="auteur.id" />  --%>
<%--  			<form:hidden path="annonce.id" />  --%>
			<div class="field_group">
 				<form:label path="contenu"></form:label>  
 				<form:input type="text" path="contenu" value="Votre message ici ..." />  
 				<form:errors path="contenu" />  
 			</div> 
			<br> 
 		<div class="field_group">  
 				<input type="submit" value="Commenter" /> 
 			</div>  
 		</form:form> 
  	</div>  
	
    </div>
  </div>
  </div>	
	
    </jsp:body>
</t:template>
