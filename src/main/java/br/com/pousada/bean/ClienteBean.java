package br.com.pousada.bean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pousada.dao.ClienteDAO;
import br.com.pousada.model.Cliente;
import br.com.pousada.model.Endereco;
import br.com.pousada.util.FacesUtil;

/**
 * @author Jonatas
 * Classe managedBean clientes
 */
@ManagedBean
@ViewScoped
public class ClienteBean {
	private Cliente cliente;
	private List<Cliente> listaCliente;
	private List<Cliente> listaClienteFiltrados;

	/**
	 * Retorna lista de cliente recuperados da base de dados ou da view 
	 * @return Lista de clientes
	 */
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	/**
	 * Set lista de clientes
	 * @param listaCliente
	 */
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	/**
	 * Retorna a lista de clientes aplicada um filtro especifico.
	 * @return lista filtrada
	 */
	public List<Cliente> getListaClienteFiltrados() {
		return listaClienteFiltrados;
	}
	
	/**
	 * Set lista de clientes com um filtro especifico
	 * @param listaClienteFiltrados
	 */
	public void setListaClienteFiltrados(List<Cliente> listaClienteFiltrados) {
		this.listaClienteFiltrados = listaClienteFiltrados;
	}
	
	/**
	 * Retorna um cliente
	 * @return Um cliente
	 */
	public Cliente getCliente() {
		if (cliente == null) {
			this.novo();
		}
		return cliente;
	}

	/**
	 * Set o cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Salvar um cliente na base de dados
	 */
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
	
	/**
	 * Exclui um cliente da base de dados
	 * @param cpf
	 */
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
	
	/**
	 * Edita na base de dados o cliente refereciado no atributo cliente
	 */
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
	
	/**
	 * Lista todos os cliente da base de dados
	 */
	public void listarDadosBanco(){
		try {
			ClienteDAO dao = new ClienteDAO();
			listaCliente = dao.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgInfo("Error "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Busca um cliente na base de dados
	 */
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
	
	/**
	 * Inicializa com o novo objeto o atributo cliente
	 */
	public void novo(){
		cliente = new Cliente();
		cliente.setDataCadastro(new Date());
	}
	
	/**
	 * Metodo simples para verificar entrada de cpf e nome
	 * @return
	 */
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
