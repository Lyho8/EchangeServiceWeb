package com.dta.metier;

import java.util.List;

import com.dta.model.*;

public interface IPaiementMetier {

	public void creerPaiement(Paiement c);

	public List<Paiement> listerPaiements();

	public void supprimerPaiement(int id);

	public Paiement chercherPaiement(int id);

	public void actualiserPaiement(Paiement c);

	public List<Paiement> chercherPaiements(Utilisateur u);
	
}
