package com.dta.spring;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.metier.IMessagesMetier;
import com.dta.model.Utilisateur;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/messages")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private IMessagesMetier IMM;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String home(Model model, Principal principal) {

		model.addAttribute("MesClients",IMM.listerMessageRecu(principal.));	
		
		return "messages";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newMessage( Model model) {
		
		return "messages_new";
	}
	
	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	public String supprMessage(@RequestParam (value="id") int idMessageP, Utilisateur u,Model model) {
		
		IMM.supprimerMessage(idMessageP);
		
		IMM.listerMessageRecu(u);
		
		return "messages_new";
	}
	
}
