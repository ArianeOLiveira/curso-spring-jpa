package br.com.codenation.comercio.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.codenation.comercio.model.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class EstadoServiceTest {

	@Autowired
	private EstadoServiceImpl service;

	@Test
	public void salvarTest() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		service.salvar(estado);
		
		Optional<Estado> optional = service.buscar(2);
		assertTrue(optional.isPresent());
	}

	@Test
	public void buscarTest() {
		Optional<Estado> estado = service.buscar(2);
		Assert.assertEquals("São Paulo", estado.get().getNome());
		Assert.assertEquals("SP", estado.get().getSigla());
		Assert.assertEquals("2", String.valueOf(estado.get().getCodigo()));
	}
	
	@Test
	public void deletarTest() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		service.salvar(estado);
		
		service.deletar(1);
		Optional<Estado> optional = service.buscar(1);
		assertFalse(optional.isPresent());
	}

}
