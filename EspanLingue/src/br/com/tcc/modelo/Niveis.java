package br.com.tcc.modelo;

import java.io.Serializable;

public class Niveis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nivel;

	public Niveis(){

	}

	public Niveis(int id, String nivel) {
		super();
		this.id = id;
		this.nivel = nivel;
	}

	public Niveis(String nivel) {
		super();

		this.nivel = nivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Niveis [id=" + id + ", nivel=" + nivel + "]";
	}



}
