package br.com.tcc.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import br.com.tcc.conexao.ConexaoBD;
import br.com.tcc.dao.CadastroDePerguntasDao;
import br.com.tcc.modelo.Jogador;
import br.com.tcc.modelo.Questoes;


@ManagedBean
@ViewScoped
public class QuestoesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Questoes> questoes = new ArrayList<Questoes>();
	private Questoes questao = new Questoes();
	private String alternativa = "";
	private int contador = 0;
	private Jogador jogador ;
	
	private List<Questoes> resultados = new ArrayList<Questoes>();
	private List<Jogador> resultados_jogador = new ArrayList<Jogador>();
	
	public QuestoesBean(){
		recuperar();
		
	}
	
	public ArrayList<Questoes> getQuestoes() {
		return questoes;
	}
	
	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public void setQuestoes(ArrayList<Questoes> questoes) {
		this.questoes = questoes;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Questoes getQuestao() {
		return questao;
	}

	public void setQuestao(Questoes questao) {
		this.questao = questao;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Questoes> getResultados() {
		return resultados;
	}

	public void setResultados(List<Questoes> resultados) {
		this.resultados = resultados;
	}

	public List<Jogador> getResultados_jogador() {
		return resultados_jogador;
	}

	public void setResultados_jogador(List<Jogador> resultados_jogador) {
		this.resultados_jogador = resultados_jogador;
	}

	@PostConstruct
	public void init() {
		CadastroDePerguntasDao dao = new CadastroDePerguntasDao();
		LoginBeanJogador loginBean = new LoginBeanJogador();
		jogador = loginBean.recuperarUsuario();
		questoes = dao.listarTodasAsQuestoes();
		questao = questoes.get(contador);
	}
	
	public void enviar(){
		contador++;
		if(alternativa.equals(questao.getGabarito())){
			int pontos = jogador.getPontos();
			pontos = pontos +10;
			jogador.setPontos(pontos);
			inserirPontosJogador(jogador);
			System.out.println("Acertô");
		}else{
			System.out.println("Errô");
		}
		if(contador < questoes.size()){
			questao = questoes.get(contador);
		}else{
			entrar();
		}
	}
	
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
	
	public void entrar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("paginainicialjogador.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int inserirPontosJogador(Jogador jogador){
		if (jogador == null) {
			throw new IllegalArgumentException(
					"Ou voc� est� tentando persistir NULL ou ent�o est� faltando alguma depend�ncia.");
		}

		Connection connection = ConexaoBD.conexao();
		final String INSERIR_PONTOS = "UPDATE jogador SET pontos = ? WHERE id = ?;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_PONTOS);
			preparedStatement.setInt(1, jogador.getPontos());
			preparedStatement.setInt(2, jogador.getId());
			preparedStatement.executeUpdate();
			
			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;

	}

	public List<Questoes> recuperar(){
		CadastroDePerguntasDao dao = new CadastroDePerguntasDao();
		this.resultados = dao.listarTodasOsQuestoes();
		return resultados;
	}
	
}
