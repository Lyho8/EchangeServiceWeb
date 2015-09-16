package com.dta.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.IUtilisateurDao;
import com.dta.model.Utilisateur;



public class UtilisateurMetierImpl implements IUtilisateurMetier {

	@Resource(name = "dao")
	private IUtilisateurDao iud;

	public UtilisateurMetierImpl() {
		super();
	}

	public UtilisateurMetierImpl(IUtilisateurDao iud) {
		super();
		this.iud = iud;
	}

	public IUtilisateurDao getIud() {
		return iud;
	}

	public void setIud(IUtilisateurDao iud) {
		this.iud = iud;
	}

	
	@Transactional(rollbackFor=Exception.class)
	public void creerUtilisateur(Utilisateur c){
	
		iud.creerUtilisateur(c);
	}


	@Transactional(readOnly=true)
	public List<Utilisateur> listerUtilisateurs() {
		return iud.listerUtilisateurs();
	}

	@Transactional
	public void supprimerUtilisateur(int idUtilisateur) {

		iud.supprimerUtilisateur(idUtilisateur);
		
	}

	@Transactional(readOnly=true)
	public Utilisateur editerUtilisateur(int idUtilisateur) {
		return iud.editerUtilisateur(idUtilisateur);
	}

	@Transactional
	public void actualiserUtilisateur(Utilisateur c) {
		iud.actualiserUtilisateur(c);
		
	}

	@Transactional(readOnly=true)
	public List<Utilisateur> chercherUtilisateurs(String motCle) {
		
		return iud.chercherUtilisateurs(motCle);
	}
	
	
	

}
