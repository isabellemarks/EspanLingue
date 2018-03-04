package br.com.tcc.conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {

	public static Connection connection;

	public static Connection conexao() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
			}
			if (ConexaoBD.connection == null) {
				ConexaoBD.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TCC", "root", "root");
				//ConexaoBD.connection = DriverManager.getConnection("jdbc:mysql://10.225.2.202/DB_20121164010317", "20121164010317", "ester24");
				//ConexaoBD.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_20121164010317", "estefanialinss", "ester2424");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados\n Error:" + e.getMessage());
		}
		return ConexaoBD.connection;
	}

}
