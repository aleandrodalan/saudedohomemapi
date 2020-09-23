package br.com.loglab.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Pessoa {

	@NotBlank(message = "Nome da Pessoa não pode estar vazio")
	@Column(name = "NOME")
	private String nome;
	
	@NotNull(message = "Data de nascimento não pode estar vazio")
	@JsonFormat(pattern = "ddMMyyyy")
	@Column(name = "DATA_NASCIMENTO")
	private LocalDate dataNascimento;
	
	@CPF(message = "CPF inválido")
	@Column(name = "CPF", unique = true)
	private String cpf;

	@Column(name = "TELEFONE")
	private String telefone;
	
	@Email(message = "E-mail inválido.")
	@Column(name = "EMAIL")
	private String email;	
}