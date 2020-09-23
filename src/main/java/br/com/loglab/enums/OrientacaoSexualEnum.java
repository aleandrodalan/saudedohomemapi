package br.com.loglab.enums;

public enum OrientacaoSexualEnum {
	
	HETEROSSEXUAL("Heterossexual"),
	HOMOSSEXUAL("Homossexual"),
	BISSEXAUL("Bissexual"),
	ASSEXUAL("Assexual"),
	PANSEXUAL("Pansexual"),
	OUTRO("Outro");
	
	private final String descricao;
	
	private OrientacaoSexualEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}