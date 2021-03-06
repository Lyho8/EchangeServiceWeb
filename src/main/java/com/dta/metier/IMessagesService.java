package com.dta.metier;

import java.util.List;

import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

public interface IMessagesService {

	public void creerMessage(MessagePrive mp);
	public void supprimerMessage(int idMessageP);
	public List<MessagePrive> listerMessageEnvoie(Utilisateur u);
	public List<MessagePrive> listerMessageRecu(Utilisateur u);	
	public List<MessagePrive> chercherMessageParTitre(String motCle);
	public MessagePrive chercherMessageParId(int idMessage);
	public List<MessagePrive> supprimerMessageEnvoieParTitre(String motCle,Utilisateur u);
	public List<MessagePrive> supprimerMessageRecuParTitre(String motCle,Utilisateur u);
	public void actualiserMessage(MessagePrive mp);
	
}
