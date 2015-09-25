<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs">
  <li role="presentation" <c:if test="${param.activetab == 'actifs'}">class="active"</c:if> ><a href="<c:url value='/utilisateurs/lister/actifs' />">Utilisateurs Actifs</a></li>
  <li role="presentation" <c:if test="${param.activetab == 'inactifs'}">class="active"</c:if> ><a href="<c:url value='/utilisateurs/lister/inactifs' />">Utilisateurs Inactifs</a></li>
</ul>