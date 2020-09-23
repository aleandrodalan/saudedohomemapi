package br.com.loglab.enums;

public enum StatusEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	StatusEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}