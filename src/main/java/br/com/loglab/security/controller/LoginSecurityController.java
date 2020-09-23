package br.com.loglab.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.loglab.dto.CredenciaisDTO;
import br.com.loglab.dto.TokenDTO;
import br.com.loglab.exception.SenhaInvalidaException;
import br.com.loglab.models.Usuario;
import br.com.loglab.security.jwt.JwtService;
import br.com.loglab.security.service.LoginSecurityService;
import br.com.loglab.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class LoginSecurityController {

	@Autowired
	private LoginSecurityService loginService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/auth")
	public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciais) {
		try {
			Usuario usuario = Usuario.builder()
								.login(credenciais.getLogin())
								.senha(credenciais.getSenha())
								.build();
			
			UserDetails usuarioAutenticado = loginService.autenticar(usuario);
			
			usuario = usuarioService.buscarExatoUsuarioPorLogin(usuario.getLogin()); 
			
			String token = jwtService.gerarToken(usuario);

			return new TokenDTO(token, 
								usuarioAutenticado.getUsername(), 
								usuario.getPessoa().getNome(), 
								usuario.getGrupo().name());
		} catch(UsernameNotFoundException | SenhaInvalidaException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}	
}