package model;

import java.util.ArrayList;
import java.util.List;

public class Estatistica {

	private String nome;
	private String NumeroSessao;
	private String TotalSessao;
	private String porcentagem;
	private List<String> Lista = new ArrayList<String>(); 

//construtor
	
	public Estatistica(){
		
	}


	public String getNumeroSessao() {
		return NumeroSessao;
	}

	public void setNumeroSessao(String numeroSessao) {
		NumeroSessao = numeroSessao;
	}

	public String getTotalSessao() {
		return TotalSessao;
	}

	public void setTotalSessao(String totalSessao) {
		TotalSessao = totalSessao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(String porcentagem) {
		this.porcentagem = porcentagem;
	}

	public List<String> getLista() {
		return Lista;
	}

	public void setLista(List<String> lista) {
		Lista = lista;
	}
	
	
}


