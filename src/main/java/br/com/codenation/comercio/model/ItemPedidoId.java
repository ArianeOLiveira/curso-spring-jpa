package br.com.codenation.comercio.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoId implements Serializable {

	@ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;
}
