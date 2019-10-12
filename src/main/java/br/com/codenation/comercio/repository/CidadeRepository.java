package br.com.codenation.comercio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codenation.comercio.model.Cidade;
import br.com.codenation.comercio.model.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	public Cidade findByNome(String nome);
	public List<Cidade> findByEstado(Estado estado);
}
