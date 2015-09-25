package com.dta.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.IPaiementDao;
import com.dta.dao.IUtilisateurDao;
import com.dta.model.Paiement;
import com.dta.model.Role;
import com.dta.model.Utilisateur;

@Service
public class PaiementServiceImpl implements IPaiementService {

	@Autowired
	private IPaiementDao dao;

	@Autowired
	private IUtilisateurDao utilisateurDao;
	
	@Autowired
	private IMailService ms;

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
	public List<Paiement> chercherPaiementsValides() {
		return dao.chercherPaiementsValides();
	}

	@Transactional(readOnly = true)
	public List<Paiement> chercherPaiementsValidesE(Utilisateur u) {
		return dao.chercherPaiementsValidesE(u);
	}

	@Transactional(readOnly = true)
	public List<Paiement> chercherPaiementsValidesR(Utilisateur u) {
		return dao.chercherPaiementsValidesR(u);
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
	public void creerDemandePaiement(Paiement p, int idE, int idR) {
		//Récupère les utilisateurs
		Utilisateur emetteur = utilisateurDao.chercherUtilisateur(idE);
		Utilisateur recepteur = utilisateurDao.chercherUtilisateur(idR);
		
		//Liaison utilisateurs/paiement
		p.setEmetteur(emetteur);
		p.setRecepteur(recepteur);
		emetteur.getPaiementsEmis().add(p);
		recepteur.getPaiementsRecus().add(p);
		
		//Prépare le paiement
		p.setDateDemande(new Date());
		p.setValide(false);

		//Persiste le paiement
		dao.creerPaiement(p);
	}

	@Transactional
	public void creerPaiementDirect(Paiement p, int idE, int idR) {

		// Récupère les 2 utilisateurs
		Utilisateur emetteur = utilisateurDao.chercherUtilisateur(idE);
		Utilisateur recepteur = utilisateurDao.chercherUtilisateur(idR);

		// Renvoie une exception si emetteur non solvable
		if (emetteur.getRole() != Role.ROLE_ADMIN && emetteur.getSolde() + 10 < p.getMontant()){
			throw new RuntimeException("*** Erreur métier - credit insuffisant");
		}

		// Prépare et persiste le paiement
		p.setEmetteur(emetteur);
		emetteur.getPaiementsEmis().add(p);
		p.setRecepteur(recepteur);
		recepteur.getPaiementsRecus().add(p);
		p.setDateDemande(new Date());
		p.setDateValidation(new Date());
		p.setValide(true);
		dao.creerPaiement(p);

		// Màj balance destinataire
		recepteur.setSolde(recepteur.getSolde() + p.getMontant());

		// Si non admin, màj balance emetteur
		if (emetteur.getRole() != Role.ROLE_ADMIN) {
			emetteur.setSolde(emetteur.getSolde() - p.getMontant());
		}
	}

	@Transactional
	public void validerPaiement(Paiement p) {
		Utilisateur e = p.getEmetteur();
		Utilisateur r = p.getRecepteur();

		if (e.getRole() != Role.ROLE_ADMIN) {
			if (e.getSolde() + 10 < p.getMontant()) {
				refuserPaiement(p);
			} else {
				e.setSolde(e.getSolde() - p.getMontant());
				r.setSolde(r.getSolde() + p.getMontant());
				utilisateurDao.actualiserUtilisateur(e);
				utilisateurDao.actualiserUtilisateur(r);

				p.setValide(true);
				p.setDateValidation(new Date());
				dao.actualiserPaiement(p);
				
				String sujet = "Paiement accepté par " + p.getEmetteur().getLogin();
				String contenu = "L'utilisateur " + p.getEmetteur().getLogin() + " a accepté votre demande de paiement d'un montant de " + p.getMontant() + ".\nCommentaire : " + p.getMessage();
				ms.sendMail(p.getRecepteur(), sujet, contenu);
			}

		} else {
			r.setSolde(r.getSolde() + p.getMontant());
			utilisateurDao.actualiserUtilisateur(r);

			p.setValide(true);
			p.setDateValidation(new Date());
			dao.actualiserPaiement(p);
			
			String sujet = "Paiement accepté par " + p.getEmetteur().getLogin();
			String contenu = "L'utilisateur " + p.getEmetteur().getLogin() + " a accepté votre demande de paiement d'un montant de " + p.getMontant() + ".\nCommentaire : " + p.getMessage();
			ms.sendMail(p.getRecepteur(), sujet, contenu);
		}
	}

	@Transactional
	public void refuserPaiement(Paiement p) {
		p.setDateValidation(new Date());
		dao.actualiserPaiement(p);
		
		String sujet = "Paiement refusé par " + p.getEmetteur().getLogin();
		String contenu = "L'utilisateur " + p.getEmetteur().getLogin() + " a refusé votre demande de paiement d'un montant de " + p.getMontant() + ".\nCommentaire : " + p.getMessage();
		ms.sendMail(p.getRecepteur(), sujet, contenu);

	}

}
