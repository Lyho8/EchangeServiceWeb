<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
	
	<h1>Connexion</h1>
	
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
      </font>
      <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
	</c:if>
	
	<form class="form" role="login" action="<c:url value='/j_spring_security_check' />" method="post">
		<div class="form-group">
			<input type="text" name="j_username" class="form-control" placeholder="Login"> <input type="password" name="j_password" class="form-control" placeholder="Mot de passe">
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	</jsp:body>
</t:template>
