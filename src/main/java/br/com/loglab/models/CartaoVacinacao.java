package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CartaoVacinacao {

	@Column(name = "POSSUI_CARTAO_VACINACAO")
	private Boolean possuiCartao;

	@Column(name = "VACINOU_HEPATITE_B")	
	private Boolean vacinouHepatiteB;

	@Column(name = "VACINOU_DT")	
	private Boolean vacinouDT;

	@Column(name = "VACINOU_FEBRE_AMARELA")	
	private Boolean vacinouFebreAmarela;

	@Column(name = "VACINOU_TRIPLICE_VIRAL")	
	private Boolean vacinouTripliceViral;

	@Column(name = "VACINOU_GRIPE_SESSENTA_ANOS")
	private Boolean vacinouGripeSessentaAnos;
}