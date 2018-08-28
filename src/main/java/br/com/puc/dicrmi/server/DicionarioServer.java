package br.com.puc.dicrmi.server;

import java.rmi.Naming;

import br.com.puc.dicrmi.server.remote.Dicionario;
import br.com.puc.dicrmi.server.remote.impl.DicionarioServant;

public class DicionarioServer {

	public static void main(String... args) {
		try {
			Dicionario d = new DicionarioServant(new DicionarioService().loadVerbetes());
			Naming.rebind("rmi://localhost/DicionarioService", d);
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println("Servidor Dicionario em execução.");
	}

}
