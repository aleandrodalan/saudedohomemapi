package br.com.loglab.enums;

public enum ProcurouAtendimentoSaudeEnum {

	ULTIMOS_TRINTA_DIAS("Nos últimos 30 dias"),
	ENTRE_UM_MES_E_UM_ANO("Entre 1 mês e 1 ano"),
	MAIS_DE_UM_ANO("Mais de 1 ano"),
	NUNCA_PROCUROU("Nunca procurou");
	
	private String descricao;
	
	private ProcurouAtendimentoSaudeEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}