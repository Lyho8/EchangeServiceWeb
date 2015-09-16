package com.dta.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IAnnonceMetier;
import com.dta.model.Annonce;

@Controller
@RequestMapping(value = "annonces")
public class AnnonceController {
	@Resource(name="annonceMetier")
	private IAnnonceMetier annonceMetier;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		return "annonces_home";
	}
	
	@RequestMapping(value = "/nouvelle", method = RequestMethod.GET)
	public String nouvelle(Model model) {
		HashMap<String, String> types = new HashMap<String, String>();
		types.put("Offre", "Offre");
		types.put("Demande", "Demande");
		
		HashMap<Integer, String> categories = new HashMap<Integer, String>();
		categories.put(1, "Plombier");
		categories.put(2, "Electricien");
		categories.put(3, "Mécanicien");
		categories.put(4, "Jardinage");
		
		model.addAttribute("annonce", new Annonce());
		model.addAttribute("types", types);
		model.addAttribute("categories", categories);
		
		return "annonces_nouvelle";
	}
	
	@RequestMapping(value = "/nouvelle", method = RequestMethod.POST)
	public String creer(@Valid Annonce annonce, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			HashMap<String, String> types = new HashMap<String, String>();
			types.put("Offre", "Offre");
			types.put("Demande", "Demande");
			
			HashMap<Integer, String> categories = new HashMap<Integer, String>();
			categories.put(1, "Plombier");
			categories.put(2, "Electricien");
			categories.put(3, "Mécanicien");
			categories.put(4, "Jardinage");
			
			model.addAttribute("annonce", annonce);
			model.addAttribute("types", types);
			model.addAttribute("categories", categories);
			
			return "annonces_nouvelle";
		}
		
		annonceMetier.creerAnnonce(annonce);
		return "redirect:/annonces/voir/" + annonce.getId();
	}
	
	@RequestMapping(value = "/voir/{id}", method = RequestMethod.GET)
	public String voir() {
		return "annonces_annonce";
	}
	
}
