package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Message {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String contenu;
	
	public Message(){
		super();
	}

	public Message(int id, String contenu) {
		super();
		this.id = id;
		this.contenu = contenu;
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
	
	
	
}
