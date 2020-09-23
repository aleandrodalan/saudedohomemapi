package br.com.loglab.enums;

public enum RacaCorEnum {
	
	BRANCA("Branca"),
	PARDA("Parda"),
	PRETA("Preta"),
	AMARELA("Amarela"),
	INDIGENA("Indígena"),
	IGNORADA("Ignorada");

	private String descricao;
	
	RacaCorEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}