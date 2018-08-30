package br.com.puc.dicrmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.puc.dicrmi.server.remote.Dicionario;

/**
 * Classe main do client
 *
 */
public class DicionarioClient {
	/**
	 * Main
	 * 
	 * @param args <tbody>
	 *             <tr>
	 *             <td>Na posição 0 pode ser passado o servidor que se deseja
	 *             conectar</td>
	 *             </tr>
	 *             </tbody>
	 */
	public static void main(String... args) {
		String nome = "DicionarioService";
		try {
			String servidor = "rmi://" + args[0] + "/";
			Dicionario d = (Dicionario) Naming.lookup(servidor + nome);
			DicionarioGrafico dg = new DicionarioGrafico(d);
			dg.setVisible(true);
			System.out.println("Objeto remoto \'" + nome + "\' encontrado no servidor: " + servidor);

		} catch (MalformedURLException e) {
			System.out.println("URL mal formatada.");
		} catch (RemoteException e) {
			System.out.println("Erro na invocacao remota.");
		} catch (NotBoundException e) {
			System.out.println("Objeto remoto \'" + nome + "\' nao esta disponivel.\nTente mais tarde");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nenhum servidor foi informado por linha de comando!\nTentando conexão com o localhost");
			main("localhost");
		}
	}
}
