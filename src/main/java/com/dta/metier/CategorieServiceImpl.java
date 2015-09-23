package com.dta.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.ICategorieDao;
import com.dta.model.Categorie;

@Service
public class CategorieServiceImpl implements ICategorieService {
	
	@Autowired
	private ICategorieDao dao;

	public ICategorieDao getDao() {
		return dao;
	}

	public void setDao(ICategorieDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void creerCategorie(Categorie categorie) {
		dao.creerCategorie(categorie);
	}

	@Transactional(readOnly = true)
	public List<Categorie> listerCategories() {
		return dao.listerCategories();
	}

	@Transactional(readOnly = true)
	public Categorie rechercherCategorie(int id) {
		return dao.rechercherCategorie(id);
	}

}
