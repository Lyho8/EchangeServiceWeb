package com.dta.dao;

import java.util.List;

import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

public interface IMessageDao {

	public void creerMessage(MessagePrive mp);
	public void supprimerMessage(int idMessageP);
	public List<MessagePrive> listerMessageEnvoie(Utilisateur u);
	public List<MessagePrive> listerMessageRecu(Utilisateur u);	
	public List<MessagePrive> chercherMessageParTitre(String motCle);
	public MessagePrive chercherMessageParId(int id);
	public void actualiserMessage(MessagePrive mp);
}
