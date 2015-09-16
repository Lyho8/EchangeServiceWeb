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
	private IPaiementService ps;
	
	@Resource(name = "utilisateurMetier")
	private IUtilisateurService us;

	/**
	 * Affiche les paiements
	 */
	@RequestMapping(value = "/paiement", method = RequestMethod.GET)
	public String homePaiement(Locale locale, Model model) {
		model.addAttribute("paiements", ps.listerPaiements());
		return "paiement";
	}

	@RequestMapping(value = "/paiement/nouveau/{id}", method = RequestMethod.GET)
	public String newPaiementForm(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("dest", us.chercherUtilisateur(id));
		model.addAttribute("paiement", new Paiement());
		return "paiement_nouveau";
	}
	
	@RequestMapping(value = "/paiement/nouveau/{id}", method = RequestMethod.POST)
	public String newPaiementPost(@Valid Paiement p, BindingResult bindingResult, @PathVariable int id, Locale locale, Model model) {
		
		p.setRecepteur(us.chercherUtilisateur(id));
		
		p.setEmetteur(us.chercherUtilisateur(1));
		
		p.setDateDemande(new Date());
		
		p.setValide(false);
		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau";
//		}
		
		ps.actualiserPaiement(p);
		
		model.addAttribute("paiements", ps.listerPaiements());
		
		return "paiement";
	}

}
