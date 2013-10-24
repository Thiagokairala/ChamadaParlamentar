package classesDeConexao;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosLocator;
import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import br.gov.camara.www.SitCamaraWS.Deputados.ObterDeputadosResponseObterDeputadosResult;

public class ConexaoComWsDeputados {

	public ConexaoComWsDeputados() {
		
		
	}
	

	public static DeputadosSoapStub obterConexao()
	throws MalformedURLException, ServiceException, UnknownHostException {
		URL url;
		url = new URL("http://www.camara.gov.br/SitCamaraWS/Deputados.asmx");
		DeputadosSoapStub service = (DeputadosSoapStub)
		new DeputadosLocator().getDeputadosSoap(url);
		
		return service;
	}
	
	
	public static ObterDeputadosResponseObterDeputadosResult 
	receberElementDeputados(DeputadosSoapStub service) {
		
		//conexao criada, agora chamaremos a classe do ws
		try {
			ObterDeputadosResponseObterDeputadosResult deputados =
					service.obterDeputados();
			
			return deputados;
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}	
	}
}


	
	