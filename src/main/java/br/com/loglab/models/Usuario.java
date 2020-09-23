package br.com.loglab.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.loglab.enums.GrupoAcessoEnum;
import br.com.loglab.enums.StatusEnum;
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
@Table(name = "USUARIO")
public class Usuario extends AbstractEntity<Long> {

	@Valid
	@Embedded
	private Pessoa pessoa;
	
	@NotBlank(message = "Login não pode estar em branco")
	@Column(name = "LOGIN", unique = true)
	private String login;
	
//	@JsonIgnore
	@Column(name = "SENHA")
	private String senha;
	
//	@JsonIgnore	
	@Transient
	private String repetirSenha;
	
	@Column(name = "ALTERACAO")
	private LocalDateTime alteracao;
	
	@NotNull(message = "Status não pode estar em branco")
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusEnum status;
	
	@NotNull(message = "Grupo de Acesso não pode estar em branco")
	@Enumerated(EnumType.STRING)
	@Column(name = "GRUPO_ACESSO")
	private GrupoAcessoEnum grupo;
	
	@PrePersist
	public void prePersist() {
		setAlteracao(LocalDateTime.now());
	}
}