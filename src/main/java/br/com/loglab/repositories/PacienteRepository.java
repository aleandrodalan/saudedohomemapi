package br.com.loglab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.loglab.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	List<Paciente> findByPessoaNomeIgnoreCaseContainingOrderByPessoaNome(String nome);
	
	@Query("SELECT p FROM Paciente p WHERE p.pessoa.cpf = :cpf")
	List<Paciente> findSizePacienteByCpf(@Param("cpf") String cpf);
	
	Boolean existsByPessoaCpf(String cpf);
}