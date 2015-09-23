package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.model.Annonce;
import com.dta.model.Commentaire;

@Repository
public class CommentaireDaoImpl implements ICommentaireDao {

	@PersistenceContext
	private  EntityManager  entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void creerCommentaire(Commentaire com) {
		entityManager.persist(com);
	}

	public void supprimerCommentaire(int idCommentaire) {
		Commentaire com=entityManager.find(Commentaire.class,idCommentaire);
		entityManager.remove(com);
	}

	
	public List<Commentaire> listerCommentaire(Annonce a) {
		return  entityManager.createQuery("select com from Commentaire com where com.annonce=:annonce", Commentaire.class).setParameter("annonce", a).getResultList();
	}
	
	public List<Commentaire> chercherCommentaireParAuteur(String login) {
		return  entityManager.createQuery("select com from Commentaire com where com.auteur.login = :x", Commentaire.class).setParameter("x",  login).getResultList();
	}

}
