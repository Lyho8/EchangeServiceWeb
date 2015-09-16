package com.dta.controller;

import java.util.*;
import javax.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import com.dta.metier.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PaiementController {

	@Resource(name = "paiementMetier")
	private IPaiementMetier pm;
	
	@Resource(name = "utilisateurMetier")
	private IUtilisateurMetier um;

	/**
	 * Affiche les paiements
	 */
	@RequestMapping(value = "/paiement", method = RequestMethod.GET)
	public String homePaiement(Locale locale, Model model) {
		model.addAttribute("paiements", pm.listerPaiements());
		return "paiement";
	}

	@RequestMapping(value = "/paiement/nouveau/{id}", method = RequestMethod.POST)
	public String newPaiement(@PathVariable int id, Locale locale, Model model) {
		model.addAttribute("dest", um.editerUtilisateur(id));
		return "paiement_nouveau";
	}

}
