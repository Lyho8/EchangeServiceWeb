package com.dta.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dta.metier.ICommentaireService;
import com.dta.metier.IPaiementService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.Utilisateur;

@Controller
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@RequestMapping(value = "rest")
public class RestController {

	@Autowired
	private IUtilisateurService us;

	@Autowired
	private IPaiementService ps;
	
	@Autowired
	private ICommentaireService cs;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur home() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Utilisateur u = us.chercherUtilisateurLogin(username);
		return u;
	}
	
	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Integer> notifications() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Utilisateur u = us.chercherUtilisateurLogin(username);
		
		int nbPaiements = ps.chercherPaiementsInvalidesE(u).size();
		int nbMPnonlus = 0;
		int nbComsnonlus = cs.chercherCommentairesNonLus(u).size();
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("paiements", nbPaiements);
		m.put("messages", nbMPnonlus);
		m.put("commentaires", nbComsnonlus);
		return m;
	}
	
	@RequestMapping(value = "/solde", method = RequestMethod.GET)
	@ResponseBody
	public int solde() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Utilisateur u = us.chercherUtilisateurLogin(username);
		
		return u.getSolde();
	}
}
