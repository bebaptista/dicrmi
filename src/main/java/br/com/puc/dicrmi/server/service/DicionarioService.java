package br.com.puc.dicrmi.server.service;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.puc.dicrmi.server.model.Verbete;

/**
 * 
 * Classe na camada de serviços para abstrair chamadas de {@link #Dicionario}
 *
 */
public class DicionarioService {

	private final ObjectMapper mapper;

	private Set<Verbete> verbetes;

	private static final String PATH_JSON = "src/main/resources/verbetes.json";

	private static final File JSON = new File(PATH_JSON);

	public DicionarioService() {
		this.mapper = new ObjectMapper();
	}

	/**
	 * Método que carrega do {@link #PATH_JSON}
	 * 
	 * @return verbetes
	 * @throws IOException
	 */
	public Set<Verbete> loadVerbetes() throws IOException {
		this.verbetes = mapper.readValue(JSON, new TypeReference<Set<Verbete>>() {
		});
		return this.verbetes;
	}

	/**
	 * Método que adiciona um novo {@link #Verbete}
	 * 
	 * @param verbete
	 */
	public void adicionaVerbete(Verbete verbete) {
		if (verbetes.add(verbete))
			try {
				realizaAlteracoes();
			} catch (IOException e) {
				System.err.println("Erro ao gravar json");
			}
	}

	/**
	 * Método que remove um {@link #Verbete}
	 * 
	 * @param verbete
	 */
	public void removeVerbete(Verbete verbete) {
		if (verbetes.remove(verbete))
			try {
				realizaAlteracoes();
			} catch (IOException e) {
				System.err.println("Erro ao gravar json");
			}
	}

	/**
	 * Método sincrono que de fato escreve no arquivo
	 * 
	 * @throws IOException
	 */
	private synchronized void realizaAlteracoes() throws IOException {
		mapper.writeValue(JSON, verbetes);
	}

}
