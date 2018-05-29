package br.com.model.services;

import java.util.ArrayList;
import java.util.List;

import br.com.model.entities.Cliente;
import br.com.model.repositories.ClienteRepository;

/**	Regra de negócio
  *	Criado para ser consumido pelo Controller e/ou Rest,JASON, etc...
 */
public class ClienteService {
	
	private final ClienteRepository clienteRepository = new ClienteRepository();
	
	//Método criado para aprender Foreach
	public List<Cliente> getAllClientesWithFOR() {
		List<Cliente> listCliente = new ArrayList<Cliente>();
		List<Cliente> resultList = clienteRepository.allClients();
		for (Cliente cliente : resultList) {
			listCliente.add(cliente);
		}
		return listCliente;
	}
	
	//Retorna todos os Clientes
	public List<Cliente> getAllClientes() {
		return clienteRepository.allClients();
	}
	
	
	public void cadastrar(Cliente cliente) throws Exception {
		Cliente clienteEntity = new Cliente();
		try {
			if (cliente != null && !cliente.getNome().isEmpty() && !cliente.getEmail().isEmpty()
					&& !cliente.getSenha().isEmpty()) {

				clienteEntity.setNome(cliente.getNome());
				clienteEntity.setEmail(cliente.getEmail());
				if (cliente.getSenha().length() <= 6) {
					clienteEntity.setSenha(cliente.getSenha());
				} 
				clienteRepository.Salvar(clienteEntity);
			}
		} catch (Exception ex) {
			throw new Exception("Bad Request");
		}
	}
		
}
