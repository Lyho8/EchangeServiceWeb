package com.dta.metier;

import java.util.List;

import com.dta.model.Utilisateur;


public interface IUtilisateurService {
		public void creerUtilisateur(Utilisateur u); 

		public List<Utilisateur> listerUtilisateurs(boolean actif);

		public void supprimerUtilisateur(int idUtilisateur); 
		
		public Utilisateur chercherUtilisateur(int idUtilisateur); 

		public void actualiserUtilisateur(Utilisateur c);

		public List<Utilisateur> chercherUtilisateurs(String motCle);
}
