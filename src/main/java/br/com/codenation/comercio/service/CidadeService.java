package br.com.codenation.comercio.service;

import java.util.Optional;

import br.com.codenation.comercio.model.Cidade;

public interface CidadeService {

	public Optional<Cidade> buscar(Integer id);
	public Iterable<Cidade> pesquisar();
	public Cidade salvar(Cidade cidade);
	public void deletar(Integer id);
	public Cidade alterar(Cidade cidade);
	
}
