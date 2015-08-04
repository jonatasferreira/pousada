/**
 * 
 */
package br.com.pousada.junit;


import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.pousada.dao.ClienteDAO;
import br.com.pousada.model.Cliente;
import br.com.pousada.model.Endereco;

/**
 * @author Jonatas
 *
 */
public class TesteClienteDAO {
	
	
	@Test
	public void listar(){
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.listar();
		for(Cliente cliente : clientes){
			System.out.println(cliente.toString());
		}
	}
	
	@Test
	@Ignore
	public void salvar(){
		Endereco endereco = new Endereco();
		Cliente cliente = new Cliente();
		
		cliente.setCpf("12345678900");
		cliente.setDataCadastro(new Date());
		cliente.setEmail("rh@pousada.com.br");
		cliente.setNome("Pousada");
		endereco.setRua("Rua 10");
		endereco.setNumero(100);
		endereco.setBairro("Dirceu");
		endereco.setCidade("Teresina");
		endereco.setUf("PI");
		cliente.setEndereco(endereco);
		
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);
	}

}
