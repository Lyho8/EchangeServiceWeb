package com.dta.dao;

import java.util.*;

import com.dta.model.*;

public interface IPaiementDao {

	public void creerPaiement(Paiement c);

	public List<Paiement> listerPaiements();

	public void supprimerPaiement(int id);

	public Paiement chercherPaiement(int id);

	public void actualiserPaiement(Paiement c);

	public List<Paiement> chercherPaiements(Utilisateur u);

}
