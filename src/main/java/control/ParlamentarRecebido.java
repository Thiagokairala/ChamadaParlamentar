package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estatistica;


public class ParlamentarRecebido extends javax.servlet.http.HttpServlet {

	protected void service (HttpServletRequest request, HttpServletResponse response) {

		String nome = request.getParameter("deputado");

		Estatistica estatistica = EstatisticaControl.gerarEstatisticas(nome);

		request.setAttribute("estatistica", estatistica);



		RequestDispatcher rd = request.getRequestDispatcher("/MostrarEstatisticaDeputado.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}