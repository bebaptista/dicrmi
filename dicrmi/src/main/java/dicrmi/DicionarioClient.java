import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//package dicrmi;

public class DicionarioClient {
	public static void main(String[] args){
		DicionarioGrafico dg = new DicionarioGrafico();
		dg.setVisible(true);
		String servidor = "rmi://localhost/";
		String nome = "DicionarioService";
		boolean flag=false;
		try {
			Dicionario d = (Dicionario) Naming.lookup(servidor + nome);
			System.out.println("Objeto remoto \'"+ nome + "\' encontrado no servidor.");
			
//			
//			int x = 10, y = 5;
//			System.out.println(x + " + " + y + " = " + c.somar(x, y));
//			System.out.println(x + " - " + y + " = " + c.subtrair(x, y));
//			System.out.println(x + " * " + y + " = " + c.multiplicar(x, y));
//			System.out.println(x + " / " + y + " = " + c.dividir(x, y));

		} catch (MalformedURLException e) {
			System.out.println("URL \'" + servidor + nome + "\' mal formatada.");
		} catch (RemoteException e) {
			System.out.println("Erro na invocacao remota.");
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Objeto remoto \'" + nome + "\' nao esta disponivel.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
