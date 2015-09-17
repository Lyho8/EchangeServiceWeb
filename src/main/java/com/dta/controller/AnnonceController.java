package com.dta.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IAnnonceService;
import com.dta.metier.ICategorieService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.Annonce;
import com.dta.model.Categorie;
import com.dta.model.Type;
import com.dta.model.Utilisateur;

@Controller
@RequestMapping(value = "annonces")
public class AnnonceController {
	@Autowired
	private IAnnonceService as;

	@Autowired
	private ICategorieService cs;
	
	@Autowired
	private IUtilisateurService us;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		return "annonces_home";
	}

	@RequestMapping(value = "/nouvelle", method = RequestMethod.GET)
	public String nouvelle(Model model) {
		List<Type> types = new ArrayList<Type>();
		types.add(Type.DEMANDE);
		types.add(Type.OFFRE);

		Annonce annonce = new Annonce();
		annonce.setAuteur(us.chercherUtilisateur(1)); // fake user (ça devrait être l'utilisateur connecté)
		model.addAttribute("annonce", annonce);
		model.addAttribute("types", types);
		model.addAttribute("categories", cs.listerCategories());

		return "annonces_nouvelle";
	}

	@RequestMapping(value = "/nouvelle", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute("annonce") Annonce annonce, BindingResult result, Model model) {

		System.err.println("has errors? " + result.hasErrors());
		for(ObjectError err : result.getAllErrors()) {
			System.err.println(err);
		}
		
		if (result.hasErrors()) {
			model.addAttribute("categories", cs.listerCategories());
			return "annonces_nouvelle";
		}
		
		annonce.setActive(true);
		as.creerAnnonce(annonce);
		return "redirect:/annonces/voir/" + annonce.getId();
	}

	@RequestMapping(value = "/voir/{id}", method = RequestMethod.GET)
	public String voir() {
		return "annonces_annonce";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Categorie.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				int id = Integer.parseInt(text);
				Categorie cat = cs.rechercherCategorie(id);
				setValue(cat);
			}
		});
		
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
