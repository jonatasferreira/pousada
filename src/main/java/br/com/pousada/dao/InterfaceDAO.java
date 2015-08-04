package br.com.pousada.dao;

public interface InterfaceDAO<T> {
	void salvar(T entidade);
	void atualizar(T entidade);
	void remover(T entidade);
}
