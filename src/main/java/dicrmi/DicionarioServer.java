package dicrmi;

import java.rmi.Naming;

public class DicionarioServer {

	public static void main(String... args) {
		try {
			Dicionario d = new DicionarioServant();
			Naming.rebind("rmi://localhost/DicionarioService", d);
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println("Servidor Dicionario em execução.");
	}

}
