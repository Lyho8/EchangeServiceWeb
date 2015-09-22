package com.dta.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.ICommentaireDao;
import com.dta.model.Annonce;
import com.dta.model.Commentaire;

@Service
public class CommentaireServiceImpl implements ICommentaireService {

	@Autowired
	private ICommentaireDao dao;

	public void setDao(ICommentaireDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void creerCommentaire(Commentaire com) {
		dao.creerCommentaire(com);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void supprimerCommentaire(int idCommentaire) {
		dao.supprimerCommentaire(idCommentaire);
	}

	
	public List<Commentaire> listerCommentaire(Annonce a) {
		return dao.listerCommentaire(a);
	}
	
	public List<Commentaire> chercherCommentaireParAuteur(String motCle) {
		return dao.chercherCommentaireParAuteur(motCle);
	}

}
