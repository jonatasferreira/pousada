package br.com.pousada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ConsumoQuarto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Aluga aluguel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ItensQuartoCategoria itensQuarto;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the aluguel
	 */
	public Aluga getAluguel() {
		return aluguel;
	}

	/**
	 * @param aluguel the aluguel to set
	 */
	public void setAluguel(Aluga aluguel) {
		this.aluguel = aluguel;
	}

	/**
	 * @return the itensQuarto
	 */
	public ItensQuartoCategoria getItensQuarto() {
		return itensQuarto;
	}

	/**
	 * @param itensQuarto the itensQuarto to set
	 */
	public void setItensQuarto(ItensQuartoCategoria itensQuarto) {
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
		ConsumoQuarto other = (ConsumoQuarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
