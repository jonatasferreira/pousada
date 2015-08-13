package br.com.pousada.bean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pousada.dao.ClienteDAO;
import br.com.pousada.model.Cliente;
import br.com.pousada.model.Endereco;
import br.com.pousada.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {
	private Cliente cliente;
	private List<Cliente> listaCliente;
	private List<Cliente> listaClienteFiltrados;

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public List<Cliente> getListaClienteFiltrados() {
		return listaClienteFiltrados;
	}
	
	public void setListaClienteFiltrados(List<Cliente> listaClienteFiltrados) {
		this.listaClienteFiltrados = listaClienteFiltrados;
	}
	
	public Cliente getCliente() {
		if (cliente == null) {
			this.novo();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void salvar() {
		try {
			// TODO: Adicionar teste correto para cpf e email valido
			if(testCadastro()){
				ClienteDAO dao = new ClienteDAO();
				// TODO: adicionar cadastro de endereço na interface do usuario
				Endereco end = new Endereco();
				end.setRua("Rua 20");
				end.setNumero(455);
				end.setBairro("Aeroporto");
				end.setCidade("Teresina");
				end.setUf("PI");
				cliente.setEndereco(end);
				dao.salvar(cliente);
				this.novo();
				FacesUtil.addMsgInfo("Cliente salvo com sucesso!");
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgInfo("Error "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir(String cpf) {
		Cliente cli;
		try {
			if (cpf != null) {
				ClienteDAO dao = new ClienteDAO();
				cli = dao.buscarPorCodigo(cpf);
				dao.excluir(cli);
				FacesUtil.addMsgInfo("Cliente removido com sucesso.");
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgInfo("Error "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.editar(cliente);
			FacesUtil.addMsgInfo("Cliente editado com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgInfo("Error "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void listarDadosBanco(){
		try {
			ClienteDAO dao = new ClienteDAO();
			listaCliente = dao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgInfo("Error "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void lerClienteBanco(){
		try {
			String valor = FacesUtil.getParam("cod");
			if (valor != null) {
				ClienteDAO dao = new ClienteDAO();
				cliente = dao.buscarPorCodigo(valor);
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgInfo("Error "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void novo(){
		cliente = new Cliente();
		cliente.setDataCadastro(new Date());
	}
	
	private boolean testCadastro(){
		if(cliente.getCpf().length() < 11){
			FacesUtil.addMsgInfo("Digite os 11 digitos do cpf!");
			return false;
		}
		if(cliente.getNome().length() < 1){
			FacesUtil.addMsgInfo("Verifique o nome!");
			return false;
		}
		return true;
	}
}
