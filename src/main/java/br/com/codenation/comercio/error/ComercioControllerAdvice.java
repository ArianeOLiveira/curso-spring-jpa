package br.com.codenation.comercio.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ComercioControllerAdvice {

	@ExceptionHandler(RecursoNaoEncontrado.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleResourceNotFoundException(RecursoNaoEncontrado ex) {
		return ex.getMessage();
	}

}
