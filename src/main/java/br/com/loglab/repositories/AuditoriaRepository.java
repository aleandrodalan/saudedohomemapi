package br.com.loglab.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loglab.models.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
	
	List<Auditoria> findByDataAcessoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
}