package br.com.MDSGPP.ChamadaParlamentar.dao;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.NodeList;

import br.com.MDSGPP.ChamadaParlamentar.classesDeConexao.ConexaoComWsDeputados;
import br.com.MDSGPP.ChamadaParlamentar.model.Deputados;
import br.gov.camara.www.SitCamaraWS.Deputados.ObterDeputadosResponseObterDeputadosResult;

public class DeputadoDao {

	private Connection conexao;


	public DeputadoDao() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().getConnection();
	}

	public void adicionaDeputado(ArrayList<Deputados> deputados) throws SQLException {

		String sql = "insert into deputado" + "(idParlamentar, matricula, ideCadastro, "
				+ "nomeCivil, nomeDeTratamento, sexo, uf, partido"
				+ ", numeroDoGabinete, anexo, telefone, email)" +
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


		PreparedStatement stmt = conexao.prepareStatement(sql);
		for(int i = 0; i<deputados.size(); i++) {

			stmt.setInt(1, deputados.get(i).getIdDoParlamentar());
			stmt.setInt(2, deputados.get(i).getMatricula());
			stmt.setInt(3, deputados.get(i).getIdeCadastro());
			stmt.setString(4, deputados.get(i).getNomeCivilDoParlamentar());
			stmt.setString(5, deputados.get(i).getNomeDeTratamentoDoParlamentar());
			stmt.setString(6, deputados.get(i).getSexo());
			stmt.setString(7, deputados.get(i).getUf());
			stmt.setString(8, deputados.get(i).getPartido());
			stmt.setString(9, deputados.get(i).getNumeroDoGabinete());
			stmt.setString(10, deputados.get(i).getAnexo());
			stmt.setString(11, deputados.get(i).getTelefone());
			stmt.setString(12, deputados.get(i).getEmail());

			stmt.execute();

		}
		stmt.close();	
	}


	public ArrayList<Deputados> criaLista() throws MalformedURLException,
	UnknownHostException, ServiceException {
		ArrayList<Deputados> lista = new ArrayList<Deputados>();
		ObterDeputadosResponseObterDeputadosResult deputados;

		deputados = ConexaoComWsDeputados.receberElementDeputados
				(ConexaoComWsDeputados.obterConexao());			
		NodeList nome = deputados.get_any()[0].getElementsByTagName("nome");
		NodeList nomeTratamento = deputados.get_any()[0].getElementsByTagName("nomeParlamentar");
		NodeList id = deputados.get_any()[0].getElementsByTagName("ideCadastro");
		NodeList matricula = deputados.get_any()[0].getElementsByTagName("matricula");
		NodeList idParlamentar = deputados.get_any()[0].getElementsByTagName("idParlamentar");
		NodeList sexo = deputados.get_any()[0].getElementsByTagName("sexo");
		NodeList uf = deputados.get_any()[0].getElementsByTagName("uf");
		NodeList partido = deputados.get_any()[0].getElementsByTagName("partido");
		NodeList gabinete = deputados.get_any()[0].getElementsByTagName("gabinete");
		NodeList anexo = deputados.get_any()[0].getElementsByTagName("anexo");
		NodeList fone = deputados.get_any()[0].getElementsByTagName("fone");
		NodeList email = deputados.get_any()[0].getElementsByTagName("email");

		for(int i = 0; i<nome.getLength(); i++) {
			MessageElement nomeTratamentoTemp = (MessageElement) nomeTratamento.item(i);
			MessageElement nomeTemp = (MessageElement) nome.item(i);
			MessageElement idTemp = (MessageElement) id.item(i);
			MessageElement matriculaTemp = (MessageElement) matricula.item(i);
			MessageElement idParlamentarTemp = (MessageElement) idParlamentar.item(i);
			MessageElement sexoTemp = (MessageElement) sexo.item(i);
			MessageElement ufTemp = (MessageElement) uf.item(i);
			MessageElement partidoTemp = (MessageElement) partido.item(i);
			MessageElement gabineteTemp = (MessageElement) gabinete.item(i);
			MessageElement anexoTemp = (MessageElement) anexo.item(i);
			MessageElement foneTemp = (MessageElement) fone.item(i);
			MessageElement emailTemp = (MessageElement) email.item(i);
			System.out.println(nomeTratamentoTemp);
			System.out.println(nomeTemp);
			System.out.println(idTemp);
			System.out.println(matriculaTemp);
			System.out.println(idTemp);
			System.out.println(sexoTemp);
			System.out.println(ufTemp);
			System.out.println(partidoTemp);
			System.out.println(emailTemp);

			int idInt = Integer.parseInt(idTemp.getFirstChild().getNodeValue());
			int matriculaInt = Integer.parseInt(matriculaTemp.getFirstChild().getNodeValue());
			int idParlamentarInt = Integer.parseInt(idParlamentarTemp.getFirstChild().getNodeValue());
			System.out.println("ta chegando aqui de boa");
			String nomeText = nomeTemp.getFirstChild().getNodeValue();
			String nomeTratamentoText = nomeTratamentoTemp.getFirstChild().getNodeValue();
			String sexoText = sexoTemp.getFirstChild().getNodeValue();
			String ufText = ufTemp.getFirstChild().getNodeValue();
			String partidoText = partidoTemp.getFirstChild().getNodeValue();
			String gabineteText;
			String anexoText;
			String foneText;

			try {//esse try catch esta aqui por causa de um erro oriundo do webservice no qual
				//a tag nao vem completa para o devido tratamento.
				gabineteText = gabineteTemp.getFirstChild().getNodeValue();
				anexoText = anexoTemp.getFirstChild().getNodeValue();
				foneText = foneTemp.getFirstChild().getNodeValue();
			} catch (NullPointerException e) {
				gabineteText = null;
				anexoText = null;
				foneText = null;

			}



			String emailText = emailTemp.getFirstChild().getNodeValue();

			Deputados deputadoNovo = new Deputados(idParlamentarInt, matriculaInt, idInt,
					nomeText, nomeTratamentoText, sexoText, ufText, partidoText, gabineteText,
					anexoText, foneText, emailText);

			System.out.println( i);



			lista.add(deputadoNovo);
		}
		return lista;
	}

	public ArrayList<String> getNomesDeputados() throws SQLException {
		String sql = "Select * from deputado"; 

		ArrayList<String> lista = new ArrayList<String>();

		PreparedStatement stmt= this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while(rs.next()) {
			String nomeTratamento = rs.getString("nomeDeTratamento");
			String partido = rs.getString("partido");
			String uf = rs.getString("uf");
			
			String montar = nomeTratamento + "-" + partido + "/" + uf;
			lista.add(montar);
		}

		stmt.close();

		return lista;

	}

	public ArrayList<Integer> getMatriculaDeputados() {
		String sql = "Select * from deputado"; //criando o comando sql, procura como buscar uma linha especifica...

		ArrayList<Integer> lista = new ArrayList<Integer>();

		try {
			PreparedStatement stmt= this.conexao.prepareStatement(sql);//criando o prepared statement q é o que vai conetar com o banco
			ResultSet rs = stmt.executeQuery();//executando o stmt para buscar os dados

			while(rs.next()) {
				lista.add(rs.getInt("matricula"));
			}

		} catch (SQLException e) {
			lista.add(0);
			e.printStackTrace();
		}

		return lista;

	}

	public Deputados receberDadosDeputado(String nome) {
		String sql = "select * from deputado where nomeCivil = "+ nome;

		PreparedStatement stmt;
		try {
			stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			Deputados deputado = new Deputados(rs.getInt("idParlamentar"), rs.getInt("matricula"),
					rs.getInt("ideCadastro"), rs.getString("nomeCivil"), rs.getString("nomeDeTratamento"),
					rs.getString("sexo"), rs.getString("uf"), rs.getString("partido"),
					rs.getString("numeroDoGabinete"), rs.getString("anexo"), rs.getString("telefone"),
					rs.getString("email"));

			return deputado;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}		
	}
}
