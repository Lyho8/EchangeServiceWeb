package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

		Query req;
		
		if(actif==true){
		req = em.createQuery("select u from Utilisateur u where u.actif=true",
				Utilisateur.class);
		}else{
		req = em.createQuery("select u from Utilisateur u where u.actif=false",
				Utilisateur.class);
		}
		return req.getResultList();

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
		Query req = em
				.createQuery("select u from Utilisateur u where u.nom like :x or u.prenom like :x");

		req.setParameter("x", "%" + motCle + "%");

		return req.getResultList();
	}

	@Override
	public Utilisateur chercherUtilisateurLogin(String login) {
		Query req;
		req=em.createQuery("select u from Utilisateur u where u.login = :log");
		req.setParameter("log", login);
		return req.getSingleResult();
	}

}
