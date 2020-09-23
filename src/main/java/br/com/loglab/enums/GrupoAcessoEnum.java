package br.com.loglab.enums;

public enum GrupoAcessoEnum {
	
	ENFERMEIRO("Enfermeiro"),
	TECNICO("Técnico"),
	MEDICO("Médico"),
	COORDENADOR("Coordenador");
	
	private String descricao;
	
	private GrupoAcessoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}