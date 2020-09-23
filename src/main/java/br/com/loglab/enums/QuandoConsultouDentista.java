package br.com.loglab.enums;

public enum QuandoConsultouDentista {

	MENOS_UM_ANO("Há menos de 1 ano"),
	UM_E_DOIS_ANOS("Entre 1 e menos de 2 anos"),
	DOIS_E_TRES_ANOS("Entre 2 e menos de 3 anos"),
	TRES_OU_MAIS_ANOS("3 anos ou mais"),
	NUNCA("Nunca consultou");
	
	private String descricao;
	
	QuandoConsultouDentista(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}