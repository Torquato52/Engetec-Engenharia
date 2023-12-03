package com.fatec.zl.enge.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.fatec.zl.enge.proj.entity.Usuario.DadosCadastroUsuario;
import com.fatec.zl.enge.proj.entity.Usuario.Usuario;
import com.fatec.zl.enge.proj.entity.Usuario.UsuarioRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	@Autowired
	private LoginController ver; 
	private HttpSession session;

	@GetMapping
	public ModelAndView loginTela() {
		return new ModelAndView("login.html");
	}

	@PostMapping("/login")
    public String logins(@RequestParam String email, @RequestParam String senha) {
        return ver.login(email, senha, session);
    }

	@RequestMapping("/professor")
    public ModelAndView professor() {
		return new ModelAndView("professor.html");
	}

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

	@DeleteMapping
	@Transactional
	public String removeOrganizador (Long id) {
		usuarioRepository.deleteById (id);
		return "redirect:organizador";  
	}

	//	@RequestMapping("/listagem")
	//	public String carregaListagem (Model model){
	//		model.addAtribute("lista", 
	//		repository.findAll());
	//}
}