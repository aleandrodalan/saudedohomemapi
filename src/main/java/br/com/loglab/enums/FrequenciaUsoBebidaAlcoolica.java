package br.com.loglab.enums;

public enum FrequenciaUsoBebidaAlcoolica {
	
	UMA_SEMANA("1x por semana"),
	DUAS_SEMANAS("2x por semana"),
	TRES_SEMANA_OU_MAIS("3x ou mais por semana");
	
	private String descricao;
	
	FrequenciaUsoBebidaAlcoolica(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}