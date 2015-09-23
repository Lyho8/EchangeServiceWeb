<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs">
  <li role="presentation" <c:if test="${param.activetab == 'recus'}">class="active"</c:if> ><a href="<c:url value='/messages' />">Messages re�us</a></li>
  <li role="presentation" <c:if test="${param.activetab == 'envoyes'}">class="active"</c:if> ><a href="<c:url value='/messages/envoyes' />">Messages envoy�s</a></li>
  <li role="presentation" <c:if test="${param.activetab == 'new'}">class="active"</c:if> ><a href="<c:url value='/messages/new' />">Nouveau message</a></li>
</ul>