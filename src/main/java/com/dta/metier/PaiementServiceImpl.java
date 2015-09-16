package com.dta.metier;

import java.util.*;
import javax.annotation.*;
import org.springframework.transaction.annotation.*;
import com.dta.model.*;
import com.dta.dao.*;

public class PaiementServiceImpl implements IPaiementService {

	@Resource(name="paiementDao")
	private IPaiementDao dao;

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
	public List<Paiement> chercherPaiements(Utilisateur u) {
		List<Paiement> mylist = new ArrayList<Paiement>();
		mylist = dao.chercherPaiements(u);
		return mylist;
	}

}
