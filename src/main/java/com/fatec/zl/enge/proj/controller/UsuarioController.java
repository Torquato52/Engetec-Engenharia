package com.fatec.zl.enge.proj.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.zl.enge.proj.entity.Artigo.Artigo;
import com.fatec.zl.enge.proj.entity.Artigo.ArtigoRepository;
import com.fatec.zl.enge.proj.entity.Artigo.DadosCadastroArtigo;
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
    private ArtigoRepository artigoRepository;
	@Autowired
	private LoginController ver;
	@Autowired
	private HttpSession session;

	@RequestMapping
	public ModelAndView loginTela() {
		return new ModelAndView("login.html");
	}
	
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String logins(@RequestParam("email") String email, @RequestParam String senha, HttpSession session) {
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

	@RequestMapping("/revisor")
	public ModelAndView telaRevisor() {
		return new ModelAndView("revisor.html");
	}

	@RequestMapping("/organizador")
	public ModelAndView telaOrganizador() {
		return new ModelAndView("organizador.html");
	}

	@RequestMapping("/artigo")
    public ModelAndView CadasArtigo() {
		return new ModelAndView("cadastroArtigo.html");
	}

	@PostMapping("/cadastroArtigo")
	@Transactional
	public String cadastrarArtig(@Valid DadosCadastroArtigo dadoArtigo, HttpSession session) {
		Optional<Usuario> user = (Optional<Usuario>) session.getAttribute("tipoLogin");
		//Optional<Usuario> s = usuarioRepository.Email(user.getEmail());

		Artigo art = new Artigo(dadoArtigo);
		
		art.setFk_id(user.get());
		artigoRepository.save(art);
		return "redirect:/"; 
	}

	//	@RequestMapping("/listagem")
	//	public String carregaListagem (Model model){
	//		model.addAtribute("lista", 
	//		repository.findAll());
	//}
}