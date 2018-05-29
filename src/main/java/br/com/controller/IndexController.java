package br.com.controller;

import java.util.List;
import br.com.model.entities.Cliente;
import br.com.model.services.ClienteService;

/**	Para cada Página Local que eu tiver, criar um Controller, 
  *	caso contrário, utilizar o Service para consumo
 */ 
public class IndexController {
	
	ClienteService clienteService = new ClienteService();
	
	public List<Cliente> getAllClientes(){
		return clienteService.getAllClientes();
	}

}
