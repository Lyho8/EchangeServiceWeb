package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Annonce {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String description;
	
	@NotNull
	private boolean active;
	
	@NotNull
	private Type categorie;
	
	@NotNull
	private Date dateCreation;
	
	public Annonce(){
		super();
	}

	public Annonce(int id, String description, boolean active, Type categorie,
			Date dateCreation) {
		super();
		this.id = id;
		this.description = description;
		this.active = active;
		this.categorie = categorie;
		this.dateCreation = dateCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Type getCategorie() {
		return categorie;
	}

	public void setCategorie(Type categorie) {
		this.categorie = categorie;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
}
