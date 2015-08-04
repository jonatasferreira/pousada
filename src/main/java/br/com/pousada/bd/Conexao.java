package br.com.pousada.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jonatas
 * Testa conexao com Java SQL Connection
 */
public class Conexao {
	public static Connection connection() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/pousadabd";
		String user = "userpousada";
		String password = "123456";
		Connection connection  = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	
}
