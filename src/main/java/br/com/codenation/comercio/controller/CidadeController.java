package br.com.codenation.comercio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.comercio.model.Cidade;
import br.com.codenation.comercio.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidades;

	@GetMapping("/{id}")
	public Optional<Cidade> buscar(@PathVariable Integer id) {
		return cidades.buscar(id);
	}

	@GetMapping
	public Iterable<Cidade> pesquisar() {
		return cidades.pesquisar();
	}

	@PostMapping
	public Cidade salvar(@RequestBody Cidade cidade) {
		return cidades.salvar(cidade);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		cidades.deletar(id);;
	}
	
	@PutMapping
	public void alterar(@RequestBody Cidade cidade) {
		cidades.alterar(cidade);
	}

}
