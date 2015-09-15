package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Message {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String contenu;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur auteur;
	
	public Message(){
		super();
	}

	public Message(int id, String contenu) {
		super();
		this.id = id;
		this.contenu = contenu;
	}

	public Message(int id, String contenu, Date dateCreation, Utilisateur auteur) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.dateCreation = dateCreation;
		this.auteur = auteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}	
	
}
