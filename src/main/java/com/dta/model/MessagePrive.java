package com.dta.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@DiscriminatorValue("MP")
public class MessagePrive extends Message {
	
	@NotNull
	private String titre;

}
