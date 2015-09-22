package com.dta.controller;

import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.IAnnonceService;
import com.dta.model.Annonce;
import com.dta.model.Type;

@Controller
public class HomeController {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private IAnnonceService as;	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Annonce> demandes = as.listerDernieresAnnoncesParType(6, Type.DEMANDE);
		List<Annonce> offres = as.listerDernieresAnnoncesParType(6, Type.OFFRE);
		
		model.addAttribute("demandes", demandes);
		model.addAttribute("offres", offres);
		
		return "home";
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String connexion() {
		return "connexion";
	}
	
}
