package com.gerenciadordefuncionarios.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
public class Funcionario {
			
	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
		

	@NotBlank(message = "O nome do funcionario deve ser preenchido")
	@Size (min= 3, max = 75)
	private String nome;
	
	private String email;
	private String cargo;
	private String urlImagem;
	
}
	