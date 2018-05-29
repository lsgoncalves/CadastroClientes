package br.com.uApp;

import java.util.ArrayList;
import java.util.List;

import br.com.model.entities.Cliente;
import br.com.model.repositories.ClienteRepository;

public class App {
	
	//private final static ClienteRepository clienteRepository = new ClienteRepository();
	private final static ClienteRepository clienteRepository = new ClienteRepository();
	
	public static void main(String args[]){
		ClienteRepository clienteRepository = new ClienteRepository();
		List<Cliente> listClientes = new ArrayList<Cliente>();
		List<Cliente> resultListClients = clienteRepository.allClients();
		for (Cliente cliente : resultListClients){
			listClientes.add(cliente);
			System.out.println("listClients: " + listClientes);
		}
	
	}
}
