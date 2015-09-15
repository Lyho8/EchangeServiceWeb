package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.eclipse.persistence.annotations.*;

import java.util.*;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Size(max = 60, min = 3)
	private String nom = "";

	@Size(max = 60, min = 3)
	private String prenom = "";

	@NotNull
	@Size(max = 16, min = 2)
	private String login;

	@NotNull
	@Size(max = 50, min = 6)
	private String motDePasse;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInscription;
	
	@NotNull
	private int solde = 0;
	
	@OneToMany(mappedBy="auteur", cascade={ CascadeType.PERSIST , CascadeType.DETACH })
	@PrivateOwned
	private List<Message> messages;
	
	@OneToMany(mappedBy="auteur", cascade={ CascadeType.PERSIST , CascadeType.DETACH })
	@PrivateOwned
	private List<Annonce> annonces;
	
	@ManyToMany
	@JoinTable(name = "usr_msg", joinColumns = {@JoinColumn(name = "idUsr")}, inverseJoinColumns = {@JoinColumn(name = "idMsg")})
	private List<Message> messagesRecus;
	
	public Utilisateur(){
		super();
	}

	public Utilisateur(int id, String nom, String prenom, String login,
			String motDePasse, int solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.solde = solde;
	}

	public Utilisateur(int id, String nom, String prenom, String login,
			String motDePasse, Date dateInscription, int solde,
			List<Message> messages, List<Annonce> annonces,
			List<Message> messagesRecus) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
		this.solde = solde;
		this.messages = messages;
		this.annonces = annonces;
		this.messagesRecus = messagesRecus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public List<Message> getMessagesRecus() {
		return messagesRecus;
	}

	public void setMessagesRecus(List<Message> messagesRecus) {
		this.messagesRecus = messagesRecus;
	}

}
