package br.com.puc.dicrmi.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.puc.dicrmi.server.model.Verbete;

public interface Dicionario extends Remote {
	
	static final String DICIONARIO_SERVICE = "DicionarioService";
	
	public String consultar(String palavra) throws RemoteException;
	
	public String adicionar(Verbete verbete) throws RemoteException;
	
	public String remover(String palavra) throws RemoteException;

}
