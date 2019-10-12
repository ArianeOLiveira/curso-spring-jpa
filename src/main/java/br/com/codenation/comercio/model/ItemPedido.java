package br.com.codenation.comercio.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido {

	@EmbeddedId
	private ItemPedidoId id;

	private Integer quantidade;
	private Double valor;

	public ItemPedidoId getId() {
		return id;
	}

	public void setId(ItemPedidoId id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
