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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loglab.enums.FailSuccesEnum;
import br.com.loglab.models.UnidadeSaude;
import br.com.loglab.services.UnidadeSaudeService;

@Transactional
@RestController
@RequestMapping("/unidadessaude")
public class UnidadeSaudeController {
	List<UnidadeSaude> unidadesSaude;
	
	@Autowired
	ApplicationControllerAdvise advise;
	
	@Autowired
	private UnidadeSaudeService unidadeSaudeService;
	
	@Transactional(readOnly = true)
	@GetMapping
	public List<UnidadeSaude> listar() {
		return unidadeSaudeService.buscarTodos();
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/nome/{nome}")
	public List<UnidadeSaude> listarPorNome(@PathVariable("nome") String nome) {
		return unidadeSaudeService.buscarPorNome(nome);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UnidadeSaude salvar(@RequestBody @Valid UnidadeSaude unidadeSaude) {
		try {
			unidadeSaudeService.salvar(unidadeSaude);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

		return unidadeSaude;
	}
	
	@Transactional(readOnly = true)
	@GetMapping("{id}")
	public UnidadeSaude preEditar(@PathVariable("id") Long id) {
		return unidadeSaudeService.buscarPorId(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	
	public void editar(@PathVariable("id") Long id, @RequestBody @Valid UnidadeSaude unidadeSaudeAtualizada) {
		UnidadeSaude unidadeSaude = unidadeSaudeService.buscarPorId(id);
		
		try {
			unidadeSaudeAtualizada.setId(unidadeSaude.getId());
			unidadeSaudeService.editar(unidadeSaudeAtualizada);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());			
		}
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Long id) {
		try {
			unidadeSaudeService.excluir(id);
		} catch( Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());			
		}
	}
	
	@GetMapping("/relatorio")
	public ModelAndView viewReport(RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String caminho = unidadeSaudeService.exportarRelatorioParaPdf(unidadesSaude);
			attr.addFlashAttribute(FailSuccesEnum.SUCCESS.getDescricao(), "Relatório de Unidade de Saúde foi exportado com sucesso em " + caminho);
			mv.setViewName("redirect:/unidadesaude/listar");
		} catch(Exception e) {
			mv.setViewName("/unidade_saude/listarUnidade");
			mv.addObject(FailSuccesEnum.FAIL.getDescricao(), e.getMessage());			
		}
		
		return mv;
	}
}