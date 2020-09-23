package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PorqueProcurouAtendimento {

	@Column(name = "ATEND_MED_FEBRE")
	private Boolean atendMedFebre;

	@Column(name = "ATEND_MED_DIARREIA")	
	private Boolean atendMedDiarreia;

	@Column(name = "ATEND_MED_TOSSE")	
	private Boolean atendMedTosse;

	@Column(name = "ATEND_MED_CURATIVO")	
	private Boolean atendMedCurativo;
	
	@Column(name = "ATEND_MED_VACINACAO")	
	private Boolean atendMedVacinacao;
	
	@Column(name = "ATEND_MED_PRE_NATAL")	
	private Boolean atendMedConsultaPreNatal;
	
	@Column(name = "ATEND_MED_HIPERTENSAO")	
	private Boolean atendMedHipertensao;
	
	@Column(name = "ATEND_MED_DIABETES")	
	private Boolean atendMedDiabetes;
	
	@Column(name = "ATEND_MED_TRAT_DENTARIO")	
	private Boolean atendMedTratamentoDentario;
	
	@Column(name = "ATEND_MED_DOR_REPENTINA")
	private Boolean atendMedDorRepentina;
	
	@Column(name = "ATEND_MED_FERIMENTO_FRATURA")	
	private Boolean atendMedFerimentoFratura;
	
	@Column(name = "ATEND_MED_CHECK_UP_ROTINA")	
	private Boolean atendMedCheckUpRotina;
	
	@Column(name = "ATEND_MED_EXAME_ADM")	
	private Boolean atendMedExameAdmissional;
	
	@Column(name = "ATEND_MED_PROBL_RESP")	
	private Boolean atendMedProblemaRespiratorio;
	
	@Column(name = "ATEND_MED_SAUDE_MENTAL")	
	private Boolean atendMedSaudeMental;
	
	@Column(name = "ATEND_MED_TROCA_REC_MED")	
	private Boolean atendMedTrocaReceitaMedica;
	
	@Column(name = "ATEND_MED_OUTRO")	
	private Boolean atendMedOutro;
	
	@Column(name = "ATEND_MED_OUTRO_EXTENSO")	
	private String atendMedOutroEscrito;
}