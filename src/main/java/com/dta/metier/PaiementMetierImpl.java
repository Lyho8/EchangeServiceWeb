package com.dta.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import com.dta.model.*;
import com.dta.dao.*;

public class PaiementMetierImpl implements IPaiementMetier {

	@Autowired
	private IPaiementDao dao;
	
	@Override
	public void creerPaiement(Paiement c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paiement> listerPaiements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerPaiement(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paiement chercherPaiement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualiserPaiement(Paiement c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paiement> chercherPaiements(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
