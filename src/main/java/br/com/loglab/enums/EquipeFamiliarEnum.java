package br.com.loglab.enums;

public enum EquipeFamiliarEnum {
	
	MEDICO("Médico"),
	ENFERMEIRO("Enfermeiro"),
	NASF("NASF");
	
	private String descricao;
	
	private EquipeFamiliarEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}