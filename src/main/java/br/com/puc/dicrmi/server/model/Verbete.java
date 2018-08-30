package br.com.puc.dicrmi.server.model;

import java.io.Serializable;
import java.util.Objects;
/**
 * 
 * Classe de modelo
 *
 */
public class Verbete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String palavra;
	private String significado;

	public Verbete(String palavra, String significado) {
		this.palavra = palavra;
		this.significado = significado;
	}

	public Verbete() {
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(palavra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Verbete other = (Verbete) obj;
		if (palavra == null) {
			if (other.palavra != null)
				return false;
		} else if (!palavra.equals(other.palavra))
			return false;
		if (significado == null) {
			if (other.significado != null)
				return false;
		} else if (!significado.equals(other.significado))
			return false;
		return true;
	}

}
