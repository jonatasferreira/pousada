package br.com.pousada.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pousada.model.Cliente;
import br.com.pousada.util.HibernateUtil;

public class ClienteDAO {

	/**
	 * Salvar o objeto cliente no banco de dados
	 * @param cliente
	 */
	public void salvar(Cliente cliente) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction trasacao = null;
		try{
			trasacao = sessao.beginTransaction();
			sessao.save(cliente);
			trasacao.commit();
		}catch(RuntimeException ex){
			if(trasacao != null){
				trasacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	public List<Cliente> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> clientes = null;
		try {
			Query consulta = sessao.getNamedQuery("Cliente.listar");
			clientes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return clientes;
	}
	
	public Cliente buscarPorCodigo(String cpf){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = null;
		try {
			Query consulta = sessao.getNamedQuery("Cliente.buscarPorCodigo");
			consulta.setString("cpf", cpf);
			cliente = (Cliente) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return cliente;
	}

	/**
	 * @param cliente
	 */
	public void excluir(Cliente cliente) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction trasacao = null;
		try{
			trasacao = sessao.beginTransaction();
			sessao.delete(cliente);
			trasacao.commit();
		}catch(RuntimeException ex){
			if(trasacao != null){
				trasacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}

	public void editar(Cliente cliente) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction trasacao = null;
		try{
			trasacao = sessao.beginTransaction();
			sessao.update(cliente);
			trasacao.commit();
		}catch(RuntimeException ex){
			if(trasacao != null){
				trasacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
}
