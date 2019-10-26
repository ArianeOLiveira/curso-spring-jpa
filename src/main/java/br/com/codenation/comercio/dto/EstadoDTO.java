package br.com.codenation.comercio.dto;

public class EstadoDTO {

	private Integer codigo;
	private String nome;
	private String sigla;

	public EstadoDTO(Integer codigo2, String nome2, String sigla2) {
		codigo = codigo2;
		nome = nome2;
		sigla = sigla2;
	}

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
