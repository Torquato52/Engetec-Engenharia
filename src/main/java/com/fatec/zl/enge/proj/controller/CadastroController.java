package com.fatec.zl.enge.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.zl.enge.proj.entity.Usuario.DadosCadastroUsuario;
import com.fatec.zl.enge.proj.entity.Usuario.Usuario;
import com.fatec.zl.enge.proj.entity.Usuario.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
public class CadastroController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/cadastro")
	public ModelAndView cadastro() {
		return new ModelAndView("cadastro.html");
	}

	@PostMapping("/cadastrar")
	@Transactional
	public String cadastra(@Valid DadosCadastroUsuario dados) {
        usuarioRepository.save(new Usuario(dados));
		return "redirect:/"; 
	}

	@RequestMapping("/orgcadastro")
	public ModelAndView cadastroOrganiza() {
		return new ModelAndView("cadastroOrganizador.html");
	}
}