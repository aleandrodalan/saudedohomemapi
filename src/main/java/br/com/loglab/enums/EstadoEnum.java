package br.com.loglab.enums;

public enum EstadoEnum {
	
	AC("AC", "Acre"), 
	AL("AL", "Alagoas"),
	AM("AM", "Amazonas"),
	AP("AP", "Amapá"),
	BA("BA", "Bahia"),
	CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Espírito Santo"),
	GO("GO", "Goiás"),
	MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Pará"),
	PB("PB", "Paraíba"),
	PR("PR", "Paraná"),
	PE("PE", "Pernambuco"),
	PI("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rondônia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "São Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");

	private String sigla;
	private String descricao;
	
	EstadoEnum(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getSigla() {
		return this.sigla;
	}
}