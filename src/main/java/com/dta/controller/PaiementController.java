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
	
	@Resource(name="paiementMetier")
	private IPaiementMetier pm;
	
	/**
	 * Affiche les paiements
	 */
	@RequestMapping(value = "/paiement", method = RequestMethod.GET)
	public String homePaiement(Locale locale, Model model) {
		model.addAttribute("paiements", pm.listerPaiements());		
		return "paiement";
	}
	
}
