package br.com.loglab.enums;

public enum TipoDeficienciaEnum {

	VISUAL("Visual"),
	AUDITIVA("Auditiva"),
	MENTAL("Mental"),
	FISICA("Física"),
	MULTIPLA("Multipla");
	
	private String descricao;
	
	TipoDeficienciaEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}