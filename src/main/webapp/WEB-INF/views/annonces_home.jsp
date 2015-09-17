<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:body>
<h1>
	Liste des annonces
</h1>

<div class="row">
  <div class="col-sm-2">
    <div class="thumbnail">
      <img src="http://www.mot-a-mot.com/media/annonce/annonce_2.jpg" alt="annonce de test">
      <div class="caption">
        <h3>Annonce n1</h3>
        <p>Description de l'annonce, ceci concerne la dercription de l'annonce,
         ceci concerne la dercription de l'annonce,
          ceci concerne la dercription de l'annonce, 
          ceci concerne la dercription de l'annonce
        </p>
        <p><a href="projetf/annonces/voir/1" class="btn btn-primary" role="button">Voir l'annonce</a> </p>
      </div>
    </div>
  </div>
  <div class="col-sm-2">
    <div class="thumbnail">
      <img src="http://www.mot-a-mot.com/media/annonce/annonce_2.jpg" alt="annonce de test">
      <div class="caption">
        <h3>Annonce n2</h3>
        <p>Description de l'annonce, ceci concerne la dercription de l'annonce,
         ceci concerne la dercription de l'annonce,
          ceci concerne la dercription de l'annonce, 
          ceci concerne la dercription de l'annonce
        </p>
        <p><a href="projetf/annonces/voir/2" class="btn btn-primary" role="button">Voir l'annonce</a> </p>
      </div>
    </div>
  </div>
</div>

    </jsp:body>
</t:template>
