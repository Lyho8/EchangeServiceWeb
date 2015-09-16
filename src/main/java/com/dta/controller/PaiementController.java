package com.dta.controller;

import java.util.*;

import javax.annotation.*;
import javax.validation.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.dta.metier.*;
import com.dta.model.Paiement;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PaiementController {

	@Resource(name = "paiementMetier")
	private IPaiementMetier pm;
	
	@Resource(name = "utilisateurMetier")
	private IUtilisateurMetier um;

	/**
	 * Affiche les paiements
	 */
	@RequestMapping(value = "/paiement", method = RequestMethod.GET)
	public String homePaiement(Locale locale, Model model) {
		model.addAttribute("paiements", pm.listerPaiements());
		return "paiement";
	}

	@RequestMapping(value = "/paiement/nouveau/{id}", method = RequestMethod.GET)
	public String newPaiementForm(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("dest", um.chercherUtilisateur(id));
		model.addAttribute("paiement", new Paiement());
		return "paiement_nouveau";
	}
	
	@RequestMapping(value = "/paiement/nouveau/{id}", method = RequestMethod.POST)
	public String newPaiementPost(@Valid Paiement p, BindingResult bindingResult, @PathVariable int id, Locale locale, Model model) {
		
		p.setRecepteur(um.chercherUtilisateur(id));
		
		p.setEmetteur(um.chercherUtilisateur(1));
		
		p.setDateDemande(new Date());
		
		p.setValide(false);
		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau";
//		}
		
		pm.actualiserPaiement(p);
		
		return "paiement";
	}

}
