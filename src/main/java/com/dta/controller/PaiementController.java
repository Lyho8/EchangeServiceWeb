package com.dta.controller;

import java.beans.PropertyEditorSupport;
import java.util.*;

import javax.annotation.*;
import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

	@Autowired
	private IPaiementService ps;
	
	@Autowired
	private IUtilisateurService us;

	/**
	 * Affiche les paiements
	 */
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value = "/paiement", method = RequestMethod.GET)
	public String homePaiement(Locale locale, Model model) {
		model.addAttribute("paiements", ps.listerPaiements());
		return "paiement";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/{id}", method = RequestMethod.GET)
	public String homePaiement(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("paiementsE", ps.chercherPaiementsE(us.chercherUtilisateur(id)));
		model.addAttribute("paiementsR", ps.chercherPaiementsR(us.chercherUtilisateur(id)));
		return "paiement_utilisateur";
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/demande/{id}", method = RequestMethod.GET)
	public String newPaiementForm(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("dest", us.chercherUtilisateur(id));
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("idR", id);
		return "paiement_nouveau";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/demande/{id}", method = RequestMethod.POST)
	public String newPaiementPost(@Valid Paiement p, BindingResult bindingResult, @PathVariable int id, Locale locale, Model model) {
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau";
//		}
		
		ps.creerPaiementFromForm(p, 1, id);
		
		return "redirect:/paiement/1";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/demande", method = RequestMethod.GET)
	public String newPaiementForm(Locale locale, Model model) {
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("users", us.listerUtilisateurs());
		return "paiement_nouveau_dest";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/demande", method = RequestMethod.POST)
	public String newPaiementPost(@Valid Paiement p, BindingResult bindingResult, Locale locale, Model model) {

		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau_dest";
//		}
		
		ps.creerPaiementFromForm(p, 1);
		
		return "redirect:/paiement/1";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/direct/{id}", method = RequestMethod.GET)
	public String newPaiementDirectForm(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("dest", us.chercherUtilisateur(id));
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("idR", id);
		return "paiement_direct";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/direct/{id}", method = RequestMethod.POST)
	public String newPaiementDirectPost(@Valid Paiement p, BindingResult bindingResult, @PathVariable int id, Locale locale, Model model) {
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau";
//		}
		
		ps.creerPaiementDirectFromForm(p, 1, id);
		
		return "redirect:/paiement/1";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/direct", method = RequestMethod.GET)
	public String newPaiementDirectForm(Locale locale, Model model) {
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("users", us.listerUtilisateurs());
		return "paiement_direct_dest";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/direct", method = RequestMethod.POST)
	public String newPaiementDirectPost(@Valid Paiement p, BindingResult bindingResult, Locale locale, Model model) {
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau_dest";
//		}
		
		ps.creerPaiementDirectFromForm(p, 1);
		
		return "redirect:/paiement/1";
	}
	
	//Liste des paiements à accepter.
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/en_attente", method = RequestMethod.GET)
	public String paiementNonValide(Locale locale, Model model) {
		model.addAttribute("paiements", ps.chercherPaiementsInvalides());
		return "paiement_utilisateur";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/paiement/en_attente/{id}", method = RequestMethod.GET)
	public String paiementNonValideById(@PathVariable int id, Locale locale, Model model) {
		Utilisateur e = us.chercherUtilisateur(id);
		model.addAttribute("paiementsE", ps.chercherPaiementsInvalidesE(e));
		model.addAttribute("paiementsR", ps.chercherPaiementsInvalidesR(e));
		return "paiement_utilisateur";
	}
	
	
	//Acceptation du paiement.
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/paiement/valider/{id}")
	public String validerPaiement(@PathVariable int id, Locale locale, Model model){
		
		Paiement p = ps.chercherPaiement(id);
		
		ps.validerPaiement(p);
		
		return "redirect:/paiement/en_attente/1";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/paiement/refuser/{id}")
	public String refuserPaiement(@PathVariable int id, Locale locale, Model model){
		
		Paiement p = ps.chercherPaiement(id);
		
		ps.refuserPaiement(p);
		
		return "redirect:/paiement/en_attente/1";
	}

}
