package br.com.codenation.comercio.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoId implements Serializable {

	private static final long serialVersionUID = 7123396116706325414L;

	@ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;
}
