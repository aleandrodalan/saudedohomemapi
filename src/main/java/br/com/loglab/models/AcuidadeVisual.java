package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class AcuidadeVisual {

	@Column(name = "OLHO_DIR_COM_CORRECAO")	
	private Boolean olhoDireitoComCorrecao;
	
	@Column(name = "OLHO_ESQ_COM_CORRECAO")	
	private Boolean olhoEsquerdoComCorrecao;	
}
