package br.com.puc.dicrmi.server.remote.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Vector;

import br.com.puc.dicrmi.server.model.Verbete;
import br.com.puc.dicrmi.server.remote.Dicionario;

public class DicionarioServant extends UnicastRemoteObject implements Dicionario {
	private static final long serialVersionUID = 1L;

	List<Verbete> dic = new Vector<Verbete>();

	public DicionarioServant(List<Verbete> dic) throws RemoteException {
		super();
		this.dic.addAll(dic);
	}

	public String consultar(String palavra) throws RemoteException {
		try {
			for (Verbete v : dic) {
				if (v.getPalavra().equals(palavra)) {
					return v.getSignificado();
				}
			}
			return "Palavra nao encontrada";
		} catch (Exception e) {
			return "Palavra nao encontrada";
		}
	}

	public String adicionar(Verbete verbete) throws RemoteException {
		try {
			dic.add(verbete);
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public String remover(String palavra) throws RemoteException {
		try {
			for (Verbete v : dic) {
				if (v.getPalavra().equals(palavra)) {
					dic.remove(v);
					return "sucesso";
				}
			}
			return "Palavra nao encontrada";
		} catch (Exception e) {
			return null;
		}
	}

}
