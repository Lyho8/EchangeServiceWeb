package com.dta.metier;

import com.dta.model.*;

public interface IMailService {

	public void sendMail(Utilisateur destinataire, String sujet, String contenu);
	
}
