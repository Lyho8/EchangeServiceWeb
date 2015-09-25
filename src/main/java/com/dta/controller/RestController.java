package com.dta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dta.metier.IUtilisateurService;
import com.dta.model.Utilisateur;

@Controller
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@RequestMapping(value = "rest")
public class RestController {

	@Autowired
	private IUtilisateurService us;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur home() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Utilisateur u = us.chercherUtilisateurLogin(username);
		return u;
	}
}
