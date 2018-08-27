package dicrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.SortedSet;
import java.util.TreeSet;

public class DicionarioServant extends UnicastRemoteObject implements Dicionario {
	private static final long serialVersionUID = 1L;
	
	SortedSet<Verbete> dic = new TreeSet<Verbete>();

	public DicionarioServant() throws RemoteException {
		super();
		Verbete a = new Verbete("throughput","vazao");
		Verbete b = new Verbete("scholarship","bolsa de estudos");
		Verbete c = new Verbete("heart","coracao");
		dic.add(a);
		dic.add(b);
		dic.add(c);
	}

	public String consultar(String palavra) throws RemoteException {
		try{
			for(Verbete v : dic){
				if(v.getPalavra().equals(palavra)){
					return v.getSignificado();
				}
			}
			return "Palavra nao encontrada";
		}
		catch (Exception e){
			
		}
	}

	public String adicionar(Verbete verbete) throws RemoteException {
		try{
			dic.add(verbete);
		}
		catch(Exception e){
			
		}
	}

	public String remover(String palavra) throws RemoteException {
		try{
			for(Verbete v : dic){
				if(v.getPalavra().equals(palavra)){
					dic.remove(v);
					return "sucesso";
				}
			}
			return "Palavra nao encontrada";
		}
		catch(Exception e){
			
		}
	}

}
