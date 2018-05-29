package br.com.http;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.model.entities.Cliente;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ClienteWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement
	private Integer id;
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String email;
	
	@XmlElement
	private String password;
	
	public ClienteWS(Cliente cliente){
		this.id = cliente.getId();
		this.name = cliente.getNome();
		this.email = cliente.getEmail();
		this.password = cliente.getSenha();
	}

	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
