package br.com.pousada.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pousada.dao.ClienteDAO;
import br.com.pousada.model.Cliente;
import br.com.pousada.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {
	private Cliente cliente;

	public Cliente getCliente() {
		if (cliente == null) {
			this.cliente = new Cliente();
			cliente.setDataCadastro(new Date());
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void salvar() {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			FacesUtil.addMsgInfo("Cliente salvo com sucesso!");
		} catch (Exception e) {
			FacesUtil.addMsgInfo("Error "+e.getMessage());
		}
	}
}
