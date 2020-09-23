package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Vasectomia {

	@Column(name = "VASECTOMIZADO")
	private Boolean vasectomizado;

	@Column(name = "INTERESSE_VASECTOMIZAR")	
	private Boolean temInteresseVasectomizar;	
}
