package com.fatec.zl.enge.proj.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.zl.enge.proj.entity.Usuario;
import com.fatec.zl.enge.proj.repository.usuarioRepository;

@Service
public class VerificaLogin {
    @Autowired
    private usuarioRepository usuarioRepository;

    public String login(String email, String senha) {
        Optional<Usuario> usuario = usuarioRepository.Email(email);

        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            if (usuario.get().getTipo().equals("Organizador")) {
                return "redirect:/organizador";
            } else if (usuario.get().getTipo().equals("Professor")) {
                return "redirect:/professor";
            } else {
                return "redirect:/login?error=true";
            }
        } else {
            return "redirect:/login?error=true";
        }
    }
}
