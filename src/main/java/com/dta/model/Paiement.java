package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Paiement {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private Date dateDemande;
	
	private Date dateValidation;
	
	@NotNull
	private boolean valide;
	
	@NotNull
	private int montant;
	
	@NotNull
	private String message = "";
	
	public Paiement(){
		super();
	}

	public Paiement(int id, Date dateDemande, Date dateValidation,
			boolean valide, int montant, String message) {
		super();
		this.id = id;
		this.dateDemande = dateDemande;
		this.dateValidation = dateValidation;
		this.valide = valide;
		this.montant = montant;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
