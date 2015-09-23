package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dta.model.Paiement;
import com.dta.model.Utilisateur;

@Repository
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
		return entityManager.createQuery("select p from Paiement p", Paiement.class).getResultList();
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
	public List<Paiement> chercherPaiementsE(Utilisateur u) {
		return entityManager.createQuery("select p from Paiement p  where p.emetteur.id=:id", Paiement.class).setParameter("id", u.getId()).getResultList();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Paiement> chercherPaiementsR(Utilisateur u) {
		return entityManager.createQuery("select p from Paiement p  where p.recepteur.id=:id", Paiement.class).setParameter("id", u.getId()).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Paiement> chercherPaiementsInvalides() {
		return entityManager.createQuery("select p from Paiement p  where p.valide=0 and p.dateValidation is null", Paiement.class).getResultList();
	}

	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Paiement> chercherPaiementsInvalidesE(Utilisateur u) {
		return entityManager.createQuery("select p from Paiement p  where p.emetteur.id=:id and p.valide=0 and p.dateValidation is null", Paiement.class).setParameter("id", u.getId()).getResultList();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
	public List<Paiement> chercherPaiementsInvalidesR(Utilisateur u) {
		return entityManager.createQuery("select p from Paiement p  where p.recepteur.id=:id and p.valide=0 and p.dateValidation is null", Paiement.class).setParameter("id", u.getId()).getResultList();
	}

}
