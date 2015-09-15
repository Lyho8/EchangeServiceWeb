package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Categorie {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String libelle;
	
	@OneToMany(mappedBy="categorie")
	private List<Annonce> annonces;
	
	public Categorie(){
		super();
	}

	public Categorie(int id, String libelle, List<Annonce> annonces) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.annonces = annonces;
	}

	public Categorie(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	
}
