package br.com.loglab.dto;

import java.time.LocalDate;

import br.com.loglab.enums.StatusEnum;
import br.com.loglab.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

	private Long id;
	private String login;
	private String senha;
	private String repetirSenha;
	private LocalDate ultimoAcesso;
	private StatusEnum status;
	private Pessoa pessoa;
}