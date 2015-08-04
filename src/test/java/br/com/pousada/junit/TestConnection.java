package br.com.pousada.junit;


import java.sql.SQLException;

import org.junit.Test;

import br.com.pousada.bd.Conexao;

/**
 * @author Jonatas
 * Testa conexao com Java SQL Connection
 */
public class TestConnection {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Conexao.connection();
	}

}
