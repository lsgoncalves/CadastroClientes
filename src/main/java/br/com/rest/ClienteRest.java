package br.com.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.model.entities.Cliente;
import br.com.model.services.ClienteService;

@Path("/cliente")
//Chamada pelo Client(MidleWare seria o Controller)
public class ClienteRest {

	private final ClienteService clienteService = new ClienteService();
	
	@PUT
	@Produces("application/json; charset=UTF-8")
	//@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/cadastrarClientes")
	public String cadastrarCliente(Cliente cliente)
			throws Exception {
		
		try{
			clienteService.cadastrar(cliente);
			
			return "OK";
			
		} catch(Exception e) {
			throw new Exception("Bad Request");
		}
	}
	
	/*public Response cadastrarCliente(Cliente cliente)
			throws Exception {

		try{
			clienteService.cadastrar(cliente);
			return Response.ok().build();
		} catch(Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}*/
	
			
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/listarClientes")
	public List<Cliente> getListaClientes() {
		return clienteService.getAllClientes();
	}
	
	@GET
	@Produces( MediaType.TEXT_HTML )
	@Path("/listarSuccess")
	public String getSuccess() {
		return "SUCCESSSSS";
	}
}
