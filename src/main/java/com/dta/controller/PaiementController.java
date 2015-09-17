package com.dta.controller;

import java.beans.PropertyEditorSupport;
import java.util.*;

import javax.annotation.*;
import javax.validation.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.dta.metier.*;
import com.dta.model.Categorie;
import com.dta.model.Paiement;
import com.dta.model.Utilisateur;

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
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau";
//		}
		
		ps.creerPaiement(p);
		
		model.addAttribute("paiements", ps.listerPaiements());
		
		return "paiement";
	}
	
	@RequestMapping(value = "/paiement/nouveau", method = RequestMethod.GET)
	public String newPaiementForm(Locale locale, Model model) {
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("users", us.listerUtilisateurs());
		return "paiement_nouveau_dest";
	}
	
	@RequestMapping(value = "/paiement/nouveau", method = RequestMethod.POST)
	public String newPaiementPost(@Valid Paiement p, BindingResult bindingResult, Locale locale, Model model) {

		p.setEmetteur(us.chercherUtilisateur(1));
		
		p.setDateDemande(new Date());
		
		p.setValide(false);
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau_dest";
//		}
		
		ps.creerPaiement(p);
		
		model.addAttribute("paiements", ps.listerPaiements());
		
		return "paiement";
	}
	
	//Liste des paiements à accepter.
	@RequestMapping(value = "/paiement/en_attente", method = RequestMethod.GET)
	public String paiementNonValide(Locale locale, Model model) {
		model.addAttribute("paiements", ps.listerPaiements());
		return "paiement";
	}
	
	
	//Acceptation du paiement.
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Utilisateur.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				int id = Integer.parseInt(text);
				Utilisateur u = us.chercherUtilisateur(id);
				setValue(u);
			}
		});
	}

}
