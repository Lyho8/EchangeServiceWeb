package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Categorie {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String libelle;
	
	public Categorie(){
		super();
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
	
}
