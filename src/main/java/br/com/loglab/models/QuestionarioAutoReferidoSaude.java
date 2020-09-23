package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.loglab.enums.ProcurouAtendimentoSaudeEnum;
import br.com.loglab.enums.QuandoConsultouDentista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class QuestionarioAutoReferidoSaude {
	 
	@Embedded
	private CartaoVacinacao cartaoVacinacao;
	
	@Embedded
	private Deficiencia deficiencia; 
	
	@Embedded
	private Alergia alergia; 

	@Embedded
	private PorqueProcurouAtendimento porqueProcurouAtendimento;

	@Embedded
	private BebidaAlcoolica bebidaAlcoolica;
	
	@Embedded
	private MotivoNaoProcurarAtendimento motivoNaoProcurarAtendimento;
	
	@Embedded
	private Tabagismo tabagismo;
	
	@Embedded
	private Vasectomia vasectomia;
	
	@Embedded
	private HistoricoCancer historicoCancer;
	
	@Embedded
	private FalarSaudeComHomemOuMulher falarSaudeComHomemOuMulher;
	
	@Embedded
	private Violencia violencia;
	
	@Embedded
	private ParticipaGrupoPlanejFamiliar participaGrupoPlanejFamiliar;
	
	@Embedded
	private AtividadeFisica atividadeFisica;
	
	@Embedded
	private HorarioDiferenciadoAtendimento horarioDiferenciadoAtendimento;
	
	@Embedded
	private AcuidadeVisual acuidadeVisual;
	
	@Column(name = "PROCUROU_ATEND_SAUDE")
	@Enumerated(EnumType.STRING)
	private ProcurouAtendimentoSaudeEnum procurouAtendSaude;
	
	@Embedded
	private ComoResolveuTratouEsteProblema comoResolveuTratouEsteProblema;
	
	@Column(name = "TEVE_PROBL_RENAIS")	
	private Boolean teveProblemasRenais;

	@Column(name = "TEVE_PROBL_RESPIRATORIO")	
	private Boolean teveProblemasRespiratorios;

	@Column(name = "TEVE_PROBL_GASTRICO")	
	private Boolean teveProblemasGastricos;

	@Column(name = "CONSULTOU_UROLOGISTA")	
	private Boolean consultouUrologista;

	@Column(name = "ULTIMO_ANO_PROB_SAUDE_NAO_PROC_ATEND_MEDICO")
	private Boolean ultimoAnoProblemaSaudeNaoProcurouAtendimento;
	
	@Column(name = "GOST_ATENDIM_SEU_BAIRRO")	
	private Boolean gostAtendDirecHomemSeuBairro;

	@Column(name = "SABIA_HOMEM_CONS_CONS_PRE_NATAL")	
	private Boolean sabiaHomemPodeRealizarConsultaPreNatal;
	
	@Column(name = "QUANDO_CONS_DENTISTA")	
	@Enumerated(EnumType.STRING)
	private QuandoConsultouDentista quandoConsultouDentista;

	@Column(name = "TESTE_SIFILIS")	
	private Boolean testeRapidoSifilis;
	
	@Column(name = "TESTE_HEPATITE")	
	private Boolean testeRapidoHepatite;
	
	@Column(name = "TESTE_HIV")	
	private Boolean testeRapidoHiv;
	
	@Column(name = "ATUALIZ_VACINA")	
	private Boolean atualizacaoVacina;
	
	@Column(name = "CONS_NUTRICIONISTA")	
	private Boolean consultaNutricionista;
	
	@Column(name = "CONS_OFTALMOLOGISTA")	
	private Boolean consultaOftalmologista;
	
	@Column(name = "cons_equipe_saude_fam")	
	private String consultaEquipeSaudeFamilia;
	
	@Column(name = "CONS_EQUIPE_SAUDE_FAM_MATRIC")	
	private String consultaEquipeSaudeFamiliaMatriciamento;
	
	@Column(name = "historico_exames_complementares")
	private String historicoExamesComplementares;
}