package com.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.model.Categorie;

@Repository
public class CategorieDaoImpl implements ICategorieDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void creerCategorie(Categorie categorie) {
		entityManager.persist(categorie);
	}
	
	@Override
	public List<Categorie> listerCategories() {
		return entityManager.createQuery("SELECT c FROM Categorie c ORDER BY c.libelle ASC", Categorie.class).getResultList();
	}
	
	@Override
	public Categorie rechercherCategorie(int id) {
		return entityManager.createQuery("SELECT c FROM Categorie c WHERE c.id  = :id", Categorie.class).setParameter("id", id).getSingleResult();
	}
}
