package br.com.pousada.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ItensFrigobar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	@Column(precision = 2, nullable = false)
	private Double valor;
	
	@OneToMany(mappedBy = "itensFrigobar", cascade = CascadeType.ALL)
	private Collection<ItensFrigobarCategoria> listaItensFrigobar;


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the listaItensFrigobar
	 */
	public Collection<ItensFrigobarCategoria> getListaItensFrigobar() {
		return listaItensFrigobar;
	}

	/**
	 * @param listaItensFrigobar the listaItensFrigobar to set
	 */
	public void setListaItensFrigobar(Collection<ItensFrigobarCategoria> listaItensFrigobar) {
		this.listaItensFrigobar = listaItensFrigobar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensFrigobar other = (ItensFrigobar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
