package br.com.codenation.comercio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codenation.comercio.model.Cidade;
import br.com.codenation.comercio.repository.CidadeRepository;

@Service
public class CidadeServiceImpl implements CidadeService {

	private final CidadeRepository cidades;

	@Autowired
	CidadeServiceImpl(CidadeRepository repository) {
		this.cidades = repository;
	}

	@Override
	public Optional<Cidade> buscar(Integer id) {
		return cidades.findById(id);
	}

	@Override
	public Iterable<Cidade> pesquisar() {
		return cidades.findAll();
	}

	@Override
	public Cidade salvar(Cidade cidade) {
		return cidades.save(cidade);
	}

	@Override
	public void deletar(Integer id) {
		cidades.deleteById(id);
	}

	@Override
	public Cidade alterar(Cidade cidade) {
		return cidades.save(cidade);
	}

}
