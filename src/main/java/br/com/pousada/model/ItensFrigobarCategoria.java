package br.com.pousada.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ItensFrigobarCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@OneToMany(mappedBy = "itensFrigobar", cascade = CascadeType.ALL)
	private Collection<ConsumoFrigobar> listaConsumoFrigobar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ItensFrigobar itensFrigobar;



	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the listaConsumoFrigobar
	 */
	public Collection<ConsumoFrigobar> getListaConsumoFrigobar() {
		return listaConsumoFrigobar;
	}

	/**
	 * @param listaConsumoFrigobar the listaConsumoFrigobar to set
	 */
	public void setListaConsumoFrigobar(Collection<ConsumoFrigobar> listaConsumoFrigobar) {
		this.listaConsumoFrigobar = listaConsumoFrigobar;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the itensFrigobar
	 */
	public ItensFrigobar getItensFrigobar() {
		return itensFrigobar;
	}

	/**
	 * @param itensFrigobar the itensFrigobar to set
	 */
	public void setItensFrigobar(ItensFrigobar itensFrigobar) {
		this.itensFrigobar = itensFrigobar;
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
		ItensFrigobarCategoria other = (ItensFrigobarCategoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
