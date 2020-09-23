package br.com.loglab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
	
	private String token;
	private String login;
	private String nomeUsuario;
	private String grupoAcesso;

}
