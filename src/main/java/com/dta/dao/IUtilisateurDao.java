package com.dta.dao;

import java.util.List;

import com.dta.model.Utilisateur;


public interface IUtilisateurDao {

	public void creerUtilisateur(Utilisateur u) /*throws Exception*/; 

	public List<Utilisateur> listerUtilisateurs();

	public void supprimerUtilisateur(int idUtilisateur); 
	
	public Utilisateur editerUtilisateur(int idUtilisateur); 

	public void actualiserUtilisateur(Utilisateur u);

	public List<Utilisateur> chercherUtilisateurs(String motCle);


	
}
