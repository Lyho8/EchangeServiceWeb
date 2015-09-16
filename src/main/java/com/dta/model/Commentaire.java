package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@DiscriminatorValue("C")
public class Commentaire extends Message {

	@NotNull
	@ManyToOne
	@JoinColumn(name="idAnnonce")
	private Annonce annonce;
	
}
