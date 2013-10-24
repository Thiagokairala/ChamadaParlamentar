package br.com.MDSGPP.ChamadaParlamentar.control;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

import br.com.MDSGPP.ChamadaParlamentar.dao.DeputadoDao;
import br.com.MDSGPP.ChamadaParlamentar.dao.SessoesEReunioesDao;
import br.com.MDSGPP.ChamadaParlamentar.model.Deputados;


public class DeputadosControl {

	public DeputadosControl() {
	
	}

	public ArrayList<String> getDeputados() {
		
		DeputadoDao deputado;
		try {
			deputado = new DeputadoDao();
			return deputado.getNomesDeputados();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
