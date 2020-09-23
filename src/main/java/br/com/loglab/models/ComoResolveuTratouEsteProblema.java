package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ComoResolveuTratouEsteProblema {

	@Column(name = "NAO_FEZ_NADA")
	private Boolean naoFezNada;
	
	@Column(name = "FARMACEUTICO_PASSOU_REMEDIO")	
	private Boolean farmaceuticoPassouRemedio;
	
	@Column(name = "TOMOU_REMEDIO_CASEIRO")	
	private Boolean tomouRemedioCaseiro;
	
	@Column(name = "TOMOU_REMEDIO_TINHA_CASA")	
	private Boolean tomouRemedioTinhaCasa;
	
	@Column(name = "OUTRO_COMO_TRATOU_PROBLEMA")	
	private Boolean outroComoTratouProblema;
	
	@Column(name = "QUAL_OUTRO_COMO_TRATOU_PROBLEMA")	
	private String qualOutroComoTratouProblema;
}