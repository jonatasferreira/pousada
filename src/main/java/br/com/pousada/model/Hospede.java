package br.com.pousada.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hospede {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Date dataEntrada;
	
	@Column(nullable = false)
	private Date dataSaida;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Aluga aluguel;


	/**
	 * @return the dataEntrada
	 */
	public Date getDataEntrada() {
		return dataEntrada;
	}

	/**
	 * @param dataEntrada the dataEntrada to set
	 */
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	/**
	 * @return the dataSaida
	 */
	public Date getDataSaida() {
		return dataSaida;
	}

	/**
	 * @param dataSaida the dataSaida to set
	 */
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Hospede other = (Hospede) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
