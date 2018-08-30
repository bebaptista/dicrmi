package br.com.puc.dicrmi.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.puc.dicrmi.server.model.Verbete;

/**
 * 
 * Interface remota, localizada no RMI pelo nome de
 * {@value #DICIONARIO_SERVICE}
 *
 */
public interface Dicionario extends Remote {
	/**
	 * DicionarioService
	 */
	static final String DICIONARIO_SERVICE = "DicionarioService";
	
	/**
	 * Metódo para consulta de palavras no dicionário
	 * @param palavra
	 * @return significado
	 * @throws RemoteException
	 */
	public String consultar(String palavra) throws RemoteException;
	
	/**
	 * Metódo para adicionar novos verbetes no dicionário
	 * @param verbete
	 * @return status
	 * @throws RemoteException
	 */
	public String adicionar(Verbete verbete) throws RemoteException;
	
	/**
	 * Metódo para remover verbetes no dicionário
	 * @param verbete
	 * @return status
	 * @throws RemoteException
	 */
	public String remover(String palavra) throws RemoteException;

}
