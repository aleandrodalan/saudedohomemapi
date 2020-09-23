package br.com.loglab.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.loglab.models.Usuario;
import br.com.loglab.services.UsuarioService;

@Service
public class UsuarioSecurityDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarExatoUsuarioPorLogin(username);
        
        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(usuario.getGrupo().toString())
                .build();
    }
}