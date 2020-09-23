package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.loglab.enums.NaoAVontadeFalarSaudeHomemMulherEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class FalarSaudeComHomemOuMulher {

	@Column(name = "FALAR_SAUDE_HOMEM_MULHER")	
	private Boolean aVontadeFalarSaudeComHomemMulher;
	
	@Column(name = "NAO_AVONTADE_FALAR_SAUDE_HOMEM_MULHER")
	@Enumerated(EnumType.STRING)
	private NaoAVontadeFalarSaudeHomemMulherEnum naoAVontadeFalarSaudeHomemMulherEnum;
	
	@Column(name = "QUAL_OUTRO_FALAR_SAUDE")	
	private String qualOutroFalarSaude;	
}
