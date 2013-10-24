package Testes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import br.com.MDSGPP.ChamadaParlamentar.dao.ConnectionFactory;

public class TesteConnectionFactory {

	ConnectionFactory connection;
	@Before
	public void setUp() throws Exception {
		connection = new ConnectionFactory();
	}

	//Testando a instância
	@Test
	public void test() {
		assertNotNull(connection);
	}
	@Test
	public void testGet(){
		//pensar em como testar o método Connection getConnection()
	}
	
}
