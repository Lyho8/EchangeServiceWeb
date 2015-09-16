package com.dta.metier;

import java.util.List;

import com.dta.model.Utilisateur;


public interface IUtilisateurMetier {

		public void creerUtilisateur(Utilisateur u); 

		public List<Utilisateur> listerUtilisateurs();

		public void supprimerUtilisateur(int idUtilisateur); 
		
		public Utilisateur editerUtilisateur(int idUtilisateur); 

		public void actualiserUtilisateur(Utilisateur c);

		public List<Utilisateur> chercherUtilisateurs(String motCle);
		
}
