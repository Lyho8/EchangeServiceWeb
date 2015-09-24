<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>
<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h4>Création d'une nouvelle annonce :</h4>
			</div>
			<div class="panel-body">
				<c:url value="/annonces/nouvelle" var="formaction" />
				<form:form method="post" modelAttribute="annonce" action="${formaction}">
					<form:hidden path="id" />
					<form:hidden path="auteur.id" />
					
					<div class="input-group">
						<form:label class="form-control" path="type">
							Type : </form:label>
						<form:select class="form-control" path="type" required="required">
							<form:options/>
						</form:select>
						<form:errors path="type" />
					</div>
					<br>
					<div class="input-group">
						<form:label class="form-control" path="description">
							Message : </form:label>
						<form:textarea class="form-control" path="description" rows="10" />
						<form:errors path="description" />
					</div>
					<br>
					<div class="input-group">
						<form:label class="form-control" path="categorie.id">
							Catégorie : </form:label>
						<form:select class="form-control" path="categorie.id">
							<form:options items="${categories}" itemLabel="libelle" itemValue="id" ></form:options>
						</form:select>
						<form:errors path="categorie" />
					</div>
					<br>
					<div class="input-group">
							<input class="form-control" type="submit" value="Poster l'annonce" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>

    </jsp:body>
</t:template>
