package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.conexao.ConexaoBD;
import br.com.tcc.modelo.Alternativas;
import br.com.tcc.modelo.Enunciado;
import br.com.tcc.modelo.Gabarito;
import br.com.tcc.modelo.Jogador;
import br.com.tcc.modelo.Niveis;
import br.com.tcc.modelo.Questoes;

public class CadastroDePerguntasDao {

	public CadastroDePerguntasDao(){

	}

	public int cadastrarPergunta(Enunciado enunciado){
		if (enunciado == null || enunciado.getNiveis() == null) {
			throw new IllegalArgumentException("Ou você está tentando persistir NULL ou então está faltando alguma dependência no enunciado.");
		}
		Connection connection = ConexaoBD.conexao();
		int id = 0;

		final String INSERIR_ENUNCIADO = "INSERT INTO enunciado(enunciado, idNiveis) VALUES (?, ?);";

		try {

			System.out.println("To aqui!");

			PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_ENUNCIADO, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, enunciado.getEnunciado());
			preparedStatement.setInt(2, enunciado.getNiveis().getId());

			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			while(resultSet.next()){
				id = resultSet.getInt(1);
			}
		} catch (SQLException ex) {

		}

		System.out.println("idEnunciado: "  + id);
		return id;

	}

	public int cadastrarGabarito(Gabarito umGabarito){
		Connection connection = ConexaoBD.conexao();
		int id = 0;

		final String INSERIR_GABARITO = "INSERT INTO gabarito(gabarito) VALUES (?);";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_GABARITO, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, umGabarito.getGabarito());
			id = preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			while(resultSet.next()){
				id = resultSet.getInt(1);

			}

		}catch(SQLException ex){
			ex.printStackTrace();
		}

		System.out.println("idGabarito: " + id);
		return id;
	}

	public int cadastrarAlternativas(Alternativas alternativas){
		Connection connection = ConexaoBD.conexao();
		final String INSERIR_ALTERNATIVAS= "INSERT INTO alternativas (alternativaA, alternativaB, alternativaC, alternativaD, "
				+ "idEnunciado, idGabarito) VALUES (?,?,?,?,?,?);";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_ALTERNATIVAS, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, alternativas.getAlternativa());
			preparedStatement.setString(2, alternativas.getAlternativaB());
			preparedStatement.setString(3, alternativas.getAlternativaC());
			preparedStatement.setString(4, alternativas.getAlternativaD());
			preparedStatement.setInt(5, alternativas.getEnunciado().getId());
			preparedStatement.setInt(6, alternativas.getGabarito().getId());

			preparedStatement.executeUpdate();

			ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
			while (chavesGeradas.next()) {
				int idGerado = chavesGeradas.getInt(1);
				return idGerado;
			}

		}catch(SQLException EX){

		}

		return -1;

	}

	public int cadastrarUmNivel(Niveis nivel) {
		if (nivel == null || nivel.getNivel() == null) {
			throw new IllegalArgumentException("Ou você está tentando persistir NULL ou então está faltando alguma dependência no nível.");
		}
		Connection connection = ConexaoBD.conexao();
		int id = 0;

		final String INSERIR_NIVEL = "INSERT INTO niveis(niveis) VALUES (?);";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_NIVEL, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nivel.getNivel());

			id = preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			while(resultSet.next()){
				id = resultSet.getInt(1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		System.out.println("idNivel: " + id);
		return id;

	}

	public int cadastrarUmJogador(Jogador jogador){
		if (jogador == null) {
			throw new IllegalArgumentException(
					"Ou voc� est� tentando persistir NULL ou ent�o est� faltando alguma depend�ncia.");
		}

		Connection connection = ConexaoBD.conexao();
		final String CADASTRAR_USUARIO = "INSERT INTO jogador (login, senha, nome, email) values (?,?,?,?)";


		try {

			PreparedStatement preparedStatement = connection.prepareStatement(CADASTRAR_USUARIO,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, jogador.getLogin());
			preparedStatement.setString(2, jogador.getSenha());
			preparedStatement.setString(3, jogador.getNome());
			preparedStatement.setString(4, jogador.getEmail());

			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();


			if(rs.next()){
				return rs.getInt(1);

			}
			System.out.println("Cadastrado com sucesso!");


		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;

	}

	public ArrayList<Questoes> listarTodasAsQuestoes(){
		ArrayList<Questoes> resultados = new ArrayList<Questoes>();
		Questoes questoes = new Questoes();
		Connection connection = ConexaoBD.conexao();
		final String PESQUISAR_QUESTOES = "SELECT * FROM Questoes;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(PESQUISAR_QUESTOES);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				Questoes e = new Questoes();
				e.setEnunciado(resultSet.getString(2));
				e.setAlternativaA(resultSet.getString(3));
				e.setAlternativaB(resultSet.getString(4));
				e.setAlternativaC(resultSet.getString(5));
				e.setAlternativaD(resultSet.getString(6));
				e.setGabarito(resultSet.getString(7));
				e.setNivel(resultSet.getString(8));
				resultados.add(e);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultados;

	}
	
	public List<Questoes> listarTodasOsQuestoes(){
		
		List<Questoes> resultados = new ArrayList<Questoes>();
		
		Connection connection = ConexaoBD.conexao();
		final String TODAS_AS_QUESTOES = "SELECT * FROM Questoes;";
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(TODAS_AS_QUESTOES);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				Questoes e = new Questoes();
				
				e.setId(resultSet.getInt(1));
				e.setEnunciado(resultSet.getString(2));
				e.setAlternativaA(resultSet.getString(3));
				e.setAlternativaB(resultSet.getString(4));
				e.setAlternativaC(resultSet.getString(5));
				e.setAlternativaD(resultSet.getString(6));
				e.setGabarito(resultSet.getString(7));
				e.setNivel(resultSet.getString(8));
				resultados.add(e);	
			}
			
			System.out.println(resultados);


		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultados;
		

		 
	}
	
	public List<Jogador> gerarRanking(){
		List<Jogador> resultados = new ArrayList<Jogador>();
		Connection connection = ConexaoBD.conexao();
		final String PESQUISAR_JOGADORES = "SELECT nome,pontos FROM jogador ORDER BY pontos desc;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(PESQUISAR_JOGADORES );
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				Jogador j = new Jogador();

				j.setNome(resultSet.getString("nome"));
				j.setPontos(resultSet.getInt("pontos"));

				resultados.add(j);	
			}
			
			System.out.println(resultados);


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultados;
		

		 
	}
	
	public int cadastrarQuestoes(Questoes questoes){
		Connection connection = ConexaoBD.conexao();
		final String INSERIR_ALTERNATIVAS= "INSERT INTO Questoes(enunciado, alternativaA, alternativaB, alternativaC, alternativaD, gabarito, nivel) VALUES (?,?,?,?,?,?,?);";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_ALTERNATIVAS, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, questoes.getEnunciado());
			preparedStatement.setString(2, questoes.getAlternativaA());
			preparedStatement.setString(3, questoes.getAlternativaB());
			preparedStatement.setString(4, questoes.getAlternativaC());
			preparedStatement.setString(5, questoes.getAlternativaD());
			preparedStatement.setString(6, questoes.getGabarito());
			preparedStatement.setString(7, questoes.getNivel());

			preparedStatement.executeUpdate();

			ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();
			while (chavesGeradas.next()) {
				int idGerado = chavesGeradas.getInt(1);
				return idGerado;
			}

		}catch(SQLException EX){

		}

		return -1;

	}

}