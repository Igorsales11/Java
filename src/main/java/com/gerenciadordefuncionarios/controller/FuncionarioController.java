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
	public String paginaInicial() {
	return "index.html";
	}
	
		
	@GetMapping("/Funcionario")
	public String ListarFuncionarios(Model model) {
		List<Funcionario> funcionarios = FuncionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		
		return "Funcionario";
	}
	
	

}
