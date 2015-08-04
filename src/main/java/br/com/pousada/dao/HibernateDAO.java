package br.com.pousada.dao;

import java.io.Serializable;

import org.hibernate.Session;

public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Class<T> classes;
	private Session session;

	public HibernateDAO(Class<T> classes, Session session) {
		super();
		//this.classes = classes;
		this.session = session;
	}

	@Override
	public void salvar(T entidade) {
		session.save(entidade);
		
	}

	@Override
	public void atualizar(T entidade) {
		session.update(entidade);
		
	}

	@Override
	public void remover(T entidade) {
		session.delete(entidade);
	}

}
