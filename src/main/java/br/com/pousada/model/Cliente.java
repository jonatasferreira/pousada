package br.com.pousada.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@Entity
@NamedQueries({
	@NamedQuery(name = "Cliente.listar", query = "SELECT cliente FROM Cliente cliente")
})
public class Cliente extends Pessoa {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long codigo;

	@Column(nullable = false)
	private Date dataCadastro;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Collection<Hospede> hospedagens;
	
	@OneToMany(mappedBy = "contratante", cascade = CascadeType.ALL)
	private Collection<Aluga> alugueis;

//	/**
//	 * @return the codigo
//	 */
//	public Long getCodigo() {
//		return codigo;
//	}
//
//	/**
//	 * @param codigo the codigo to set
//	 */
//	public void setCodigo(Long codigo) {
//		this.codigo = codigo;
//	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the hospedagens
	 */
	public Collection<Hospede> getHospedagens() {
		return hospedagens;
	}

	/**
	 * @param hospedagens the hospedagens to set
	 */
	public void setHospedagens(Collection<Hospede> hospedagens) {
		this.hospedagens = hospedagens;
	}

	/**
	 * @return the alugueis
	 */
	public Collection<Aluga> getAlugueis() {
		return alugueis;
	}

	/**
	 * @param alugueis the alugueis to set
	 */
	public void setAlugueis(Collection<Aluga> alugueis) {
		this.alugueis = alugueis;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getCpf() == null) ? 0 : this.getCpf().hashCode());
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
		Cliente other = (Cliente) obj;
		if (this.getCpf() == null) {
			if (other.getCpf() != null)
				return false;
		} else if (!this.getCpf().equals(other.getCpf()))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [nome="+this.getNome()+", cpf="+this.getCpf()+", dataCadastro=" + dataCadastro + "]";
	}
	
	
}
