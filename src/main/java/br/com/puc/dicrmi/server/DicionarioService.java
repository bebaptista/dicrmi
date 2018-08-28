package br.com.puc.dicrmi.server;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.puc.dicrmi.server.model.Verbete;

public class DicionarioService {
	
	private List<Verbete> verbetes;
	private ObjectMapper mapper;
	
	private static final String PATH_JSON = "src/main/resources/verbetes.json";
	
	public DicionarioService() {
		this.mapper = new ObjectMapper();
	}
	
	public List<Verbete> loadVerbetes() throws IOException {
		this.verbetes = mapper.readValue(new File(PATH_JSON), new TypeReference<List<Verbete>>(){});
		return verbetes;
	}
}
