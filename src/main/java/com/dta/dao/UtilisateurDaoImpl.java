package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.model.Utilisateur;

@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao {

	@PersistenceContext
	private EntityManager em = null;

	// méthodes
	@Override
	public void creerUtilisateur(Utilisateur u) {
		em.persist(u);
	}

	@Override
	public List<Utilisateur> listerUtilisateurs(boolean actif) {
		return em.createQuery("select u from Utilisateur u where u.actif=:actif", Utilisateur.class).setParameter("actif", actif).getResultList();
	}

	@Override
	public void supprimerUtilisateur(int idUtilisateur) {
		Utilisateur u1 = em.find(Utilisateur.class, idUtilisateur);
		em.remove(u1);

	}

	@Override
	public Utilisateur chercherUtilisateur(int idUtilisateur) {
		Utilisateur u1 = em.find(Utilisateur.class, idUtilisateur);
		return u1;

	}

	@Override
	public void actualiserUtilisateur(Utilisateur u) {
		em.merge(u);

	}

	@Override
	public List<Utilisateur> chercherUtilisateurs(String motCle) {
		return em.createQuery("select u from Utilisateur u where u.nom like :x or u.prenom like :x", Utilisateur.class).setParameter("x", "%" + motCle + "%").getResultList();
	}

	@Override
	public Utilisateur chercherUtilisateurLogin(String login) {
		return em.createQuery("select u from Utilisateur u where u.login = :log", Utilisateur.class).setParameter("log", login).getSingleResult();
	}

}
