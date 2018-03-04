package br.com.tcc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.tcc.conexao.ConexaoBD;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		new ConexaoBD();
		Connection connection = ConexaoBD.conexao();
		System.out.println("Conexão aberta!");
		connection.close();
	}
}