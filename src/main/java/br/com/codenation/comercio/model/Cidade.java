package br.com.codenation.comercio.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModelProperty;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cidade {

	@ApiModelProperty(value = "Código da cidade")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@ApiModelProperty(value = "Nome da cidade")
	private String nome;
	
	@ManyToOne
	private Estado estado;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@PostPersist
	public void aposInserir() {
		System.out.println("Nova cidade cadastrada!");
	}

	@PostRemove
	public void aposexcluir() {
		System.out.println("Cidade excluída!");
	}

}
