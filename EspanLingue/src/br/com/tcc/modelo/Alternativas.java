package br.com.tcc.modelo;

import java.io.Serializable;

public class Alternativas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String alternativa;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	private Enunciado enunciado;
	private Gabarito gabarito;

	public Alternativas(){

	}
	public Alternativas(int id, String alternativaA,String alternativaB, String alternativaC, String alternativaD, Enunciado enunciado, Gabarito gabarito) {
		super();
		this.id = id;
		this.alternativa = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.enunciado = enunciado;
		this.gabarito = gabarito;
	}

	public Alternativas(String alternativaA, String alternativaB, String alternativaC, String alternativaD, Enunciado enunciado, Gabarito gabarito) {
		this();
		this.alternativa = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.enunciado = enunciado;
		this.gabarito = gabarito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativaA) {
		this.alternativa = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	public String getAlternativaD() {
		return alternativaD;
	}

	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}

	public Enunciado getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(Enunciado enunciado) {
		this.enunciado = enunciado;
	}

	public Gabarito getGabarito() {
		return gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
	}

	@Override
	public String toString() {
		return "Alternativas [id=" + id + ", alternativaA=" + alternativa + ", alternativaB=" + alternativaB
				+ ", alternativaC=" + alternativaC + ", alternativaD=" + alternativaD + ", enunciado=" + enunciado
				+ ", gabarito=" + gabarito + "]";
	}



}
