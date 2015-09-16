package com.dta.metier;

import java.util.List;

import com.dta.model.*;

public interface IPaiementService {

	public void creerPaiement(Paiement p);

	public List<Paiement> listerPaiements();

	public void supprimerPaiement(int id);

	public Paiement chercherPaiement(int id);

	public void actualiserPaiement(Paiement p);

	public List<Paiement> chercherPaiements(Utilisateur u);
	
}
