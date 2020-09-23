package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Alergia {

	@Column(name = "POSSUI_ALERGIA")
	private Boolean possuiAlergia;
	
	@Column(name = "ALERGIA_MEDICAMENTOS")	
	private Boolean alergiaMedicamentos;
	
	@Column(name = "ALERGIA_ASMA")	
	private Boolean alergiaAsma;
	
	@Column(name = "ALERGIA_RINITE")	
	private Boolean alergiaRinite;
	
	@Column(name = "ALERGIA_ALIMENTAR")	
	private Boolean alergiaAlimentar;
	
	@Column(name = "ALERGIA_ANIMAIS")	
	private Boolean alergiaAnimais;
	
	@Column(name = "ALERGIA_OUTRA")	
	private Boolean alergiaOutra;
	
	@Column(name = "QUAL_OUTRA_ALERGIA")	
	private String qualOutraAlergia;
}