package br.com.tcc.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.tcc.dao.CadastroDePerguntasDao;
import br.com.tcc.dao.LoginDao;
import br.com.tcc.modelo.Jogador;

@ManagedBean
public class LoginBeanJogador {

	private String login;
	private String senha;
	private Jogador jogador = new Jogador();

	public LoginBeanJogador(){

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

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public void entrar(){
		LoginDao loginDao = new LoginDao();
		this.setJogador(loginDao.autenticarJogador(login,senha));
		System.out.println("logou");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paginainicialjogador.xhtml");
			adicionarJogador(jogador);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cadastrarJogador(){
		CadastroDePerguntasDao dao = new CadastroDePerguntasDao();
		dao.cadastrarUmJogador(jogador);

	}
	public Jogador recuperarUsuario(){		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session1 = (HttpSession) request.getSession();
		Jogador usuarioSession = (Jogador) session1.getAttribute("JOGADOR");
		return usuarioSession;		
	}
	
	public String adicionarJogador(Jogador jogador){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("JOGADOR", jogador);
		return null;		
	}
}