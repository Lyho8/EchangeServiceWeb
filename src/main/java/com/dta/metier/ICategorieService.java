package com.dta.metier;

import java.util.List;

import com.dta.model.Categorie;

public interface ICategorieService {
	void creerCategorie(Categorie categorie);
	
	List<Categorie> listerCategories();
	
	Categorie rechercherCategorie(int id);
}
