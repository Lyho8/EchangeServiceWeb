package com.dta.dao;

import java.util.*;

import com.dta.model.*;

public interface IPaiementDao {

	public void creerPaiement(Paiement c);

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

}
