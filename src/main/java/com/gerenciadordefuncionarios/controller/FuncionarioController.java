package com.gerenciadordefuncionarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gerenciadordefuncionarios.repository.FuncionarioRepository;
import com.gerenciadordefuncionarios.model.Funcionario;



@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository FuncionarioRepository;
	
	@GetMapping("/")
	public String GerenciadordeFuncionarios() {
	return "index.html";
	}
	
		
	@GetMapping("/Funcionario")
	public String listaFuncionario(Model model) {
				
	List<Funcionario> Funcionario = FuncionarioRepository.findAll();
	model.addAttribute("funcionario", Funcionario);
	return "funcionario";
	}

}
