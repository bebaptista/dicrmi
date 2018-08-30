package br.com.puc.dicrmi.server;

import java.rmi.Naming;
import java.util.Scanner;

import br.com.puc.dicrmi.server.remote.Dicionario;
import br.com.puc.dicrmi.server.remote.impl.DicionarioServant;
import br.com.puc.dicrmi.server.service.DicionarioService;

public class DicionarioServer {

	private static final String RMI_SERVER = "rmi://localhost/";

	/**
	 * Main do servidor, metódo que publica o remote no registry
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		try (Scanner scanner = new Scanner(System.in)) {
			DicionarioService service = new DicionarioService();
			Dicionario dicionarioRemote = new DicionarioServant(service);
			Naming.rebind(RMI_SERVER + Dicionario.DICIONARIO_SERVICE, dicionarioRemote);
			System.out.println("Servidor Dicionario em execução.");

			System.out.println("Aperte ENTER para desligar o servidor...");
			scanner.nextLine();
			Naming.unbind(RMI_SERVER + Dicionario.DICIONARIO_SERVICE);
		} catch (Exception e) {
			System.err.println("Ops... algo de errado ocorreu");
		} finally {
			System.exit(0);
		}
	}

}
