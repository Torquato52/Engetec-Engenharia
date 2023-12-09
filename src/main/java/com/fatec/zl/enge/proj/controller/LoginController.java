package com.fatec.zl.enge.proj.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatec.zl.enge.proj.entity.Usuario.Usuario;
import com.fatec.zl.enge.proj.entity.Usuario.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HttpSession session;

    public String login(String email, String senha, HttpSession session) {
        Optional<Usuario> usuario = usuarioRepository.Email(email);
        
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            String tipo = usuario.get().getTipo();
            switch (tipo) {
                case "Organizador":
                    session.setAttribute("tipoLogin", usuario);
                    return "redirect:/organizador";
                case "Usuario":
                    session.setAttribute("tipoLogin", usuario);
                    return "redirect:/autor";
                case "Revisor":
                    session.setAttribute("tipoLogin", usuario);
                    return "redirect:/revisor";
                default:
                    return "redirect:/login?error=true";
            }
        } else {
            return "redirect:/login?error=true";
        }
    }

    @RequestMapping("/logout")
	public String logout() {
        session.removeAttribute("tipoLogin");
		return "redirect:/";
    }
}