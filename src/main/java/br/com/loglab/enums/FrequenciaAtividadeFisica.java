package br.com.loglab.enums;

public enum FrequenciaAtividadeFisica {

	UMA_VEZ_SEMANA("1x por semana"),
	DUAS_VEZ_SEMANA("2x por semana"),
	TRES_VEZ_SEMANA("3x por semana"),
	QUATRO_OU_MAIS_VEZES_SEMANA("4x ou mais");
	
	private String descricao;
	
	private FrequenciaAtividadeFisica(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}