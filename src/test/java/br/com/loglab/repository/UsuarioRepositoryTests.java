package br.com.loglab.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.loglab.enums.GrupoAcessoEnum;
import br.com.loglab.enums.StatusEnum;
import br.com.loglab.models.Pessoa;
import br.com.loglab.models.Usuario;
import br.com.loglab.repositories.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {FlywayAutoConfiguration.class, SecurityAutoConfiguration.class})
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTests {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void buscarUsuarioPeloLogin() {
		Pessoa pessoa = Pessoa
				.builder()
				.cpf("867.615.540-20")
				.dataNascimento(LocalDate.parse("1990-01-10"))
				.email("fulanodetal@teste.com.br")
				.nome("Fulano de Tal")
				.telefone("(65) 99999-8888")
				.build();

		Usuario usuario = Usuario
				.builder()
				.pessoa(pessoa)
				.login("fulanodetal")
				.senha("123456")
				.repetirSenha("123456")
				.alteracao(LocalDateTime.now())
				.status(StatusEnum.ATIVO)
				.grupo(GrupoAcessoEnum.COORDENADOR)
				.build();
		
		usuarioRepository.save(usuario);
		
		List<Usuario> usuarios = usuarioRepository.findByLogin("fulanodetal");
		
		Assertions.assertThat(usuarios.isEmpty()).isFalse();
	}
}