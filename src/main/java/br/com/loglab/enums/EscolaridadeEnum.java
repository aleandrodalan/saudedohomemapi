package br.com.loglab.enums;

public enum EscolaridadeEnum {
	
	SEM_ESCOLARIDADE("Sem escolaridade"),
	FUNDAMENTAL_INCOMPLETO("Fundamental Incompleto"),
	FUNDAMENTO_COMPLETO("Fundamental Completo"),
	MEDIO_INCOMPLETO("Médio Incompleto"),
	MEDIO_COMPLETO("Médio Completo"),
	SUPERIOR_INCOMPLETO("Superior Incompleto"),
	SUERIOR_COMPLETO("Superior Completo"),
	ESPECIALIZACAO_INCOMPLETO("Especialização Incompleto"),
	ESPECIALIZACAO_COMPLETO("Especialização Completo"),
	MESTRADO_INCOMPLETO("Mestrado Incompleto"),
	MESTRADO_COMPLETO("Mestrado Completo"),
	DOUTORADO_INCOMPLETO("Doutorado Incompleto"),
	DOUTORADO_COMPLETO("Doutorado Completo");
	
	private final String descricao;
	
	EscolaridadeEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}