package com.dta.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.IUtilisateurDao;
import com.dta.model.Utilisateur;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private IUtilisateurDao dao;

	public UtilisateurServiceImpl() {
		super();
	}

	public UtilisateurServiceImpl(IUtilisateurDao dao) {
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
		return dao.chercherUtilisateur(idUtilisateur);
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
