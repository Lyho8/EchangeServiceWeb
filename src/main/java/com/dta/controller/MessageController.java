package com.dta.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.metier.ICategorieService;
import com.dta.metier.IMailService;
import com.dta.metier.IMessagesService;
import com.dta.metier.IUtilisateurService;
import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

/**
 * Handles requests for the application home page.
 */
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@RequestMapping(value = "messages")
public class MessageController {
	@Autowired
	private IMessagesService ms;

	@Autowired
	private ICategorieService cs;

	@Autowired
	private IUtilisateurService us;
	
	@Autowired
	private IMailService mser;

	/* Page d'accueil de message avec l'affichage des messages re�us */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		Utilisateur userContext = us.chercherUtilisateurLogin(name);
		model.addAttribute("MesMessagesR", ms.listerMessageRecu(userContext));

		return "messages";
	}

	/* Page d'affichage des messages envoy�s */
	@RequestMapping(value = "/envoyes", method = RequestMethod.GET)
	public String messageEnvoye(Model model) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		model.addAttribute("MesMessagesE",
				ms.listerMessageEnvoie(us.chercherUtilisateurLogin(name)));

		return "messages_envoyes";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newMessageForm(Model model) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		MessagePrive mp = new MessagePrive();
		mp.setAuteur(us.chercherUtilisateurLogin(name));

		model.addAttribute("users", us.listerUtilisateurs(true));
		model.addAttribute("messagePrive", mp);

		return "messages_new";
	}

	/* Page de formulaire pour envoy� un nouveau message */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newMessagePost(@Valid MessagePrive mp,
			BindingResult BindingResult, Model model, Locale locale) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		for (ObjectError oe : BindingResult.getAllErrors()) {
			System.out.println(oe);
		}

		ms.creerMessage(mp);
		
		for (Utilisateur u: mp.getDestinataires()) {
			mser.sendMail(u, "Vous avez re�u un message", "Va voir ta bo�te de messagerie sur notre putain de site !!!");
		}
		
		return "redirect:/messages";
	}

	@RequestMapping(value = "/envoyes/voir/{idMessage}", method = RequestMethod.GET)
	public String voirMessageEnvoye(@PathVariable("idMessage") int idMessage,
			Model model) {

		MessagePrive mp = ms.chercherMessageParId(idMessage);

		model.addAttribute("messagePrive", mp);

		return "messages_voir";
	}

	@RequestMapping(value = "/voir/{idMessage}", method = RequestMethod.GET)
	public String voirMessage(@PathVariable(value = "idMessage") int idMessage,
			Model model) {

		MessagePrive mp = ms.chercherMessageParId(idMessage);
		
		mp.setLu(true);
		
		ms.actualiserMessage(mp);
		
		mp = ms.chercherMessageParId(idMessage);
		
		System.out.println("\n\n\n -------" + mp.isLu() + "-------\n\n\n");
		model.addAttribute("messagePrive", mp);

		return "messages_voir";
	}
	
	@RequestMapping(value = "/repondre/{id}", method = RequestMethod.GET)
	public String newMessageForm(@PathVariable int id, Model model) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		MessagePrive origine = ms.chercherMessageParId(id);

		MessagePrive mp = new MessagePrive();
		mp.setAuteur(us.chercherUtilisateurLogin(name));
		mp.getDestinataires().add(origine.getAuteur());
		String s = "\n\n\n--------------\nMessage d'origine envoy� par "+origine.getAuteur().getLogin()+" le "+origine.getDateCreation()+" :\n"+origine.getContenu();
		mp.setContenu(s);
		s = "Re: " + origine.getTitre();
		mp.setTitre(s);

		model.addAttribute("users", us.listerUtilisateurs(true));
		model.addAttribute("messagePrive", mp);

		return "messages_new";
	}
	
	@RequestMapping(value = "/repondre/{id}", method = RequestMethod.POST)
	public String newMessagePost(@PathVariable int id, @Valid MessagePrive mp,
			BindingResult BindingResult, Model model, Locale locale) {

		for (ObjectError oe : BindingResult.getAllErrors()) {
			System.out.println(oe);
		}

		ms.creerMessage(mp);

		return "redirect:/messages";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				System.out.println(text);
				List<Utilisateur> lu = new ArrayList<Utilisateur>();
				String[] tabDes = text.split(",");
				for (String log : tabDes) {
					try {
						lu.add(us.chercherUtilisateur(Integer.parseInt(log.trim())));
					} catch (Exception e) {

					}

				}

				setValue(lu);
			}
		});
	}

}
