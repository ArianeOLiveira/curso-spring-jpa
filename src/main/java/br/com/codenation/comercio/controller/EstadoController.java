package br.com.codenation.comercio.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.comercio.model.Estado;
import br.com.codenation.comercio.repository.EstadoRepository;

@RestController
@RequestMapping(path = "/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository estados;

	@GetMapping("/{id}")
	public Optional<Estado> buscar(@PathVariable Integer id) {
		return estados.findById(id);
	}

	@GetMapping
	public List<Estado> pesquisar() {
		return estados.findAll();
	}

	@PostMapping
	public Estado salvar(@RequestBody Estado estado) {
		return estados.save(estado);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		estados.deleteById(id);
	}


}