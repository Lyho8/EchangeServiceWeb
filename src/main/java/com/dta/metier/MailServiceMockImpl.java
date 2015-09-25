package com.dta.metier;

import org.springframework.stereotype.Service;

import com.dta.model.Utilisateur;

@Service
public class MailServiceMockImpl implements IMailService {

	public void sendMail(Utilisateur destinataire, String sujet, String contenu){
		System.out.println("Nouveau mail envoyé à l'adresse " + destinataire.getEmail()+".");
		System.out.println("Sujet : " + sujet + ".");
		System.out.println("Contenu : " + contenu + ".");
	}
	
}
