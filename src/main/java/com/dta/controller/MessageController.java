package com.dta.controller;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dta.metier.ICategorieService;
import com.dta.metier.IMessagesService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.Categorie;
import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/messages")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private IMessagesService ms;
	
	@Autowired
	private ICategorieService cs;
	
	@Autowired
	private IUtilisateurService us;
	
	/* Page d'accueil de message avec l'affichage des messages reçus */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String home(@PathVariable (value="id") int idUtilisateur,Model model) {

		model.addAttribute("MesMessagesR",ms.listerMessageRecu(us.chercherUtilisateur(idUtilisateur)));	
		
		return "messages";
	}
	
	/* Page d'affichage des messages envoyés */
	@RequestMapping(value = "/envoyes/{id}", method = RequestMethod.GET)
	public String messageEnvoye(@PathVariable (value="id") int idUtilisateur,Model model) {

		model.addAttribute("MesMessagesE",ms.listerMessageEnvoie(us.chercherUtilisateur(idUtilisateur)));	
		
		return "messages_envoyes";
	}
	
	@RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
	public String newMessageForm( Model model,  @PathVariable int id) {
		
		MessagePrive mp = new MessagePrive();
		mp.setAuteur(us.chercherUtilisateur(id));
		
		model.addAttribute("messagePrive",mp);	
		
		return "messages_new";
	}
	
	@RequestMapping(value = "/new/envoie/{id}", method = RequestMethod.POST)
	public String newMessagePost(@Valid MessagePrive mp,BindingResult BindingResult, Model model,  @PathVariable int id, Locale locale) {
		
		for (ObjectError oe : BindingResult.getAllErrors()) {
			System.out.println(oe);
		}
		
		ms.creerMessage(mp);
		
		return "messages_new";
	}
	
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.GET)
	public String supprMessage(@RequestParam (value="id") int idMessageP, @PathVariable (value="id") int idUtilisateur,Model model) {
		
		ms.supprimerMessage(idMessageP);
		
		ms.listerMessageRecu(us.chercherUtilisateur(idUtilisateur));
		
		return "messages_envoyes";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				List<Utilisateur> lu= new ArrayList<Utilisateur>();
				lu.add(us.chercherUtilisateur(1));
				lu.add(us.chercherUtilisateur(2));
				
				setValue(lu);
			}
		});
	}

}
