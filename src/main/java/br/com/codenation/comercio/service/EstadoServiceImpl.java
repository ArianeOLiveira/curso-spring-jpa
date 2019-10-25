package br.com.codenation.comercio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codenation.comercio.model.Estado;
import br.com.codenation.comercio.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService {

	private final EstadoRepository repository;

	@Autowired
	EstadoServiceImpl(EstadoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Estado> buscar(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Iterable<Estado> pesquisar() {
		return repository.findAll();
	}

	@Override
	public Estado salvar(Estado estado) {
		return repository.save(estado);
	}

	@Override
	public void deletar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Estado alterar(Estado estado) {
		return repository.save(estado);
	}

}
