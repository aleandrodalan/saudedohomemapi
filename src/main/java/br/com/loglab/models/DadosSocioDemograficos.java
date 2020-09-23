package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.loglab.enums.EscolaridadeEnum;
import br.com.loglab.enums.EstadoCivil;
import br.com.loglab.enums.OrientacaoSexualEnum;
import br.com.loglab.enums.RacaCorEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DadosSocioDemograficos {

	@Column(name = "NOME_SOCIAL")
	private String nomeSocial;	
	
	@NotNull(message = "Raça/Cor não pode estar vazio.")
	@Enumerated(EnumType.STRING)
	@Column(name = "RACA_COR")
	private RacaCorEnum racaCor;

	@NotNull(message = "Escolaridade não pode estar vazio.")	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESCOLARIDADE")
	private EscolaridadeEnum escolaridade;

	@NotNull(message = "Estado civil não pode estar vazio.")	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO_CIVIL")
	private EstadoCivil estadoCivil;

	@NotNull(message = "Orientação sexual não pode estar vazio.")	
	@Enumerated(EnumType.STRING)
	@Column(name = "ORIENTACAO_SEXUAL")
	private OrientacaoSexualEnum orientacaoSexual;
	
	@Column(name = "QUAL_ORIENTACAO_SEXUAL")
	private String qualOrientacaoSexual;
	
	@NotBlank(message = "Ocupação atual não pode estar vazio.")
	@Column(name = "OCUPACAO_ATUAL")
	private String ocupacaoAtual;	
	
	@NotBlank(message = "Nome da mãe não pode estar vazio.")	
	@Column(name = "NOME_MAE")
	private String nomeMae;
	
	@Column(name = "NOME_PAI")
	private String nomePai;
}