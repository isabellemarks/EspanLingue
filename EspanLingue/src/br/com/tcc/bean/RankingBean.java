package br.com.tcc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.tcc.dao.CadastroDePerguntasDao;
import br.com.tcc.modelo.Jogador;

@ManagedBean
public class RankingBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Jogador> resultados_jogador = new ArrayList<Jogador>();	
	
	
	public RankingBean(){
		gerarRanking();
		
			
	}


	public List<Jogador> getResultados_jogador() {
		return resultados_jogador;
	}


	public void setResultados_jogador(List<Jogador> resultados_jogador) {
		this.resultados_jogador = resultados_jogador;
	}
	
	
	public List<Jogador> gerarRanking(){
		CadastroDePerguntasDao dao = new CadastroDePerguntasDao();
		this.resultados_jogador = dao.gerarRanking();
		return resultados_jogador;
		
	}
	

}
