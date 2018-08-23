package dicrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Dicionario extends Remote {
	
	public String consultar(String palavra) throws RemoteException;
	
	public String adicionar(Verbete verbete) throws RemoteException;
	
	public String remover() throws RemoteException;

}
