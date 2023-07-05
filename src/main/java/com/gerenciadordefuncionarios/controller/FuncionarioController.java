package com.gerenciadordefuncionarios.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	@GetMapping("/adicionarfuncionario")
	public String adicionarFuncionario(Funcionario funcionario) {
		return "adicionar_funcionario";
	}
	
	@PostMapping("/addfuncionario")
	public String adicionaFuncionario(@Valid Funcionario funcionario
			, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/adicionar_funcionario";
		}
		FuncionarioRepository.save(funcionario);
		return "redirect:/Funcionario";
	}
	
	
					 
	@GetMapping("/editar/{id}")
	public String mostrarFormularioAtualizacao(
	@PathVariable("id") long id, Model model) {
		
		Funcionario funcionario = FuncionarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificador não é válido" + id));
				model.addAttribute("funcionario", funcionario);
		return "editar_funcionario";
	}
	
	
	
	@PostMapping("/atualizar/{id}")
	public String atualizaFuncionario(@PathVariable("id")
		long id, @Valid Funcionario funcionario
		, BindingResult result, Model model
			) {
		if(result.hasErrors()) {
			funcionario.setId(id);
			return "editar_funcionario";
		}
		FuncionarioRepository.save(funcionario);
		return "redirect:/Funcionario";
	}
	
	
	
	
	
	@GetMapping("/delete/{id}")
	public String deletarFuncionario(@PathVariable("id") long id, Model model) {
		Funcionario funcionario = FuncionarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificador não é válido" + id));
				FuncionarioRepository.delete(funcionario);
		return "redirect:/Funcionario";
	}
		

}
