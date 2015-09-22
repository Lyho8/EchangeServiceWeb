<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:template>
	<jsp:body>
	
<h1>
	Ma messagerie
</h1>

<ul class="nav nav-tabs">
  <li role="presentation"><a href="/projetf/messages/1">Messages reçus</a></li>
  <li role="presentation"><a href="/projetf/messages/envoyes/1">Messages envoyés</a></li>
  <li role="presentation"><a href="/projetf/messages/new/1">Nouveau message</a></li>
</ul>
	
	<div class="row">
  <div class="col-sm-2">
    <div class="thumbnail">
      <img src="http://www.mot-a-mot.com/media/annonce/annonce_2.jpg"
						alt="annonce de test">
      <div class="caption">
        <h3>Message de ${ messagePrive.auteur.login }</h3>
        <p>${ messagePrive.contenu }</p>
      </div>
	 
	
    </div>
  </div>
  </div>	
	
    </jsp:body>
</t:template>
