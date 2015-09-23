<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs">
  <li role="presentation"><a href="<c:url value='/messages' />">Messages reçus</a></li>
  <li role="presentation"><a href="<c:url value='/messages/envoyes' />">Messages envoyés</a></li>
  <li role="presentation" class="active"><a href="<c:url value='/messages/new' />">Nouveau message</a></li>
</ul>