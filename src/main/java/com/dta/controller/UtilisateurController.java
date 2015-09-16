package com.dta.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dta.metier.IUtilisateurMetier;
import com.dta.model.Utilisateur;

@Controller
public class UtilisateurController {

	@Resource(name = "utilisateurMetier")
	private IUtilisateurMetier ium;

	// TODO ajouter un utilisateur.
	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	public String home(@Valid Utilisateur u, BindingResult bindingResult,
			Model model) {

		if (u.getId() == 0)
			ium.creerUtilisateur(u);
		else
			ium.actualiserUtilisateur(u);

		model.addAttribute("utilisateur", new Utilisateur());

		return "utilisateur";
	}

	// TODO actualiser un utilisateur.
	@RequestMapping(value = "/editerUtilisateur/{id}")
	public String updateClient(@PathVariable(value = "id") int id, Model model) {

		Utilisateur u1 = ium.chercherUtilisateur(id);

		model.addAttribute("utilisateur", u1);

		return "utilisateur";
	}

}