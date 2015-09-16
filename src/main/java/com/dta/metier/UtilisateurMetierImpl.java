package com.dta.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.IUserDao;
import com.dta.model.Utilisateur;



public class UserMetierImpl implements IUserMetier {

	@Resource(name = "dao")
	private IUserDao iud;

	public UserMetierImpl() {
		super();
	}

	public UserMetierImpl(IUserDao iud) {
		super();
		this.iud = iud;
	}

	public IUserDao getIud() {
		return iud;
	}

	public void setIud(IUserDao iud) {
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
