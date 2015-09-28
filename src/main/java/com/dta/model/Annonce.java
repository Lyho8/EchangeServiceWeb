package com.dta.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
public class Annonce {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@NotNull
	private boolean active;
	
	private String image;
	
	@NotNull
	private Type type;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur auteur;
	
	@OneToMany(mappedBy="annonce", cascade=CascadeType.ALL)
	@PrivateOwned
	@OrderBy ("dateCreation asc")
	private List<Commentaire> commentaires;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	public Annonce(){
		super();
		
		dateCreation = new Date();
	}

	public Annonce(int id, String description, boolean active, Type type,
			Date dateCreation) {
		super();
		this.id = id;
		this.description = description;
		this.active = active;
		this.type = type;
		this.dateCreation = dateCreation;
	}

	public Annonce(int id, String description, boolean active, Type type,
			Date dateCreation, Utilisateur auteur,
			List<Commentaire> commentaires, Categorie categorie) {
		super();
		this.id = id;
		this.description = description;
		this.active = active;
		this.type = type;
		this.dateCreation = dateCreation;
		this.auteur = auteur;
		this.commentaires = commentaires;
		this.categorie = categorie;
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

	public Type getType() {
		return type;
	}

	public void setCategorie(Type type) {
		this.type = type;
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

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
