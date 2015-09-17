package com.dta.dao;

import java.util.List;

import com.dta.model.Categorie;

public interface ICategorieDao {

	public abstract void creerCategorie(Categorie categorie);

	public abstract List<Categorie> listerCategories();

	public abstract Categorie rechercherCategorie(int id);

}