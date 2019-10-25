package br.com.codenation.comercio.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.codenation.comercio.model.Estado;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EstadoRepositoryTest {

	@Autowired
	private EstadoRepository repository;
	
	@Test
	public void saveTest() {
		
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		Estado response = repository.save(estado);
		assertEquals("São Paulo", response.getNome());
		assertEquals("SP", response.getSigla());
		
	}
}
