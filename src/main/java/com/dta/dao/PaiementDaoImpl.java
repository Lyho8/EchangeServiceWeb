package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dta.model.*;

public class PaiementDaoImpl implements IPaiementDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void creerPaiement(Paiement p) {

		entityManager.persist(p);
	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Paiement> listerPaiements() {

		Query req = entityManager.createQuery("select p from Paiement p");
		return req.getResultList();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void supprimerPaiement(int idPaiement) {
		Paiement p = entityManager.find(Paiement.class, idPaiement);
		entityManager.remove(p);
	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public Paiement chercherPaiement(int idPaiement) {
		Paiement p = entityManager.find(Paiement.class, idPaiement);
		return p;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void actualiserPaiement(Paiement p) {
		entityManager.merge(p);

	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Paiement> chercherPaiements(Utilisateur u) {
		Query req = entityManager
				.createQuery("select p from Paiement p  where p.e=:id");
		req.setParameter("id", u.getId());
		return req.getResultList();
	}

}
