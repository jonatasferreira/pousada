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
public class ItensQuartoCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	
	@OneToMany(mappedBy = "itensQuarto", cascade = CascadeType.ALL)
	private Collection<ConsumoQuarto> listaConsumoQuarto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ItensQuarto itensQuarto;


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
	 * @return the listaConsumoQuarto
	 */
	public Collection<ConsumoQuarto> getListaConsumoQuarto() {
		return listaConsumoQuarto;
	}

	/**
	 * @param listaConsumoQuarto the listaConsumoQuarto to set
	 */
	public void setListaConsumoQuarto(Collection<ConsumoQuarto> listaConsumoQuarto) {
		this.listaConsumoQuarto = listaConsumoQuarto;
	}

	/**
	 * @return the itensQuarto
	 */
	public ItensQuarto getItensQuarto() {
		return itensQuarto;
	}

	/**
	 * @param itensQuarto the itensQuarto to set
	 */
	public void setItensQuarto(ItensQuarto itensQuarto) {
		this.itensQuarto = itensQuarto;
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
		ItensQuartoCategoria other = (ItensQuartoCategoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
