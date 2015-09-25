<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs">
  <li role="presentation" <c:if test="${param.activetab == 'en_attente'}">class="active"</c:if> ><a href="<c:url value='/paiements/en_attente' />">Mes transactions en attente</a></li>
  <li role="presentation" <c:if test="${param.activetab == 'historique'}">class="active"</c:if> ><a href="<c:url value='/paiements'  />">Historique de mes transactions</a></li>
</ul>