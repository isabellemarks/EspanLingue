package br.com.tcc.modelo;

import java.io.Serializable;

public class Gabarito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String gabarito;

	public Gabarito(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gabarito(String gabarito) {
		super();
		this.gabarito = gabarito;
	}

	public String getGabarito() {
		return gabarito;
	}

	public void setGabarito(String gabarito) {
		this.gabarito = gabarito;
	}

	@Override
	public String toString() {
		return "Gabarito [id=" + id + ", gabarito=" + gabarito + "]";
	}



}
