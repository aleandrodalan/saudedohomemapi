package br.com.loglab.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.loglab.enums.OperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "AUDITORIA")
public class Auditoria extends AbstractEntity<Long> {

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "DATA_ACESSO")	
	private LocalDateTime dataAcesso;
	
	@Column(name = "NOME_USUARIO")
	private String nomeUsuario;
	
	@Column(name = "LOGIN_USUARIO")
	private String loginUsuario;
	
	@Column(name = "COMPUTADOR")
	private String computador;
	
	@Column(name = "IP")
	private String ip;
	
	@Column(name = "JSON")
	private String json;
	
	@Enumerated(EnumType.STRING)
	private OperacaoEnum operacao;
	
	@Column(name = "CLASSE")
	private String classe;
}