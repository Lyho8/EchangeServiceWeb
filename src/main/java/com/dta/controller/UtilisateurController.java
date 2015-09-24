package com.dta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dta.metier.IUtilisateurService;
import com.dta.model.Message;
import com.dta.model.Paiement;
import com.dta.model.Utilisateur;


@Controller
@RequestMapping(value="utilisateurs")
public class UtilisateurController {

	@Autowired
	private IUtilisateurService ms;

	//@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/lister", method = RequestMethod.GET)
	public String listerUtilisateur(Model model) {

		model.addAttribute("listeUtilisateursActifs", ms.listerUtilisateurs(true));
		
		model.addAttribute("listeUtilisateursInactifs", ms.listerUtilisateurs(false));

		return "utilisateurs_liste";
	}

	
	@RequestMapping(value="/statut", method = RequestMethod.GET)
	public String changerStatut(@RequestParam(value = "id") int id){
		
		Utilisateur u = ms.chercherUtilisateur(id);

		u.setActif(!u.isActif());
		
		ms.actualiserUtilisateur(u);
		
		return "redirect:/utilisateurs/lister";
	}
	
	//@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/actualiser", method = RequestMethod.GET)
	public String editer(@RequestParam(value = "id") int id, Model model) {

		Utilisateur u = ms.chercherUtilisateur(id);

		model.addAttribute("utilisateur", u);

		return "utilisateurs_formulaire";
	}
	
	@RequestMapping(value = "/enregistrer", method = RequestMethod.GET)
	public String bienvenue(Model model) {

		model.addAttribute("utilisateur", new Utilisateur());

		return "utilisateurs_formulaire";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String ajout(@Valid Utilisateur u, BindingResult bindingResult,
			Model model) {

		if (u.getId() == 0) {

			ms.creerUtilisateur(u);

		} else

			ms.actualiserUtilisateur(u);
	
		return "redirect:/connexion";
	}
	
	@RequestMapping(value="/voir", method=RequestMethod.GET)
	public String voirProfil(@RequestParam(value="id")int id, Model model){
		
		
		Utilisateur u = ms.chercherUtilisateur(id);
		
		List<Message> messagesRecus= new ArrayList<Message>();
		List<Paiement> paiementsEmis= new ArrayList<Paiement>();
		List<Paiement> paiementsRecus = new ArrayList<Paiement>();
		
		int nbMessagesRecus = messagesRecus.size();
		
		paiementsEmis = u.getPaiementsEmis();
		paiementsRecus = u.getPaiementsRecus();
		
		int totalPaiementsEmis = 0;
		for(Paiement p : paiementsEmis){
			
			totalPaiementsEmis += p.getMontant();
			
		}
		
		int totalPaiementsRecus = 0;
		for(Paiement p : paiementsRecus){
			
			totalPaiementsRecus += p.getMontant();
			
		}
		
		
		model.addAttribute("utilisateur", u);
		
		model.addAttribute("msg", nbMessagesRecus);
		
		model.addAttribute("montantsEmis", totalPaiementsEmis);
		
		model.addAttribute("montantsRecus", totalPaiementsRecus);
		
		return "utilisateurs_profil";
	}

}