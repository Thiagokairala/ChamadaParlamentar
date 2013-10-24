package Testes;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dao.EstatisticaDao;

public class TesteEstatisticaDao {

	EstatisticaDao esta;
	@Before
	public void setUp() throws Exception {
		esta = new EstatisticaDao();
	}

	@Test
	public void test() throws SQLException {

		assertTrue(esta.getEstatisticaDeputados().size() == 100);
	}

}
