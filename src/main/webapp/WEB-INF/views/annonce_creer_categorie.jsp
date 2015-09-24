<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:template>
	<jsp:body>
	
<div class="row">
  <div class="col-sm-6">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4>Liste des catégories :</h4>
		</div>
		<div class="panel-body">     
			<!-- affichage de la liste des categories existantes -->
			<ul>
				<c:forEach items="${ categories }" var="categorie">
					<li>${ categorie.libelle }</li>
				</c:forEach>
			</ul>
		</div>
	</div>
  </div>
  <div class="col-sm-6">
	<!-- formulaire pour creer une nouvelle categorie -->
	<div class="panel panel-info">
		<c:url value="/annonces/categorie"  var="formaction" />
		<form:form method="post" modelAttribute="categorie"
 							action="${formaction}">
			<div class="input-group">
 				<form:label class="form-control" path="libelle">La nouvelle catégorie :</form:label>  
 				<form:input class="form-control" type="text" path="libelle" />  
 				<form:errors class="form-control" path="libelle" />  
 			</div> 
			<br> 
 			<div class="input-group">  
 				<input class="form-control" type="submit" value="Valider" /> 
 			</div>  
 		</form:form> 
  	</div>
  </div>
</div>	
	
    </jsp:body>
</t:template>
