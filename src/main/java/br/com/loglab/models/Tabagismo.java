package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Tabagismo {

	@Column(name = "TABAGISTA")	
	private Boolean ehTabagista;
	
	@JsonDeserialize
	@Column(name = "TEMPO_TABAGISTA")	
	private String tempoTabagista;
	
	@Column(name = "VONTADA_PARAR_TABAGISMO")	
	private Boolean temVontadePararTabagismo;
}
