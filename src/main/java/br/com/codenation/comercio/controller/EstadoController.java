package br.com.codenation.comercio.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.comercio.dto.EstadoDTO;
import br.com.codenation.comercio.error.RecursoNaoEncontrado;
import br.com.codenation.comercio.mapper.EstadoMapper;
import br.com.codenation.comercio.model.Estado;
import br.com.codenation.comercio.repository.EstadoRepository;

@RestController
@RequestMapping(path = "/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository estados;
	private EstadoMapper mapper = new EstadoMapper();
	

	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscar(@PathVariable Integer id) {
		return new ResponseEntity<Estado>(estados.findById(id).orElseThrow(() -> new RecursoNaoEncontrado("Estado", id)), HttpStatus.OK);
	}
	
	@GetMapping("dto/{id}")
	public EstadoDTO buscarDTO(@PathVariable Integer id) {
		return estados.findById(id).map(mapper::map).orElse(null);
	}

	@GetMapping
	public List<Estado> pesquisar() {
		return estados.findAll();
	}
	
	@GetMapping("/dto")
	public List<EstadoDTO> pesquisarDTO() {
		return mapper.map(estados.findAll());
	}

	@PostMapping
	public ResponseEntity<Estado> salvar(@Valid @RequestBody Estado estado) {
		return new ResponseEntity<Estado>(estados.save(estado), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Estado> alterar(@Valid @RequestBody Estado estado) {
		return new ResponseEntity<Estado>(estados.save(estado), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		estados.deleteById(id);
	}


}