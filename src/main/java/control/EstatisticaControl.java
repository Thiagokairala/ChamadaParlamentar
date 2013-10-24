package control;

import java.sql.SQLException;
import java.text.DecimalFormat;

import dao.EstatisticaDao;
import dao.SessoesEReunioesDao;
import model.Estatistica;

public class EstatisticaControl {

	public EstatisticaControl() {
		// TODO Auto-generated constructor stub
	}
	
	public static Estatistica gerarEstatisticas(String nome)	{
		Estatistica estatistica = new Estatistica();
		EstatisticaDao dao;
		SessoesEReunioesDao sessoes;
		
		try {
			sessoes = new SessoesEReunioesDao();
			dao = new EstatisticaDao();	
			estatistica.setLista(dao.getEstatisticaDeputados(nome));
			
			estatistica.setNome(nome);
			
			
			if(estatistica.getLista().size() != 0) {
			estatistica.setNumeroSessao(Integer.toString(estatistica.getLista().size()));
			
			DecimalFormat df = new DecimalFormat("###.00");  
			estatistica.setPorcentagem(df.format(
					(((double)estatistica.getLista().size())/
					((double)sessoes.passarNumeroDeSessoes()))*100) + "%");
		
			
			}
			else {
				estatistica.getLista().add("Dados não disponiveis!");
			}
			estatistica.setTotalSessao(Integer.toString(sessoes.passarNumeroDeSessoes()));
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estatistica;
		
	}

}
