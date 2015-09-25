<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:template>
	<jsp:body>
	
<div class="container">
 
    <div class="thumbnail">
      <img src="http://www.mot-a-mot.com/media/annonce/annonce_2.jpg"
						alt="annonce de test">
      <div class="caption">
      	<div class="row">
      	 <div class="col-sm-3">
	      	<div class="panel panel-info" >
				<div class="panel-body">
					<h3>Catégorie : <span class="label label-info" >${ annonce.categorie.libelle }</span></h3>
				</div>
			</div>
		</div>
		<div class="col-sm-3 col-sm-offset-6">
			<div class="panel panel-info">
				<div class="panel-body">
					<h3>${ annonce.type } de <a href="<c:url value="/utilisateurs/voir/${ annonce.auteur.id }" />">${ annonce.auteur.login }</a></h3>
				</div>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary ">
					<div class="panel-body text-center">
					   ${ annonce.description }
					</div>
				</div>
			</div>
		</div>
       </div>
	</div>
     
</div>

 <div class="row">
  <div class="col-sm-6 col-sm-offset-3">     
	<!-- affichage des commentaires de l'annonce -->
	<c:forEach items="${ annonce.commentaires }" var="comm">
		<div class="panel panel-default">
		  <div class="panel-heading"><a href="<c:url value="/utilisateurs/voir/${ annonce.auteur.id }" />">${ comm.auteur.login }</a></div>
		  <div class="panel-body">${ comm.contenu }</div>
		</div>
	</c:forEach>
	
	<sec:authorize access="isAuthenticated()">
	<!-- formulaire pour ajouter un commentaire sur l'annonce -->
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4>Ajouter un commentaire :</h4> 
		</div>
		<c:url value="/annonces/voir/${id}"  var="formaction" />
		<form:form method="post" modelAttribute="commentaire"
 							action="${formaction}">
 			<form:hidden path="auteur.id" />  
 			<form:hidden path="annonce.id" />
 			<div class="panel-body">  
				<div class="input-group">
	 				<form:textarea class="form-control" path="contenu" placeholder="Votre commentaire ici ..." cols="60" rows="6"/>
	 				<form:errors path="contenu" />  
	 			</div> 
				<br> 
	 			<div class="input-group">  
	 				<input class="form-control" type="submit" value="Commenter" /> 
	 			</div>
	 		</div>  
 		</form:form> 
  	</div>
  	</sec:authorize> 
	
    </div>
  </div>
	
    </jsp:body>
</t:template>
