package br.com.pousada.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pousada.model.Funcao;
import br.com.pousada.model.Funcionario;
import br.com.pousada.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionario;
	private Date dateAdmissao;
	private Funcao func;

	public Funcao getFunc() {
		if (func == null) {
			func = Funcao.Camareira;
		}
		return func;
	}

	public void setFunc(Funcao func) {
		this.func = func;
		if (funcionario != null) {
			this.funcionario.setFuncao(func);
		}
	}

	public Date getDateAdmissao() {
		if (dateAdmissao == null) {
			dateAdmissao = new Date();
		}
		return dateAdmissao;
	}

	public void setDateAdmissao(Date dateAdm) {
		this.dateAdmissao = dateAdm;
		if (funcionario != null) {
			funcionario.setDataAdmissao(dateAdm);
			;
		}
	}

	public Funcionario getFuncionario() {
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcao> listaFuncao() {
		List<Funcao> lista = new ArrayList<>();
		for (Funcao f : Funcao.values()) {
			lista.add(f);
		}
		return lista;
	}

	public void salvar() {
		if (funcionario.getFuncao() == null) {
			funcionario.setFuncao(Funcao.Atendente);
			FacesUtil.addMsgInfo("Funcionário sem função");
		}

		try {
			funcionario = new Funcionario();
			FacesUtil.addMsgInfo("Funcionário salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgInfo("Error " + e.getMessage());
		}
	}
	
	public void novo(){
		funcionario = new Funcionario();
	}
}
