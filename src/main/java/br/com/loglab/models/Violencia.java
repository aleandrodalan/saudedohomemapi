package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Violencia {

	@Column(name = "SOFREU_VIOLENCIA")	
	private Boolean sofreuViolencia;
	
	@Column(name = "VIOLENCIA_PSICOLOGICA")	
	private Boolean violenciaPsicologica;
	
	@Column(name = "VIOLENCIA_FISICA")	
	private Boolean violenciaFisica;
	
	@Column(name = "VIOLENCIA_SEXUAL")	
	private Boolean violenciaSexual;
	
	@Column(name = "VIOLENCIA_TODAS")	
	private Boolean violenciaTodas;
}
