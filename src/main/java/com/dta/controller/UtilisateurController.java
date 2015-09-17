package com.dta.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IUtilisateurService;
import com.dta.model.Utilisateur;

@Controller
public class UtilisateurController {

	@Resource(name = "utilisateurMetier")
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
			u.setSolde(10);
			ms.creerUtilisateur(u);
		} else
			ms.actualiserUtilisateur(u);

		model.addAttribute("utilisateur", new Utilisateur());
	//	model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());

		return "utilisateur";
	}

	// TODO actualiser un utilisateur.
	@RequestMapping(value = "/editerUtilisateur/{id}", method = RequestMethod.GET)
	public String editer(@PathVariable(value = "id") int id, Model model) {

		Utilisateur u1 = ms.chercherUtilisateur(id);

		model.addAttribute("utilisateur", u1);
		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());

		return "utilisateur";
	}
	
	//TODO Login gestion de la connexion des utilisateurs.
	@RequestMapping(value="/utilisateurLogin", method = RequestMethod.POST)
	public String login(){
		return null;
	}

}