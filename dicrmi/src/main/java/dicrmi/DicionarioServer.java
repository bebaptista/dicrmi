package dicrmi;
import java.rmi.Naming;

public class DicionarioServer {

		public DicionarioServer() {
			try {
				Dicionario d = new DicionarioServant();
				Naming.rebind("rmi://localhost/DicionarioService", d);
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		public static void main(String args[]) {
			DicionarioServer ds = new DicionarioServer();
			ds.carregaDicionario();
			System.out.println("Servidor Dicionario em execução.");
		}
		
		public void carregaDicionario(){
			
		}
}
