<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
	
	<div class="container">
	
		<h2> ${utilisateur.prenom} ${ utilisateur.nom } </h2>
		<a href="<c:url value='/utilisateurs/actualiser?id=${utilisateur.id}' />">modifier le profil</a>
		
			<div class="row">
				<div class="col-sm-3">		
					<div class="jumbotron">
						<img src="http://angeoudemongif.a.n.pic.centerblog.net/d3e42620.gif" height="100" width="150" />
					</div>
				</div>
				<div class="col-sm-6">
					<div class="jumbotron">
						<p>
							inscrit depuis le :<br> ${utilisateur.dateInscription}.
						</p>
						<p>
							login : ${ utilisateur.login }
						</p>
						<p>
							E-Mail : ${ utilisateur.email }
						</p>
						<p>
							<em>Solde restant</em>  ${utilisateur.solde} crédits.
						</p>
			 			<p>
							Nombre de messages reçus : ${ msg }.
						</p>
						<p>
							Montant des paiements émis : ${ montantEmis }.
						</p>
						<p>
							Montant des paiemens reçus  : ${ montantRecus }.
						</p> 
					</div>
					</div>
				</div>	
	
	</div>

	</jsp:body>

</t:template>