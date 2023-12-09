package com.fatec.zl.enge.proj.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.zl.enge.proj.entity.Usuario.Usuario;
import com.fatec.zl.enge.proj.entity.Usuario.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

	@Autowired
    private UsuarioRepository usuarioRepository;

	@Autowired
	private LoginController ver;

	@RequestMapping("/")
	public ModelAndView loginTela() {
		return new ModelAndView("login.html");
	}
	
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String logins(@RequestParam("email") String email, @RequestParam String senha, HttpSession session) {
        return ver.login(email, senha, session);
    }
	
	@GetMapping("/listaUsuario")
	public String ListaUsuario(Model model) throws Exception{
		try{
   		List<Usuario> usuarios = usuarioRepository.findAll();
    	model.addAttribute("usuarios", usuarios);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "listagem/listagemUsuarios";
	}

	
	@GetMapping("/excluirUsuario/{id}")
	public String excluirUsuario(@PathVariable("id") Long id) {
		usuarioRepository.deleteById(id);
   		return "redirect:/listaUsuario";
	}


    @PostMapping("/editarUsuario/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario existingUser = usuarioOptional.get();
            existingUser.setNome(usuario.getNome());
            existingUser.setEmail(usuario.getEmail());
            existingUser.setSenha(usuario.getSenha());
            existingUser.setInstituicao(usuario.getInstituicao());
            existingUser.setTipo(usuario.getTipo());
            usuarioRepository.save(existingUser);
		}
		return "redirect:/listarUsuarios";
    }


	@RequestMapping("/revisor")
	public ModelAndView telaRevisor() {
		return new ModelAndView("revisor.html");
	}

	@RequestMapping("/organizador")
	public ModelAndView telaOrganizador() {
		return new ModelAndView("organizador.html");
	}

	@RequestMapping("/autor")
	public ModelAndView Autor() {
		return new ModelAndView("autor.html");
	}
}