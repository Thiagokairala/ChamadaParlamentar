package Testes;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.MDSGPP.ChamadaParlamentar.dao.EstatisticaDao;

public class TesteEstatisticaDao {

	EstatisticaDao esta;
	@Before
	public void setUp() throws Exception {
		esta = new EstatisticaDao();
	}

	@Test
	public void test() throws SQLException {

		assertTrue(esta.getEstatisticaDeputados(null).size() == 100);
	}

}
