package com.dta.metier;

import java.util.List;

import com.dta.model.*;

public interface IPaiementService {
	
	public void creerPaiement(Paiement p);

	public List<Paiement> listerPaiements();

	public void supprimerPaiement(int id);

	public Paiement chercherPaiement(int id);

	public void actualiserPaiement(Paiement p);

	public List<Paiement> chercherPaiementsE(Utilisateur u);
	
	public List<Paiement> chercherPaiementsR(Utilisateur u);
	
	public List<Paiement> chercherPaiementsValides();
	
	public List<Paiement> chercherPaiementsValidesE(Utilisateur u);
	
	public List<Paiement> chercherPaiementsValidesR(Utilisateur u);
	
	public List<Paiement> chercherPaiementsInvalides();
	
	public List<Paiement> chercherPaiementsInvalidesE(Utilisateur u);
	
	public List<Paiement> chercherPaiementsInvalidesR(Utilisateur u);
	
	public void creerDemandePaiement(Paiement p, int idE, int idR);
	
	public void creerPaiementDirect(Paiement p, int emetteurId, int recepteurId);
	
	public void validerPaiement(Paiement p);
	
	public void refuserPaiement(Paiement p);
	
}
