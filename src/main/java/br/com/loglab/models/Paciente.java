package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.loglab.validations.NumeroSus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PACIENTE")
public class Paciente extends AbstractEntity<Long> {

	@Valid
	@Embedded
	private Pessoa pessoa;
	
	@Transient
	private Integer idade;	
	
	@Valid
	@Embedded
	private DadosSocioDemograficos dadosSocioDemograficos;

	@Valid
	@Embedded
	private Endereco endereco;	
	
	@NumeroSus
	@Column(name = "NUMERO_CARTAO_SUS")
	private String numeroCartaoSus;
}