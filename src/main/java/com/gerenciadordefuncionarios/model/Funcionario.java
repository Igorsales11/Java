package com.gerenciadordefuncionarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
		
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
		
	public String getemail() {
		return email;
	
	}
		
	public void setemail(String email) {
		this.email = email;
	}
		
		
	public String getcargo() {
		return cargo;
	}
	public void setcargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
 

}
	
