package com.dta.metier;

import java.util.List;

import com.dta.model.Annonce;
import com.dta.model.Categorie;
import com.dta.model.Utilisateur;

public interface IAnnonceService {

	public abstract void creerAnnonce(Annonce annonce);

	public abstract List<Annonce> listerAnnonces(int premier, int nombre);

	public abstract List<Annonce> rechercherAnnonces(Utilisateur utilisateur);

	public abstract List<Annonce> rechercherAnnonces(Categorie categorie);

	public abstract void supprimerAnnonce(int idAnnonce);

	public abstract Annonce chercherAnnonce(int idAnnonce);

	public abstract void fermerAnnonce(Annonce annonce);

	public abstract void ouvrirAnnonce(Annonce annonce);

	public abstract void actualiserAnnonce(Annonce annonce);

}
