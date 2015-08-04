package br.com.pousada.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Funcionario extends Pessoa {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long codigo;
	
	@Column(nullable = false)
	private Date dataAdmicao;
	
	@Column(nullable = false, precision = 2)
	private Double salario;
	
	@Enumerated(EnumType.ORDINAL)
	private Funcao funcao;

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
	 * @return the dataAdmicao
	 */
	public Date getDataAdmicao() {
		return dataAdmicao;
	}

	/**
	 * @param dataAdmicao the dataAdmicao to set
	 */
	public void setDataAdmicao(Date dataAdmicao) {
		this.dataAdmicao = dataAdmicao;
	}

	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	/**
	 * @return the funcao
	 */
	public Funcao getFuncao() {
		return funcao;
	}

	/**
	 * @param funcao the funcao to set
	 */
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
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
		Funcionario other = (Funcionario) obj;
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
		return "Funcionario [nome="+this.getNome()+", cpf="+this.getCpf()+", salario=" + salario + "]";
	}
}
