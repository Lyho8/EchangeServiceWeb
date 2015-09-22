package com.dta.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.IAnnonceDao;
import com.dta.model.Annonce;
import com.dta.model.Categorie;
import com.dta.model.Utilisateur;

@Service
public class AnnonceServiceImpl implements IAnnonceService {
	
	@Autowired
	private IAnnonceDao dao;

	public IAnnonceDao getDao() {
		return dao;
	}

	public void setDao(IAnnonceDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void creerAnnonce(Annonce annonce) {
		dao.creerAnnonce(annonce);
	}

	@Transactional(readOnly = true)
	public List<Annonce> rechercherAnnonces(Utilisateur utilisateur) {
		return dao.rechercherAnnonces(utilisateur);
	}

	@Transactional(readOnly = true)
	public List<Annonce> rechercherAnnonces(Categorie categorie) {
		return dao.rechercherAnnonces(categorie);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void supprimerAnnonce(int idAnnonce) {
		dao.supprimerAnnonce(idAnnonce);
	}

	@Transactional(readOnly = true)
	public Annonce chercherAnnonce(int idAnnonce) {
		return dao.chercherAnnonce(idAnnonce);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void fermerAnnonce(Annonce annonce) {
		dao.fermerAnnonce(annonce);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void ouvrirAnnonce(Annonce annonce) {
		dao.ouvrirAnnonce(annonce);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void actualiserAnnonce(Annonce annonce) {
		dao.actualiserAnnonce(annonce);
	}

	@Override
	public List<Annonce> listerAnnonces(int premier, int nombre) {
		return dao.listerAnnonces(premier, nombre);
	}
}
