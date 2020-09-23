package br.com.loglab.enums;

public enum PeriodoAtendimento {

	MATUTINO("Matutino"),
	VESPERTINO("Vespertino"),
	NOTURNO("Noturno"),
	SABADO("Sábado");
	
	private String descricao;
	
	PeriodoAtendimento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}