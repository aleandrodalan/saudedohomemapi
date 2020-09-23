package br.com.loglab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loglab.models.Prontuario;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
	
	List<Prontuario> findByPacientePessoaNomeContainingIgnoreCase(String nome);
	
	Boolean existsByPacienteId(Long id);
	
	Boolean existsByUnidadeSaudeId(Long id);
}