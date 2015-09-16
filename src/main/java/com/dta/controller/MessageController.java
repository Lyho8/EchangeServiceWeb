package com.dta.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dta.metier.IMessagesService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/messages")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Resource (name="messageMetier")
	private IMessagesService ms;
	
	@Resource(name = "utilisateurMetier")
	private IUtilisateurService us;
	
	/* Page d'accueil de message avec l'affichage des messages reçus */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model, Utilisateur u) {

		model.addAttribute("MesMessagesR",ms.listerMessageRecu(u));	
		
		return "messages";
	}
	
	/* Page d'affichage des messages envoyés */
	@RequestMapping(value = "/envoyes", method = RequestMethod.GET)
	public String messageEnvoye(Model model, Utilisateur u) {

		model.addAttribute("MesMessagesE",ms.listerMessageEnvoie(u));	
		
		return "messages_envoyes";
	}
	
	@RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
	public String newMessageForm( Model model,  @PathVariable int id) {
		
		model.addAttribute("messagePrive",new MessagePrive());	
		return "messages_new";
	}
	
	@RequestMapping(value = "/new/{id}", method = RequestMethod.POST)
	public String newMessagePost(@Valid MessagePrive mp, Model model,  @PathVariable int id, Locale locale) {
		
		mp.setAuteur(us.chercherUtilisateur(id));
		mp.setDateCreation(new Date());
		
		return "messages_new";
	}
	
	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	public String supprMessage(@RequestParam (value="id") int idMessageP, Utilisateur u,Model model) {
		
		ms.supprimerMessage(idMessageP);
		
		ms.listerMessageRecu(u);
		
		return "messages_new";
	}
	
}
