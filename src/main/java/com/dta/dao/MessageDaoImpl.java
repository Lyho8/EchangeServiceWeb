package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

@Repository
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
		MessagePrive mp=entityManager.find(MessagePrive.class,idMessageP);
		entityManager.remove(mp);
		
	}

	public List<MessagePrive> listerMessageEnvoie(Utilisateur u) {
		return  entityManager.createQuery("select mp from MessagePrive mp where mp.auteur.login=:login order by mp.dateCreation desc", MessagePrive.class).setParameter("login", u.getLogin()).getResultList();
	}

	public List<MessagePrive> listerMessageRecu(Utilisateur u) {
		return  entityManager.createQuery("select mp from MessagePrive mp join mp.destinataires d where d.login=:login order by mp.dateCreation desc", MessagePrive.class).setParameter("login", u.getLogin()).getResultList();
	}

	public List<MessagePrive> chercherMessageParTitre(String motCle) {
		return entityManager.createQuery("select mp from MessagePrive mp where mp.titre like :x", MessagePrive.class).setParameter("x",  "%"+motCle+"%").getResultList();
	}
	
	
	public MessagePrive chercherMessageParId(int idMessage) {
		return entityManager.createQuery("SELECT mp FROM MessagePrive mp WHERE mp.id  = :id", MessagePrive.class).setParameter("id", idMessage).getSingleResult();	
	}

}
