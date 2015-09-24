<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:template>
	<jsp:body>
<h1>
	Ma messagerie
</h1>

<c:import url="messages_menu.jsp">
	<c:param name="activetab" value="new"/>
</c:import>

<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
		<div class="panel panel-info">
			<div class="panel-body">
				<c:url value="/messages/new" var="formaction" />
				<form:form method="post" modelAttribute="messagePrive"
							action="${formaction}">
					<form:hidden path="auteur.id"/>
						<div class="input-group">
							<form:label class="form-control" path="destinataires">
								Destinataire(s) : </form:label>
							<form:textarea class="form-control" path="destinataires" required="required" />
							<form:errors path="destinataires" />
						</div>
						<br>
						<div class="input-group">
							<form:label class="form-control" path="titre">
								Sujet :</form:label>
							<form:input class="form-control" type="text" path="titre" />
							<form:errors path="titre" />
						</div>
						<br>
						<div class="input-group">
							<form:label class="form-control" path="contenu" > Contenu de votre message:</form:label>
							<form:textarea class="form-control" type="text" path="contenu" rows="10"/>
							<form:errors path="contenu" />
						</div>
						<br>
						<div class="input-group">
							<input class="form-control" type="submit" value="Envoie" />
						</div>
				</form:form>
			</div>
		</div>
	</div>
</div>


    </jsp:body>
</t:template>
