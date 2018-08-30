package br.com.puc.dicrmi.server.remote.impl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import br.com.puc.dicrmi.server.model.Verbete;
import br.com.puc.dicrmi.server.remote.Dicionario;
import br.com.puc.dicrmi.server.service.DicionarioService;

/**
 * Classe que implementa a interface remota {@link Dicionario}
 *
 */
public class DicionarioServant extends UnicastRemoteObject implements Dicionario {

	private static final long serialVersionUID = 1L;
	private Set<Verbete> dic = Collections.synchronizedSet(new HashSet<>());
	private final DicionarioService service;

	/**
	 * Construtor que recebe {@link DicionarioService}
	 * 
	 * @param service
	 * @throws IOException - See also {@link DicionarioService#loadVerbetes()}
	 */
	public DicionarioServant(DicionarioService service) throws IOException {
		super();
		this.service = service;
		this.dic.addAll(service.loadVerbetes());
	}

	@Override
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

	@Override
	public String adicionar(Verbete verbete) throws RemoteException {
		String resposta = "Duplicata";
		try {
			if (!dic.contains(verbete)) {
				this.dic.add(verbete);
				resposta = verbete.getSignificado();
				service.adicionaVerbete(verbete);
			}
		} catch (Exception e) {
			resposta = "Erro ao inserir verbete";
		}

		return resposta;
	}

	@Override
	public String remover(String palavra) throws RemoteException {
		try {
			for (Verbete v : dic) {
				if (v.getPalavra().equals(palavra)) {
					dic.remove(v);
					service.removeVerbete(v);
					return "sucesso";
				}
			}
			return "Palavra nao encontrada";
		} catch (Exception e) {
			return "Palavra nao encontrada";
		}
	}

}
