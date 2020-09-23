package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter
@Embeddable
public class HistoricoCancer {
	
	@Column(name = "HIST_FAMI_CANCER")	
	private Boolean historicoFamiliarCancer;

	@Column(name = "QUAL_TIPO_CANCER")	
	private String qualTipoCancer;	
}
