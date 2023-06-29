package com.gerenciadordefuncionarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Funcionario {
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
		

	@NotBlank(message = "O nome do funcionario deve ser preenchido")// Avisa sobre o null
	@Size (min= 3, max = 75)
	private String nome;
	
	private String email;
	private String cargo;
	private String urlImagem;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome; 
	
	}
		
	public String getEmail() {
		return email;
	
	}
		
	public void setEmail(String email) {
		this.email = email;
	}
		
		
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
 

}
	