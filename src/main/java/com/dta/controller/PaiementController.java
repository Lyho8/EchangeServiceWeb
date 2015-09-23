package com.dta.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IPaiementService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.Paiement;
import com.dta.model.Utilisateur;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "paiements")
public class PaiementController {

	@Autowired
	private IPaiementService ps;
	
	@Autowired
	private IUtilisateurService us;

	/**
	 * Affiche les paiements
	 */
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String homePaiementAdmin(Locale locale, Model model) {
		model.addAttribute("paiements", ps.listerPaiements());
		return "paiement";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePaiement(Locale locale, Model model) {
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idC = us.chercherUtilisateurLogin(login).getId();
		
		model.addAttribute("paiementsE", ps.chercherPaiementsE(us.chercherUtilisateur(idC)));
		model.addAttribute("paiementsR", ps.chercherPaiementsR(us.chercherUtilisateur(idC)));
		model.addAttribute("en_attente", false);
		return "paiement_utilisateur";
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/demande/{id}", method = RequestMethod.GET)
	public String newPaiementForm(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("dest", us.chercherUtilisateur(id));
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("idR", id);
		return "paiement_nouveau";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/demande/{id}", method = RequestMethod.POST)
	public String newPaiementPost(@Valid Paiement p, BindingResult bindingResult, @PathVariable int id, Locale locale, Model model) {
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau";
//		}
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idR = us.chercherUtilisateurLogin(login).getId();
		
		ps.creerDemandePaiement(p, id, idR);
		
		return "redirect:/paiement/"+idR;
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/demande", method = RequestMethod.GET)
	public String newPaiementForm(Locale locale, Model model) {
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("users", us.listerUtilisateurs(true));
		return "paiement_nouveau_dest";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/demande", method = RequestMethod.POST)
	public String newPaiementPost(@Valid Paiement p, BindingResult bindingResult, Locale locale, Model model) {

		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau_dest";
//		}
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idR = us.chercherUtilisateurLogin(login).getId();
		
		ps.creerDemandePaiement(p, p.getEmetteur().getId(), idR);
		
		return "redirect:/paiement/"+idR;
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/direct/{id}", method = RequestMethod.GET)
	public String newPaiementDirectForm(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("dest", us.chercherUtilisateur(id));
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("idR", id);
		return "paiement_direct";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/direct/{idR}", method = RequestMethod.POST)
	public String newPaiementDirectPost(@Valid Paiement p, BindingResult bindingResult, @PathVariable int idR, Locale locale, Model model) {
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau";
//		}
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idE = us.chercherUtilisateurLogin(login).getId();
		
		ps.creerPaiementDirect(p, idE, idR);
		
		return "redirect:/paiement/"+idE;
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/direct", method = RequestMethod.GET)
	public String newPaiementDirectForm(Locale locale, Model model) {
		model.addAttribute("paiement", new Paiement());
		model.addAttribute("users", us.listerUtilisateurs(true));
		return "paiement_direct_dest";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/direct", method = RequestMethod.POST)
	public String newPaiementDirectPost(@Valid Paiement p, BindingResult bindingResult, Locale locale, Model model) {
		
//		for(ObjectError e : bindingResult.getAllErrors()){
//			System.err.println(e);
//		}
//		
//		if (bindingResult.hasErrors()) {
//			return "paiement_nouveau_dest";
//		}
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idE = us.chercherUtilisateurLogin(login).getId();
		
		ps.creerPaiementDirect(p, idE, p.getRecepteur().getId());
		
		return "redirect:/paiement/"+idE;
	}
	
	//Liste des paiements � accepter.
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value = "/en_attente/admin", method = RequestMethod.GET)
	public String paiementNonValideAdmin(Locale locale, Model model) {
		model.addAttribute("paiements", ps.chercherPaiementsInvalides());
		return "paiement_utilisateur";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/en_attente", method = RequestMethod.GET)
	public String paiementNonValide(Locale locale, Model model) {
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idC = us.chercherUtilisateurLogin(login).getId();
		
		Utilisateur e = us.chercherUtilisateur(idC);
		model.addAttribute("paiementsE", ps.chercherPaiementsInvalidesE(e));
		model.addAttribute("paiementsR", ps.chercherPaiementsInvalidesR(e));
		model.addAttribute("en_attente", true);
		return "paiement_utilisateur";
	}
	
	
	//Acceptation du paiement.
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/valider/{id}")
	public String validerPaiement(@PathVariable int id, Locale locale, Model model){
		
		Paiement p = ps.chercherPaiement(id);
		
		ps.validerPaiement(p);
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idE = us.chercherUtilisateurLogin(login).getId();
		
		return "redirect:/paiement/en_attente/"+idE;
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/refuser/{id}")
	public String refuserPaiement(@PathVariable int id, Locale locale, Model model){
		
		Paiement p = ps.chercherPaiement(id);
		
		ps.refuserPaiement(p);
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		int idE = us.chercherUtilisateurLogin(login).getId();
		
		return "redirect:/paiement/en_attente/"+idE;
	}

}
