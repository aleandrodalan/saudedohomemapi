package br.com.loglab.enums;

public enum NaoAVontadeFalarSaudeHomemMulherEnum {

	PREFERE_HOMEM("Prefiro homem"),
	PREFERE_MULHER("Prefiro mulher"),
	TIMIDEZ("Timidez"),
	MEDO("Medo"),
	POUCO_TEMPO("Pouco tempo de consulta"),
	OUTRO("Outro");
	
	private String descricao;
	
	NaoAVontadeFalarSaudeHomemMulherEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}