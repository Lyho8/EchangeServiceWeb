package com.dta.metier;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dta.dao.IMessageDao;
import com.dta.model.MessagePrive;
import com.dta.model.Utilisateur;

public class MessagesMetierImpl implements IMessagesMetier {


	IMessageDao dao;

	public void setDao(IMessageDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void creerMessage(MessagePrive mp) {
		dao.creerMessage(mp);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void supprimerMessage(int idMessageP) {
		dao.supprimerMessage(idMessageP);
	}
	
	public List<MessagePrive> listerMessageEnvoie(Utilisateur u) {
		return dao.listerMessageEnvoie(u);
	}

	public List<MessagePrive> listerMessageRecu(Utilisateur u) {
		return dao.listerMessageRecu(u);
	}

	public List<MessagePrive> chercherMessageParTitre(String motCle) {
		return dao.chercherMessageParTitre(motCle);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<MessagePrive> supprimerMessageEnvoieParTitre(String motCle, Utilisateur u) {
		for (MessagePrive mp : dao.chercherMessageParTitre(motCle)) {
			dao.supprimerMessage(mp.getId());
		}
		return dao.listerMessageEnvoie(u);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<MessagePrive> supprimerMessageRecuParTitre(String motCle,
			Utilisateur u) {
		for (MessagePrive mp : dao.chercherMessageParTitre(motCle)) {
			dao.supprimerMessage(mp.getId());
		}
		return dao.listerMessageRecu(u);
	}
	
	

}
