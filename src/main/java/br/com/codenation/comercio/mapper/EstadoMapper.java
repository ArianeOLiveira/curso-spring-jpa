package br.com.codenation.comercio.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.codenation.comercio.dto.EstadoDTO;
import br.com.codenation.comercio.model.Estado;

public class EstadoMapper {

	public EstadoDTO map(Estado estado) {
		return new EstadoDTO(estado.getCodigo(), estado.getNome(), estado.getSigla());
	};

	public List<EstadoDTO> map(List<Estado> estados){
		
		List<EstadoDTO> lista = new ArrayList<>();
		for(Estado e : estados) {
			lista.add(new EstadoDTO(e.getCodigo(), e.getNome(), e.getSigla()));
		}
		
		return lista;
		
	};
	
}