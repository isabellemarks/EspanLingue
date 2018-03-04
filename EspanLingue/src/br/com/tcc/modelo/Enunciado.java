package br.com.tcc.modelo;

import java.io.Serializable;

public class Enunciado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Enunciado(){

	}
	private int id;
	private String enunciado;
	private Niveis niveis;

	public Enunciado(String enunciado, Niveis niveis) {
		super();
		this.enunciado = enunciado;
		this.niveis = niveis;
	}

	public Enunciado(int id, String enunciado, Niveis niveis) {
		super();
		this.id = id;
		this.enunciado = enunciado;
		this.niveis = niveis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Niveis getNiveis() {
		return niveis;
	}

	public void setNiveis(Niveis niveis) {
		this.niveis = niveis;
	}

	@Override
	public String toString() {
		return "Enunciado [id=" + id + ", enunciado=" + enunciado + ", niveis=" + niveis + "]";
	}



}
