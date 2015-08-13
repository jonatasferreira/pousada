package br.com.pousada.model;

import java.util.Collection;
import java.util.Date;

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
public class Aluga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Date dataReserva;
	
	@Column(nullable = false)
	private Integer numDiarias;
	
	@Column(precision = 2)
	private Double valorTotalQuarto;
	
	@Column(precision = 2)
	private Double valorTotalConsumo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente contratante;
	
	@OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL)
	private Collection<Hospede> hospedes;
	
	@OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL)
	private Collection<ConsumoQuarto> consumoQuarto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quarto quarto;
	
	@OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL)
	private Collection<ConsumoFrigobar> consumoFrigobar;



	/**
	 * @return the dataReserva
	 */
	public Date getDataReserva() {
		return dataReserva;
	}

	/**
	 * @param dataReserva the dataReserva to set
	 */
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	/**
	 * @return the numDiarias
	 */
	public Integer getNumDiarias() {
		return numDiarias;
	}

	/**
	 * @param numDiarias the numDiarias to set
	 */
	public void setNumDiarias(Integer numDiarias) {
		this.numDiarias = numDiarias;
	}

	/**
	 * @return the valorTotalQuarto
	 */
	public Double getValorTotalQuarto() {
		return valorTotalQuarto;
	}

	/**
	 * @param valorTotalQuarto the valorTotalQuarto to set
	 */
	public void setValorTotalQuarto(Double valorTotalQuarto) {
		this.valorTotalQuarto = valorTotalQuarto;
	}

	/**
	 * @return the valorTotalConsumo
	 */
	public Double getValorTotalConsumo() {
		return valorTotalConsumo;
	}

	/**
	 * @param valorTotalConsumo the valorTotalConsumo to set
	 */
	public void setValorTotalConsumo(Double valorTotalConsumo) {
		this.valorTotalConsumo = valorTotalConsumo;
	}

	/**
	 * @return the contratante
	 */
	public Cliente getContratante() {
		return contratante;
	}

	/**
	 * @param contratante the contratante to set
	 */
	public void setContratante(Cliente contratante) {
		this.contratante = contratante;
	}

	/**
	 * @return the hospedes
	 */
	public Collection<Hospede> getHospedes() {
		return hospedes;
	}

	/**
	 * @param hospedes the hospedes to set
	 */
	public void setHospedes(Collection<Hospede> hospedes) {
		this.hospedes = hospedes;
	}

	/**
	 * @return the consumoQuarto
	 */
	public Collection<ConsumoQuarto> getConsumoQuarto() {
		return consumoQuarto;
	}

	/**
	 * @param consumoQuarto the consumoQuarto to set
	 */
	public void setConsumoQuarto(Collection<ConsumoQuarto> consumoQuarto) {
		this.consumoQuarto = consumoQuarto;
	}

	/**
	 * @return the quarto
	 */
	public Quarto getQuarto() {
		return quarto;
	}

	/**
	 * @param quarto the quarto to set
	 */
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	/**
	 * @return the consumoFrigobar
	 */
	public Collection<ConsumoFrigobar> getConsumoFrigobar() {
		return consumoFrigobar;
	}

	/**
	 * @param consumoFrigobar the consumoFrigobar to set
	 */
	public void setConsumoFrigobar(Collection<ConsumoFrigobar> consumoFrigobar) {
		this.consumoFrigobar = consumoFrigobar;
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
		Aluga other = (Aluga) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}




