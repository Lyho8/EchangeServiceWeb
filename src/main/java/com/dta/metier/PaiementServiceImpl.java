package com.dta.metier;

import java.util.*;

import javax.annotation.*;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import com.dta.model.*;
import com.dta.dao.*;

@Service
public class PaiementServiceImpl implements IPaiementService {

	@Autowired
	private IPaiementDao dao;
	
	@Autowired
	private IUtilisateurDao utilisateurDao;

	public void setDao(IPaiementDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void creerPaiement(Paiement p) {
		dao.creerPaiement(p);
	}

	@Transactional(readOnly = true)
	public List<Paiement> listerPaiements() {
		return dao.listerPaiements();
	}

	@Transactional
	public void supprimerPaiement(int idPaiement) {
		dao.supprimerPaiement(idPaiement);
	}

	@Transactional(readOnly = true)
	public Paiement chercherPaiement(int idPaiement) {
		return dao.chercherPaiement(idPaiement);
	}

	@Transactional
	public void actualiserPaiement(Paiement p) {
		dao.actualiserPaiement(p);

	}

	@Transactional(readOnly = true)
	public List<Paiement> chercherPaiementsE(Utilisateur u) {
		return dao.chercherPaiementsE(u);
	}
	
	@Transactional(readOnly = true)
	public List<Paiement> chercherPaiementsR(Utilisateur u) {
		return dao.chercherPaiementsR(u);
	}
	
	@Transactional(readOnly = true)
	public List<Paiement> chercherPaiementsInvalides() {
		return dao.chercherPaiementsInvalides();
	}

	@Transactional(readOnly = true)
	public List<Paiement> chercherPaiementsInvalidesE(Utilisateur u) {
		return dao.chercherPaiementsInvalidesE(u);
	}
	
	@Transactional(readOnly = true)
	public List<Paiement> chercherPaiementsInvalidesR(Utilisateur u) {
		return dao.chercherPaiementsInvalidesR(u);
	}
	
	@Transactional
	public void creerPaiementFromForm(Paiement p, int idE, int idR){
		p.setEmetteur(utilisateurDao.chercherUtilisateur(idE));
		p.setRecepteur(utilisateurDao.chercherUtilisateur(idR));
		p.setDateDemande(new Date());
		p.setValide(false);
		
		dao.creerPaiement(p);
	}
	
	@Transactional
	public void creerPaiementFromForm(Paiement p, int idE){
		p.setEmetteur(utilisateurDao.chercherUtilisateur(idE));
		p.setDateDemande(new Date());
		p.setValide(false);
		
		dao.creerPaiement(p);
	}
	
	@Transactional
	public void creerPaiementDirectFromForm(Paiement p, int idE, int idR){
		Utilisateur emetteur = utilisateurDao.chercherUtilisateur(idE);
		Utilisateur recepteur = utilisateurDao.chercherUtilisateur(idR);
		p.setRecepteur(recepteur);
		creerPaiementDirect(p, emetteur, recepteur);
		
	}
	
	@Transactional
	public void creerPaiementDirectFromForm(Paiement p, int idE){
		Utilisateur emetteur = utilisateurDao.chercherUtilisateur(idE);
		Utilisateur recepteur = p.getRecepteur();
		creerPaiementDirect(p, emetteur, recepteur);
	}
	
	
	private void creerPaiementDirect(Paiement p, Utilisateur emetteur, Utilisateur recepteur){
		if(emetteur.getSolde()+10>=p.getMontant()){
			p.setEmetteur(emetteur);
			p.setDateDemande(new Date());
			p.setDateValidation(new Date());
			p.setValide(true);
			
			dao.creerPaiement(p);
			
			emetteur.setSolde(emetteur.getSolde()-p.getMontant());
			recepteur.setSolde(recepteur.getSolde()+p.getMontant());
			utilisateurDao.actualiserUtilisateur(emetteur);
			utilisateurDao.actualiserUtilisateur(recepteur);
		}
	}

}
