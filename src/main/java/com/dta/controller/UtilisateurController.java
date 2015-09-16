package com.dta.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IMailService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.Utilisateur;

@Controller
public class UtilisateurController {

	@Resource(name = "utilisateurMetier")
	private IUtilisateurService ms;

	@Resource(name = "mailMetier")
	private IMailService m;
	
	// TODO ajouter un utilisateur.
	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	public String ajout(@Valid Utilisateur u, BindingResult bindingResult,
			Model model) {

		if (u.getId() == 0){
			System.out.println(m.email());
			ms.creerUtilisateur(u);}
		else
			ms.actualiserUtilisateur(u);

		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("listeUtilisateurs", ms.listerUtilisateurs());
		
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

}