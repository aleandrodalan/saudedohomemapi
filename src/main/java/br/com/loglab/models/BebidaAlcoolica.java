package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.loglab.enums.FrequenciaUsoBebidaAlcoolica;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class BebidaAlcoolica {
	
	@Column(name = "FAZ_USO_BEBIDA_ALCOOLICA")
	private Boolean fazUsoBebidaAlcoolica;
	
	@Column(name = "TEMPO_USO_BEBIDA_ALCOOLICA")
	@Enumerated(EnumType.STRING)
	private FrequenciaUsoBebidaAlcoolica frequenciaUsoBebidaAlcoolica;
}