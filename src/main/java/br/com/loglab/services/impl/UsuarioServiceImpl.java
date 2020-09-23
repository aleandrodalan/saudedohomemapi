package br.com.loglab.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.loglab.dto.UsuarioDTO;
import br.com.loglab.enums.OperacaoEnum;
import br.com.loglab.enums.StatusEnum;
import br.com.loglab.exception.RegraNegocioException;
import br.com.loglab.models.Usuario;
import br.com.loglab.repositories.UsuarioRepository;
import br.com.loglab.services.AuditoriaService;
import br.com.loglab.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		if (usuario.getSenha() == null) {
			throw new RegraNegocioException("Senha não pode estar em branco.");
		}
		
		if (usuario.getRepetirSenha() == null) {
			throw new RegraNegocioException("Repetir senha não pode estar em branco.");
		}
		
		if (!validarSenha(usuario)) {
			throw new RegraNegocioException("Senha não pode estar diferente do repetir senha.");
		}
		
		if (verificarExisteUsuarioPorLogin(usuario.getLogin(), OperacaoEnum.INCLUSAO.name())) {
			throw new RegraNegocioException("Login já cadastrado.");
		}
		
		if (verificarExisteEmailJaCadastrado(usuario.getPessoa().getEmail(), OperacaoEnum.INCLUSAO.name())) {
			throw new RegraNegocioException("E-mail já cadastrado para outro usuário.");
		}
		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));

		Usuario usuarioRetorno = usuarioRepository.save(usuario);
		auditoriaService.salvarLog(usuario, OperacaoEnum.INCLUSAO);
		
		return usuarioRetorno;
	}

	@Override
	public void editar(Usuario usuario) {
		UsuarioDTO dto = converterParaObjetoDTO(buscarUsuarioPorId(usuario.getId()));
		String senha = usuario.getSenha();
		
		if (!senha.equals(dto.getSenha())) {
			if (!validarSenha(usuario)) {
				throw new RegraNegocioException("Senha não pode estar diferente do repetir senha.");				
			}
		}
		
		if (verificarExisteUsuarioPorLogin(usuario.getLogin(), OperacaoEnum.ALTERACAO.name())) {
			throw new RegraNegocioException("Login já cadastrado.");
		}
		
		if (buscarUsuariosPorStatus(StatusEnum.ATIVO).size() < 2 && usuario.getStatus().equals(StatusEnum.INATIVO)) {
			throw new RegraNegocioException("O único Usuário ativo não pode ser inativado");
		}
		
		if (verificarExisteEmailJaCadastrado(usuario.getPessoa().getEmail(), OperacaoEnum.ALTERACAO.name())) {
			throw new RegraNegocioException("Email já está cadastrado para outro Usuário");
		}
		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		usuarioRepository.save(usuario);
		
		auditoriaService.salvarLog(usuario, OperacaoEnum.ALTERACAO);
	}

	@Override
	public void excluir(Long id) {
		Usuario usuario = usuarioRepository.findById(id).get();
	
		if (usuario == null) {
			throw new RegraNegocioException("Usuário não encontrado");
		}

		try {
			auditoriaService.salvarLog(usuarioRepository.findById(id).get(), OperacaoEnum.EXCLUSAO);
			usuarioRepository.delete(usuario);
		} catch (Exception e) {
			throw new RegraNegocioException("Não foi possível excluir usuário.");
		}
	}

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public List<Usuario> buscarUsuarioPorLogin(String login) {
		return usuarioRepository.findByLoginContainingIgnoreCase(login);		
	}

	@Override
	@Transactional(readOnly = true)	
	public List<Usuario> buscarUsuariosPorStatus(StatusEnum status) {
		return usuarioRepository.findByStatus(status);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscar(Usuario usuario) {
		Example<Usuario> example = Example.of(usuario, ExampleMatcher
												.matching()
												.withIgnoreCase()
												.withStringMatcher(StringMatcher.CONTAINING));

		return (List<Usuario>) usuarioRepository.findAll((Sort) example);
	}

	private String criptografarSenha(String senhaOriginal) {
		return new BCryptPasswordEncoder().encode(senhaOriginal);
	}
	
	public UsuarioDTO converterParaObjetoDTO(Usuario usuario) {
		return UsuarioDTO
				.builder()
				.login(usuario.getLogin())
				.senha(usuario.getSenha())
				.repetirSenha(usuario.getRepetirSenha())
				.status(usuario.getStatus())
				.pessoa(usuario.getPessoa())
				.build();
	}

	private Boolean verificarExisteUsuarioPorLogin(String login, String operacao) {
		boolean resultado = false;
		
		int quantUsuarios = usuarioRepository.findByLogin(login).size();
		
		if (!login.isEmpty()) {
			if (operacao == OperacaoEnum.ALTERACAO.name()) {
				resultado = quantUsuarios > 1;
			} else {
				if (operacao == OperacaoEnum.INCLUSAO.name()) {
					resultado = quantUsuarios > 0;
				}	
			}			
		}
		
		return resultado;
	}

	private Boolean validarSenha(Usuario usuario) {
		if (!usuario.getSenha().equals(usuario.getRepetirSenha())) {
			return false;
		}
		
		return true;
	}

	private Boolean verificarExisteEmailJaCadastrado(String email, String operacao) {
		if (!email.isEmpty()) {
			if (operacao == OperacaoEnum.ALTERACAO.name()) {
				return usuarioRepository.findByPessoaEmail(email).size() > 1;
			} else {
				if (operacao == OperacaoEnum.INCLUSAO.name()) {
					return usuarioRepository.findByPessoaEmail(email).size() > 0;
				}	
			}
		}
		
		return false;
	}

	@Override
	public Usuario buscarExatoUsuarioPorLogin(String login) {
		return usuarioRepository.findByUserLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados.")); 
	}
}