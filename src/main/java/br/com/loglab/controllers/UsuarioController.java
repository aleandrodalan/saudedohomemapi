package br.com.loglab.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.loglab.models.Usuario;
import br.com.loglab.services.UsuarioService;

@Transactional
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Transactional(readOnly = true)
	@GetMapping
	public List<Usuario> listar() {
		return usuarioService.buscarTodosUsuarios();
	}

	@Transactional(readOnly = true)	
	@GetMapping("/loginUsuario/{login}")
	public List<Usuario> listarPorLogin(@PathVariable("login") String login) {
		return usuarioService.buscarUsuarioPorLogin(login);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody @Valid Usuario usuario) {
		try {
			usuarioService.salvar(usuario);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		return usuario;
	}
	
	@Transactional(readOnly = true)	
	@GetMapping("{id}")
	public Usuario preEditar(@PathVariable("id") Long id) {
		return usuarioService.buscarUsuarioPorId(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editar(@PathVariable("id") Long id, @RequestBody @Valid Usuario usuarioAtualizado) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		
		try {
			usuarioAtualizado.setId(usuario.getId());			
			usuarioService.editar(usuarioAtualizado);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());			
		}
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Long id) {
		try {
			usuarioService.excluir(id);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());			
		}
	}	
}