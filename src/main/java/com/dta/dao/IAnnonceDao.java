package com.dta.dao;

import java.util.List;

import com.dta.model.Annonce;
import com.dta.model.Categorie;
import com.dta.model.Type;
import com.dta.model.Utilisateur;

public interface IAnnonceDao {
	void creerAnnonce(Annonce annonce);

	List<Annonce> listerAnnonces(int premier, int nombre);
	
	List<Annonce> rechercherAnnonces(Utilisateur utilisateur);

	List<Annonce> rechercherAnnonces(Categorie categorie);

	void supprimerAnnonce(int idAnnonce);

	Annonce chercherAnnonce(int idAnnonce);

	void fermerAnnonce(Annonce annonce);

	void ouvrirAnnonce(Annonce annonce);

	void actualiserAnnonce(Annonce annonce);

	List<Annonce> listerDernieresAnnoncesParType(int nombre, Type type);

	List<Annonce> listerAnnoncesUtilisateur(int idUtilisateur);
}
