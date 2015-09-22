package com.dta.dao;

import java.util.List;

import com.dta.model.Utilisateur;


public interface IUtilisateurDao {

	public void creerUtilisateur(Utilisateur u) /*throws Exception*/; 

	public List<Utilisateur> listerUtilisateurs(boolean actif);

	public void supprimerUtilisateur(int idUtilisateur); 
	
	public Utilisateur chercherUtilisateur(int idUtilisateur); 

	public void actualiserUtilisateur(Utilisateur u);

	public List<Utilisateur> chercherUtilisateurs(String motCle);


	
}
