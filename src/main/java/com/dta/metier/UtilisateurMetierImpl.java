package com.dta.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.IUtilisateurDao;
import com.dta.model.Utilisateur;



public class UtilisateurMetierImpl implements IUtilisateurMetier {

	@Resource(name = "utilisateurDao")
	private IUtilisateurDao dao;

	public UtilisateurMetierImpl() {
		super();
	}

	public UtilisateurMetierImpl(IUtilisateurDao dao) {
		super();
		this.dao = dao;
	}

	public IUtilisateurDao getDao() {
		return dao;
	}

	public void setDao(IUtilisateurDao dao) {
		this.dao = dao;
	}

	
	@Transactional(rollbackFor=Exception.class)
	public void creerUtilisateur(Utilisateur c){
	
		dao.creerUtilisateur(c);
	}


	@Transactional(readOnly=true)
	public List<Utilisateur> listerUtilisateurs() {
		return dao.listerUtilisateurs();
	}

	@Transactional
	public void supprimerUtilisateur(int idUtilisateur) {

		dao.supprimerUtilisateur(idUtilisateur);
		
	}

	@Transactional(readOnly=true)
	public Utilisateur chercherUtilisateur(int idUtilisateur) {
		return dao.editerUtilisateur(idUtilisateur);
	}

	@Transactional
	public void actualiserUtilisateur(Utilisateur c) {
		dao.actualiserUtilisateur(c);
		
	}

	@Transactional(readOnly=true)
	public List<Utilisateur> chercherUtilisateurs(String motCle) {
		
		return dao.chercherUtilisateurs(motCle);
	}
	
	
	

}
