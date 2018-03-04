package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.conexao.ConexaoBD;
import br.com.tcc.modelo.Administrador;
import br.com.tcc.modelo.Jogador;

public class LoginDao {

	public LoginDao(){

	}

	public Administrador autenticacao(String login, String senha){
		Connection connection = ConexaoBD.conexao();
		final String AUTENTICAR = "Select * from Administrador where login = ? and senha=?;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(AUTENTICAR);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Administrador usuario = new Administrador();
				usuario.setId(rs.getInt(1));
				usuario.setLogin(rs.getString(2));
				usuario.setSenha(rs.getString(3));

				return usuario;

			}		

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public Jogador autenticarJogador(String login, String senha){
		Connection connection = ConexaoBD.conexao();
		final String AUTENTICAR = "Select * from jogador where login = ? and senha=?;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(AUTENTICAR);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){

				Jogador usuario = new Jogador();
				usuario.setId(rs.getInt(1));
				usuario.setLogin(rs.getString(2));
				usuario.setSenha(rs.getString(3));
				usuario.setNome(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setPontos(rs.getInt(6));

				return usuario;

			}		

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
