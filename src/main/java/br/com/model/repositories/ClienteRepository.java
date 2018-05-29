package br.com.model.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.model.entities.Cliente;

//Faz a persistência no Banco de Dados
public class ClienteRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public ClienteRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("postgres_persistence");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(Cliente cliente){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(cliente);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(Cliente cliente){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(cliente);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * RETORNA TODAS AS PESSOAS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<Cliente> allClients(){
 
		//return this.entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.name").getResultList();
		return this.entityManager.createNamedQuery(Cliente.findAll, Cliente.class).getResultList();
	}
 
	/**
	 * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	 * */
	public Cliente getCliente(Long id){
 
		return this.entityManager.find(Cliente.class, id);
	}
 
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Long id){
 
		Cliente cliente = this.getCliente(id);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(cliente);
		this.entityManager.getTransaction().commit();
 
	}
	
	
}
