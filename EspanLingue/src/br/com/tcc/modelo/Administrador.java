package br.com.tcc.modelo;

import java.io.Serializable;

public class Administrador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String login;
	private String senha;

	public Administrador() {

	}

	public Administrador(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Administrador(int id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", senha=" + senha + "]";
	}

}
