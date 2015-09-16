package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

public class MessageDaoImpl implements IMessageDao {

	@PersistenceContext
	private  EntityManager  entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public void creerMessage(MessagePrive mp) {
		entityManager.persist(mp);
		
	}

	public void supprimerMessage(int idMessageP) {
		// TODO Auto-generated method stub
		
	}

	public List<MessagePrive> listerMessageEnvoie(Utilisateur u) {
		Query req=entityManager.createQuery("select mp from MessagePrive mp where mp.auteur= :login", MessagePrive.class).setParameter("login", u.getLogin());
		return  req.getResultList();
	}

	public List<MessagePrive> listerMessageRecu(Utilisateur u) {
		Query req=entityManager.createQuery("select mp from MessagePrive mp where mp.destinataires= :login", MessagePrive.class).setParameter("login", u.getLogin());
		return  req.getResultList();
	}

	public List<MessagePrive> chercherMessageParTitre(String motCle) {
		Query req=entityManager.createQuery("select mp from MessagePrive mp where mp.titre like :x");
		req.setParameter("x",  "%"+motCle+"%");
		return  req.getResultList();
	}

}
