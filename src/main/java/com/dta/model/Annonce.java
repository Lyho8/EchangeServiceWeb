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
	
}
