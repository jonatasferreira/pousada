package br.com.pousada.junit;

import org.junit.Test;

import br.com.pousada.util.HibernateUtil;

/**
 * @author Jonatas
 * Gera Tabelas
 */
public class GeraTabela {

	@Test
	public void test() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
