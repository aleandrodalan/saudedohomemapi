package br.com.loglab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.loglab.models.UnidadeSaude;

@Repository
public interface UnidadeSaudeRepository extends JpaRepository<UnidadeSaude, Long> {
	
	List<UnidadeSaude> findByNomeIgnoreCaseContainingOrderByNome(String nome);
	
	UnidadeSaude findByNomeAndEnderecoCidadeAndEnderecoUf(String nome, String cidade, String uf);
	
	@Query("SELECT u FROM UnidadeSaude u where u.nome = :nome and u.endereco.cidade = :cidade and u.endereco.uf = :uf")
	List<UnidadeSaude> findByQuantUnidadeSaudeExistComMesmoNome(String nome, String cidade, String uf);
	
	Boolean existsByNomeAndEnderecoCidadeAndEnderecoUf(String nome, String cidade, String uf);
}