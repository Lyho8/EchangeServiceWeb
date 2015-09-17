package com.dta.dao;

import java.util.List;

import com.dta.model.Annonce;
import com.dta.model.Commentaire;

public interface ICommentaireDao {

	public void creerCommentaire(Commentaire com);
	public void supprimerCommentaire(int idCommentaire);
	public List<Commentaire> listerCommentaire(Annonce a);
	public List<Commentaire> chercherCommentaireParAuteur(String motCle);
}
