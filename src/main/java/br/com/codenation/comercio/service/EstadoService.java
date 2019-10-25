package br.com.codenation.comercio.service;

import java.util.Optional;

import br.com.codenation.comercio.model.Estado;

public interface EstadoService {

	public Optional<Estado> buscar(Integer id);
	public Iterable<Estado> pesquisar();
	public Estado salvar(Estado estado);
	public void deletar(Integer id);
	public Estado alterar(Estado estado);
	
}
