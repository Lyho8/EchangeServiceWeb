package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.model.Annonce;
import com.dta.model.Categorie;
import com.dta.model.Type;
import com.dta.model.Utilisateur;

@Repository
public class AnnonceDaoImpl implements IAnnonceDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void creerAnnonce(Annonce annonce) {
		entityManager.persist(annonce);
	}

	@Override
	public List<Annonce> rechercherAnnonces(Categorie categorie) {
		return entityManager.createQuery("SELECT a FROM Annonce a WHERE a.categorie.libelle = :categorie", Annonce.class).setParameter("categorie", categorie.getId()).getResultList();
	}

	@Override
	public List<Annonce> rechercherAnnonces(Utilisateur utilisateur) {
		return entityManager.createQuery("SELECT a FROM Annonce a WHERE a.auteur.id = :utilisateur", Annonce.class).setParameter("utilisateur", utilisateur.getId()).getResultList();
	}

	@Override
	public void supprimerAnnonce(int idAnnonce) {
		Annonce a = chercherAnnonce(idAnnonce);
		entityManager.remove(a);
	}

	@Override
	public Annonce chercherAnnonce(int idAnnonce) {
		return entityManager.createQuery("SELECT a FROM Annonce a WHERE a.id = :id", Annonce.class).setParameter("id", idAnnonce).getSingleResult();
	}

	@Override
	public void fermerAnnonce(Annonce annonce) {
		annonce.setActive(false);
		actualiserAnnonce(annonce);
	}

	@Override
	public void ouvrirAnnonce(Annonce annonce) {
		annonce.setActive(true);
		actualiserAnnonce(annonce);
	}

	@Override
	public void actualiserAnnonce(Annonce annonce) {
		entityManager.merge(annonce);
	}

	@Override
	public List<Annonce> listerAnnonces(int premier, int nombre) {
		return entityManager.createQuery("SELECT a FROM Annonce a WHERE a.active = true ORDER BY a.dateCreation DESC", Annonce.class).setFirstResult(premier).setMaxResults(nombre).getResultList();
	}

	@Override
	public List<Annonce> listerDernieresAnnoncesParType(int nombre, Type type) {
		return entityManager.createQuery("SELECT a FROM Annonce a WHERE a.active = true AND a.type = :type ORDER BY a.dateCreation DESC", Annonce.class).setParameter("type", type).setFirstResult(0).setMaxResults(nombre).getResultList();
	}

}
