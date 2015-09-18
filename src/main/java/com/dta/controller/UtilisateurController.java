package com.dta.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dta.metier.IUtilisateurService;
import com.dta.model.Utilisateur;

@Controller
public class UtilisateurController {

	@Autowired
	private IUtilisateurService ms;

	// @Resource(name = "mail")
	// private IMailService m;
	//

	
	// TODO afficher le formulaire
	@RequestMapping(value = "/utilisateurs_liste", method = RequestMethod.GET)
	public String listerUtilisateur(Model model) {

		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());

		return "utilisateurs_liste";
	}
	
	
	// TODO afficher le formulaire
	@RequestMapping(value = "/utilisateurBienvenue", method = RequestMethod.GET)
	public String bienvenue(Model model) {

		
		model.addAttribute("utilisateur", new Utilisateur());
//		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());

		return "utilisateur";
	}
	

	// TODO ajouter un utilisateur.
	@RequestMapping(value = "/utilisateurBdd", method = RequestMethod.POST)
	public String ajout(@Valid Utilisateur u, BindingResult bindingResult,
			Model model) {

		if (u.getId() == 0) {
			// System.out.println(m.email());

			Date time = new Date();
			u.setDateInscription(time);
			u.setSolde(0);
			u.setActif(true);
			
			ms.creerUtilisateur(u);
			
		} else
			
			ms.actualiserUtilisateur(u);

	//	model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());
	
		return "utilisateurs_liste";
	}

	
	// TODO actualiser un utilisateur.
	@RequestMapping(value = "/utilisateurModifier", method = RequestMethod.GET)
	public String editer(@RequestParam(value = "id") int id, Model model) {

		Utilisateur u = ms.chercherUtilisateur(id);
		
		model.addAttribute("utilisateur", u);

		return "utilisateur";
	}
	
	
	//TODO supprimer un utilisateur
	@RequestMapping(value="/utilisateurSupprimer")
	public String supprimerUtilisateur(@RequestParam(value="id") int id, Model model){
		
		
		Utilisateur u=ms.chercherUtilisateur(id);
		u.setActif(false);
		ms.actualiserUtilisateur(u);
		
		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());
		
		return "utilisateurs_liste";
	}
	
	//TODO Login gestion de la connexion des utilisateurs.
	@RequestMapping(value="/utilisateurLogin", method = RequestMethod.POST)
	public String login(){
		return null;
	}

}