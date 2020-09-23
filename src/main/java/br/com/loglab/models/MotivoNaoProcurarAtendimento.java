package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class MotivoNaoProcurarAtendimento {
	
	@Column(name = "NAO_SABIA_ONDE_IR")
	private Boolean naoSabiaOndeIr;
	
	@Column(name = "NAO_TINHA_DINH_TRANSP")	
	private Boolean naoTinhaDinheiroTransporte;
	
	@Column(name = "NAO_TINHA_DINH_CONS")	
	private Boolean naoTinhaDinheiroConsulta;
	
	@Column(name = "NAO_PODIA_AUSEN_TRAB")	
	private Boolean naoPodiaAusentarTrabalho;
	
	@Column(name = "NAO_FOI_ATEND_VEZ_ANT")	
	private Boolean naoFoiAtendidoVezAnterior;
	
	@Column(name = "FOI_MAL_ATEND_OUT_VEZ")	
	private Boolean foiMalAtendidoOutrasVezes;
	
	@Column(name = "NAO_ACHOU_IMPORT")	
	private Boolean naoAchouImportante;
	
	@Column(name = "OUTRO_MOTIVO_NAO_PROC_ATEND")	
	private Boolean outroMotivoNaoProcAten;
	
	@Column(name = "OUTRO_MOTIVO")	
	private String outroMotivo;
}