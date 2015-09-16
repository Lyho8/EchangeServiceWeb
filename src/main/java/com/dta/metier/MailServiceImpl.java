package com.dta.metier;

public class MailServiceImpl implements IMailService{

	
	@Override
	public String email() {
		
		return ("Envoi de l'e-mail de confirmation dans 3  2   1    0. Envoi.<br>Utilisateur enregistré. fin de la mission");
	}

}
