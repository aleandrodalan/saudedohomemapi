package br.com.loglab.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

	@Column(name = "CEP")
	private String cep;

	@NotBlank(message = "Logradouro não pode estar vazio.")
	@Column(name = "LOGRADOURO")
	private String logradouro;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@NotBlank(message = "Bairro não pode estar vazio.")
	@Column(name = "BAIRRO")
	private String bairro;
	
	@NotBlank(message = "Cidade não pode estar vazio.")
	@JsonProperty(value = "localidade")
	@Column(name = "CIDADE")
	private String cidade;

	@NotBlank(message = "Estado não pode estar vazio.")
	@Column(name = "ESTADO")
	private String uf;
	
	@NotBlank(message = "Número não pode estar vazio.")
	@Column(name = "NUMERO")
	private String numero;
}