package Testes;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import dao.DeputadoDao;

public class TesteDeputadoDao {

	DeputadoDao depu;
	@Before
	public void setUp() throws Exception {
		depu = new DeputadoDao();
	}
	
	//Testando a instância
	@Test
	public void test() {
		assertNotNull(depu);
	}
	
	//Pensar em mais testes para esta classe

}
