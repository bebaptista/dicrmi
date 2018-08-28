package br.com.puc.dicrmi.server.model;

public class Verbete {

	private String palavra;
	private String significado;

	public Verbete(String palavra, String significado) {
		this.palavra = palavra;
		this.significado = significado;
	}
	
	public Verbete() {}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getSignificado() {
		return significado;
	}

	public void setSignificado(String significado) {
		this.significado = significado;
	}

}
