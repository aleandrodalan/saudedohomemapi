package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class ParticipaGrupoPlanejFamiliar {

	@Column(name = "PARTIC_PLANEJ_FAMILIAR")	
	private Boolean participaPlanejamentoFamiliar;
	
	@Column(name = "TEM_INTERES_PLAN_FAMILIAR")	
	private Boolean temInteressePlanFamiliar;
}