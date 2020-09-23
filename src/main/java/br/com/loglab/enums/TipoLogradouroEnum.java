package br.com.loglab.enums;

public enum TipoLogradouroEnum {
	
	A("Avenida"),
	R("Rua"),
	T("Travessa"),
	EST("Estrada"),
	ROD("Rodovia");
	
	private String descricao;
	
	TipoLogradouroEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}