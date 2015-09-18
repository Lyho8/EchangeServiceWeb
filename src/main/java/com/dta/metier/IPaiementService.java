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
	
	public List<Paiement> chercherPaiementsInvalides();
	
	public List<Paiement> chercherPaiementsInvalidesE(Utilisateur u);
	
	public List<Paiement> chercherPaiementsInvalidesR(Utilisateur u);
	
	public void creerPaiementFromForm(Paiement p, int idE, int idR);
	
	public void creerPaiementFromForm(Paiement p, int idE);
	
	public void creerPaiementDirectFromForm(Paiement p, int idE, int idR);
	
	public void creerPaiementDirectFromForm(Paiement p, int idE);
	
	public void validerPaiement(Paiement p);
	
	public void refuserPaiement(Paiement p);
	
}
