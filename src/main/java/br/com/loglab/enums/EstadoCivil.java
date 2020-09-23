package br.com.loglab.enums;

public enum EstadoCivil {
	
	SOLTEIRO("Solteiro(a)"),
	CASADO("Casado(a)"),
	UNIAO_ESTAVEL("União Estável"),
	VIUVO("Viúvo(a)"),
	DIVORCIADO("Divorciado(a), separado(a) ou desquitado(a)");
	
	private final String descricao;
	
	EstadoCivil(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}