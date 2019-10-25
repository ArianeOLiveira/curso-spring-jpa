package br.com.codenation.comercio.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.comercio.model.Cidade;
import br.com.codenation.comercio.service.CidadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidades;

	@ApiOperation(value = "Retorna a cidade do id informado")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna a cidade"),
			@ApiResponse(code = 404, message = "Não existe cidade com esse id"), 
	})
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Cidade> buscar(@PathVariable Integer id) {
		return cidades.buscar(id);
	}

	@GetMapping
	public Iterable<Cidade> pesquisar() {
		return cidades.pesquisar();
	}

	@PostMapping
	public Cidade salvar(@Valid @RequestBody Cidade cidade) {
		return cidades.salvar(cidade);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		cidades.deletar(id);
		;
	}

	@PutMapping
	public void alterar(@Valid @RequestBody Cidade cidade) {
		cidades.alterar(cidade);
	}

}
