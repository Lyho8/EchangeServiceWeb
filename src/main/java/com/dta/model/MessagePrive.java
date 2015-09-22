package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
@DiscriminatorValue("MP")
public class MessagePrive extends Message {
	
	@NotNull
	private String titre;
	
	@NotNull
	@ManyToMany
	@JoinTable(name = "usr_msg", joinColumns = { @JoinColumn(name = "idMsg") }, inverseJoinColumns = { @JoinColumn(name = "idUsr") })
	private List<Utilisateur> destinataires;
	
	public MessagePrive(){
		super();
	}

	public MessagePrive(String titre, List<Utilisateur> destinataires) {
		super();
		this.titre = titre;
		this.destinataires = destinataires;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Utilisateur> getDestinataires() {
		return destinataires;
	}

	public void setDestinataires(List<Utilisateur> destinataires) {
		this.destinataires = destinataires;
	}

}
