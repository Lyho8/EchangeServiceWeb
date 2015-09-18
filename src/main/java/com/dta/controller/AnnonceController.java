package com.dta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import com.dta.model.Commentaire;
import com.dta.model.Type;

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
		return "annonces_home";
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/nouvelle", method = RequestMethod.GET)
	public String nouvelle(Model model) {
		List<Type> types = new ArrayList<Type>();
		types.add(Type.DEMANDE);
		types.add(Type.OFFRE);

		Annonce annonce = new Annonce();
		annonce.setAuteur(us.chercherUtilisateur(1)); // fake user (�a devrait
														// �tre l'utilisateur
														// connect�)

		model.addAttribute("annonce", annonce);
		model.addAttribute("types", types);
		model.addAttribute("categories", cs.listerCategories());

		return "annonces_nouvelle";
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/nouvelle", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute("annonce") Annonce annonce,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			// for(ObjectError e : result.getAllErrors()) {
			// System.err.println(e);
			// }

			model.addAttribute("categories", cs.listerCategories());
			return "annonces_nouvelle";
		}

		annonce.setActive(true);
		as.creerAnnonce(annonce);
		return "redirect:/annonces/voir/" + annonce.getId();
	}

	@RequestMapping(value = "/voir/{id}", method = RequestMethod.GET)
	public String voir(@PathVariable int id, Model model) {
		model.addAttribute("annonce", as.chercherAnnonce(id));
		return "annonces_annonce";
	}

	@RequestMapping(value = "/voir/{id}/commenter", method = RequestMethod.POST)
	public String newMessagePost(@Valid Commentaire com,
			BindingResult BindingResult, Model model, @PathVariable int id,
			Locale locale) {

		for (ObjectError oe : BindingResult.getAllErrors()) {
			System.out.println(oe);
		}

		coms.creerCommentaire(com);

		return "messages_new";
	}
}
