package br.com.codenation.comercio.controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.codenation.comercio.model.Estado;

public class EstadoControllerTest {

	final String BASE_PATH = "http://localhost:9000/estado";

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void salvarTest() throws JsonProcessingException, URISyntaxException {

		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");

		URI uri = new URI(BASE_PATH);

		ResponseEntity<Estado> response = restTemplate.postForEntity(uri, estado, Estado.class);
		assertEquals(201, response.getStatusCode().value());
		assertEquals("São Paulo", response.getBody().getNome());
		assertEquals("SP", response.getBody().getSigla());
	}

	@Test
	public void salvarValidacaoSiglaTest() throws JsonProcessingException, URISyntaxException {

		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP32");

		URI uri = new URI(BASE_PATH);

		try {
			restTemplate.postForEntity(uri, estado, Estado.class);
		} catch (HttpClientErrorException ex) {
			Assert.assertEquals(400, ex.getRawStatusCode());
			Assert.assertEquals(true, ex.getResponseBodyAsString().contains("O campo sigla deve conter 2 caracteres"));
		}

	}
}
