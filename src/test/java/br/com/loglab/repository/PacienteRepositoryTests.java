package br.com.loglab.repository;

import java.time.LocalDate;

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

import br.com.loglab.models.Endereco;
import br.com.loglab.models.Paciente;
import br.com.loglab.models.Pessoa;
import br.com.loglab.repositories.PacienteRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {FlywayAutoConfiguration.class, SecurityAutoConfiguration.class})
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PacienteRepositoryTests {

	@Autowired
	private PacienteRepository repository;
	
	@Test
	public void verificarExistePacienteCpf() {
		Pessoa pessoa = Pessoa
							.builder()
							.nome("Ciclano da Silva")
							.cpf("931.232.540-03")
							.dataNascimento(LocalDate.parse("1971-03-22"))
							.email("ciclanodasilva@teste.com.br")
							.telefone("(65)98888-7777")
							.build();
							
		Endereco endereco = Endereco
								.builder()
								.bairro("Centro Teste")
								.cep("78888-000")
								.cidade("Cuiabá")
								.uf("MT")
								.logradouro("Rua Sem Nome")
								.numero("1111")
								.build();
							
		
		Paciente paciente = Paciente
								.builder()
								.endereco(endereco)
								.pessoa(pessoa)
								.idade(26)
								.numeroCartaoSus("276419993500002")
								.build();
		
		repository.save(paciente);
		
		boolean result = repository.existsByPessoaCpf("931.232.540-03");
		
		Assertions.assertThat(result).isTrue();
	}
}