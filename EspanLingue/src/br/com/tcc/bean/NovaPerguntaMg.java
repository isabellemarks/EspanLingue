package br.com.tcc.bean;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.tcc.dao.CadastroDePerguntasDao;
import br.com.tcc.modelo.Alternativas;
import br.com.tcc.modelo.Enunciado;
import br.com.tcc.modelo.Gabarito;
import br.com.tcc.modelo.Niveis;
import br.com.tcc.modelo.Questoes;

@ManagedBean
@ViewScoped
public class NovaPerguntaMg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NovaPerguntaMg(){

	}

	private Enunciado enunciado = new Enunciado();
	private Alternativas alternativas = new Alternativas();
	private Gabarito gabarito = new Gabarito();
	private Niveis nivel = new Niveis();
	
	private Questoes questoes = new Questoes();

	public Enunciado getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(Enunciado enunciado) {
		this.enunciado = enunciado;
	}

	public Alternativas getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Alternativas alternativas) {
		this.alternativas = alternativas;
	}

	public Gabarito getGabarito() {
		return gabarito;
	}

	public void setGabarito(Gabarito gabarito) {
		this.gabarito = gabarito;
	}

	public Niveis getNivel() {
		return nivel;
	}

	public void setNivel(Niveis nivel) {
		this.nivel = nivel;
	}


	public void cadastrarPergunta(ActionEvent actionEvent){
		CadastroDePerguntasDao cadastro = new CadastroDePerguntasDao();

		int idGabarito = cadastro.cadastrarGabarito(gabarito);
		int idNivel = cadastro.cadastrarUmNivel(nivel);

		enunciado.setNiveis(new Niveis());
		enunciado.getNiveis().setId(idNivel);
		int idEnunciado = cadastro.cadastrarPergunta(enunciado);

		alternativas.setEnunciado(enunciado);
		alternativas.setGabarito(gabarito);
		alternativas.getEnunciado().setId(idEnunciado);
		alternativas.getGabarito().setId(idGabarito);
		cadastro.cadastrarAlternativas(alternativas);
	}

	public Questoes getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}
	
	public void cadastrarQuestao(ActionEvent actionEvent){
		CadastroDePerguntasDao cadastro = new CadastroDePerguntasDao();

		//int idQuestao = 
		cadastro.cadastrarQuestoes(questoes);

		cadastro.cadastrarQuestoes(questoes);

	}

}