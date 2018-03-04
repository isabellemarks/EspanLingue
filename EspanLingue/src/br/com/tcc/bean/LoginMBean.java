package br.com.tcc.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.tcc.dao.LoginDao;
import br.com.tcc.modelo.Administrador;

@ManagedBean
public class LoginMBean {
	private String login;
	private String senha;
	private Administrador loginUsuario;

	public LoginMBean(){

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

	public Administrador getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(Administrador loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public void entrar(){
		LoginDao loginDao = new LoginDao();
		this.setLoginUsuario(loginDao.autenticacao(login,senha));
		System.out.println("logou");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paginainicialadm.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}