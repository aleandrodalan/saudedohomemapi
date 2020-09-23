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

import br.com.loglab.models.Prontuario;
import br.com.loglab.services.ProntuarioService;

@Transactional
@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {
	
	@Autowired
	private ProntuarioService prontuarioService;
	
	@Transactional(readOnly = true)	
	@GetMapping
	public List<Prontuario> listar() {
		return prontuarioService.buscarTodosProntuarios();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Prontuario salvar(@RequestBody @Valid Prontuario prontuario) {
		try {
			prontuarioService.salvar(prontuario);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

		return prontuario;
	}
	
	@Transactional(readOnly = true)
	@GetMapping("{id}")
	public Prontuario preEditar(@PathVariable("id") Long id) {
		return prontuarioService.buscarProntuarioPorId(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editar(@PathVariable("id") Long id, @RequestBody @Valid Prontuario prontuarioAtualizado) {
		Prontuario prontuario = prontuarioService.buscarProntuarioPorId(id);
			
		try {
			prontuarioAtualizado.setId(prontuario.getId());
			prontuarioService.alterar(prontuarioAtualizado);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable("id") Long id) {
		try {
			prontuarioService.excluir(id);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@Transactional(readOnly = true)
	@GetMapping("/nome_paciente/{nome}")
	public List<Prontuario> buscarProntuarioPacientePorNome(@PathVariable("nome") String nome) {
		return prontuarioService.buscarProntuariosPorNomePaciente(nome);
	}
}