package com.dta.controller;

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
@RequestMapping(value="utilisateur")
public class UtilisateurController {

	
	
	@Autowired
	private IUtilisateurService ms;

	// TODO afficher le formulaire
	@RequestMapping(value = "/utilisateur/liste", method = RequestMethod.GET)
	public String listerUtilisateur(Model model) {

		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());

		return "utilisateurs_liste";
	}

	// TODO afficher le formulaire
	@RequestMapping(value = "/utilisateur/formulaire/empty", method = RequestMethod.GET)
	public String bienvenue(Model model) {

		model.addAttribute("utilisateur", new Utilisateur());

		return "utilisateur_formulaire";
	}

	// TODO ajouter un utilisateur.
	@RequestMapping(value = "/utilisateur/formulaire", method = RequestMethod.POST)
	public String ajout(@Valid Utilisateur u, BindingResult bindingResult,
			Model model) {

		if (u.getId() == 0) {

			ms.creerUtilisateur(u);

		} else

			ms.actualiserUtilisateur(u);
	
		return "redirect:/connexion";
	}

	// TODO actualiser un utilisateur.
	@RequestMapping(value = "/utilisateur/actualiser", method = RequestMethod.GET)
	public String editer(@RequestParam(value = "id") int id, Model model) {

		Utilisateur u = ms.chercherUtilisateur(id);

		model.addAttribute("utilisateur", u);

		return "utilisateur_formulaire";
	}

	// TODO supprimer un utilisateur
	@RequestMapping(value = "/utilisateur/supprimer")
	public String supprimerUtilisateur(@RequestParam(value = "id") int id,
			Model model) {

		Utilisateur u = ms.chercherUtilisateur(id);
		u.setActif(false);
		ms.actualiserUtilisateur(u);

		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());

		return "utilisateurs_liste";
	}

}