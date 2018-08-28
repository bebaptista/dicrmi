package br.com.puc.dicrmi.server;

import java.rmi.Naming;

import br.com.puc.dicrmi.server.remote.Dicionario;
import br.com.puc.dicrmi.server.remote.impl.DicionarioServant;

public class DicionarioServer {

	private static final String RMI_SERVER = "rmi://localhost/";

	public static void main(String... args) {
		try {
			Dicionario dicionarioService = new DicionarioServant(new DicionarioService().loadVerbetes());
			Naming.rebind(RMI_SERVER + Dicionario.DICIONARIO_SERVICE, dicionarioService);
			System.out.println("Servidor Dicionario em execução.");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
