package com.dta.spring;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IUtilisateurMetier;
import com.dta.model.Utilisateur;

@Controller
public class UtilisateurController {
	
	@Resource(name="metier")
	private IUtilisateurMetier ium;

	//TODO ajouter un utilisateur.
	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	public String home(@Valid Utilisateur u, BindingResult bindingResult, Model model) {
		
		ium.creerUtilisateur(u);		
		model.addAttribute("utilisateur", new Utilisateur());
		
		return "utilisateur";	
	}
	

	
	
}