package br.com.codenation.comercio.error;

public class RecursoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 7003551256714454449L;

	public RecursoNaoEncontrado(String recurso, Integer id) {
		super(recurso + " com id:" + id + " não foi encontrado.");
	}
}
