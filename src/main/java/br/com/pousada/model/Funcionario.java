package br.com.pousada.model;

import java.text.SimpleDateFormat;
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
	private Date dataAdmissao;
	
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
	 * @return the dataAdmissao
	 */
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	/**
	 * @param dataAdmissao the dataAdmissao to set
	 */
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
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
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Funcionario [nome=");
		stringBuilder.append(this.getNome());
		stringBuilder.append("\n");
		stringBuilder.append(", cpf=");
		stringBuilder.append(this.getCpf());
		stringBuilder.append("\n");
		stringBuilder.append(", email=");
		stringBuilder.append(this.getEmail());
		stringBuilder.append("\n");
		stringBuilder.append(", salario=");
		stringBuilder.append(this.getSalario());
		stringBuilder.append("\n");
		stringBuilder.append(", funcao=");
		stringBuilder.append(this.getFuncao().name());
		stringBuilder.append("\n");
		if (dataAdmissao != null) {
			stringBuilder.append(", dataAdmissao=");
			SimpleDateFormat formatas = new SimpleDateFormat("dd/MM/yyyy");
			stringBuilder.append(formatas.format(dataAdmissao));
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
