package br.com.codenation.comercio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codenation.comercio.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}