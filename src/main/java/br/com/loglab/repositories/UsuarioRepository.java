package br.com.loglab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.loglab.enums.StatusEnum;
import br.com.loglab.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByLoginContainingIgnoreCase(String login);	

	List<Usuario> findByLogin(String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.login = :login")
	Optional<Usuario> findByUserLogin(@Param("login") String username); 
	
	Boolean existsByLogin(String login);
	
	List<Usuario> findByStatus(StatusEnum status);
	
	List<Usuario> findByPessoaEmail(String email);
	
	Boolean existsByPessoaEmail(String email);

}