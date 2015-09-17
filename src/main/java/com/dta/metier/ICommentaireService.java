package com.dta.metier;

import java.util.List;

import com.dta.model.Annonce;
import com.dta.model.Commentaire;

public interface ICommentaireService {

	public void creerCommentaire(Commentaire com);
	public void supprimerCommentaire(int idCommentaire);
	public List<Commentaire> listerCommentaire(Annonce a);
	public List<Commentaire> chercherCommentaireParAuteur(String motCle);
}
