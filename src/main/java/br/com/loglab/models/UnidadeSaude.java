package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UNIDADE_SAUDE")
public class UnidadeSaude extends AbstractEntity<Long> {

	@NotBlank(message = "Nome da unidade de saúde não pode estar vazio")
	@Column(name = "NOME")
	private String nome;
	
	@NotBlank(message = "Telefone da unidade de saúde não pode estar vazio")
	@Column(name = "TELEFONE")
	private String telefone;

	@Valid
	@Embedded
	private Endereco endereco;
}