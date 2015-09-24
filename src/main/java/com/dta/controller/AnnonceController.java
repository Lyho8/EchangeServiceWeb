package com.dta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IAnnonceService;
import com.dta.metier.ICategorieService;
import com.dta.metier.ICommentaireService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.Annonce;
import com.dta.model.Categorie;
import com.dta.model.Commentaire;
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

	@Autowired
	private ICommentaireService coms;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		List<Annonce> annonces = as.listerAnnonces(0, 50);
		model.addAttribute("annonces", annonces);
		return "annonces_home";
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/nouvelle", method = RequestMethod.GET)
	public String nouvelle(Model model) {
		List<Type> types = new ArrayList<Type>();
		types.add(Type.DEMANDE);
		types.add(Type.OFFRE);

		Annonce annonce = new Annonce();
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Utilisateur u = us.chercherUtilisateurLogin(username);
		annonce.setAuteur(u);

		model.addAttribute("annonce", annonce);
		model.addAttribute("types", types);
		model.addAttribute("categories", cs.listerCategories());

		return "annonces_nouvelle";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/categorie", method = RequestMethod.GET)
	public String nouvelleCategorie(Model model) {
		
		model.addAttribute("categorie", new Categorie());
		
		model.addAttribute("categories", cs.listerCategories());

		return "annonce_creer_categorie";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/categorie", method = RequestMethod.POST)
	public String ajouterNouvelleCategorie(@Valid @ModelAttribute("categorie") Categorie categorie,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("categories", cs.listerCategories());
			model.addAttribute("categorie", categorie);
			return "annonce_creer_categorie";
		}
		
		model.addAttribute("categorie", new Categorie());
		cs.creerCategorie(categorie);
		model.addAttribute("categories", cs.listerCategories());
		return "annonce_creer_categorie";
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/nouvelle", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute("annonce") Annonce annonce,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("categories", cs.listerCategories());
			return "annonces_nouvelle";
		}

		annonce.setActive(true);
		as.creerAnnonce(annonce);
		return "redirect:/annonces/voir/" + annonce.getId();
	}

	@RequestMapping(value = "/voir/{id}", method = RequestMethod.GET)
	public String voir(@PathVariable int id, Model model) {
		
		Annonce annonce = as.chercherAnnonce(id);

		if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			Commentaire com = new Commentaire();
			
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Utilisateur u = us.chercherUtilisateurLogin(username);
			
			com.setAuteur(u);
			com.setAnnonce(annonce);
			
			model.addAttribute("commentaire", com);
		}
		
		model.addAttribute("annonce", annonce);  
		return "annonces_annonce";
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/voir/{id}", method = RequestMethod.POST)
	public String newMessagePost(@Valid Commentaire com,BindingResult BindingResult, Model model,@PathVariable int id) {

		for (ObjectError oe : BindingResult.getAllErrors()) {
			System.out.println(oe);
		}
		
		Annonce annonce = as.chercherAnnonce(id);
		
		coms.creerCommentaire(com);
	
		List<Commentaire> listCom = annonce.getCommentaires();
		
		listCom.add(com);
				
		as.actualiserAnnonce(annonce);
		
		return "redirect:/annonces/voir/" + id;
	}
}
