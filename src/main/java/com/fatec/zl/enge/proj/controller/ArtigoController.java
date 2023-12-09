package com.fatec.zl.enge.proj.controller;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.zl.enge.proj.entity.Artigo.Artigo;
import com.fatec.zl.enge.proj.entity.Artigo.ArtigoRepository;
import com.fatec.zl.enge.proj.entity.Artigo.DadosCadastroArtigo;
import com.fatec.zl.enge.proj.entity.Usuario.Usuario;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
public class ArtigoController {
    
	@Autowired
    private ArtigoRepository artigoRepository;

	@RequestMapping("/artigo")
    public ModelAndView CadasArtigo() {
		return new ModelAndView("cadastroArtigo.html");
	}

	@PostMapping("/cadastroArtigo")
	@Transactional
	public String cadastrarArtig(@Valid DadosCadastroArtigo dadoArtigo, HttpSession session) {
		Optional<Usuario> user = (Optional<Usuario>) session.getAttribute("tipoLogin");
		Artigo art = new Artigo(dadoArtigo);
		
		art.setFk_id(user.get());
		artigoRepository.save(art);
		return "redirect:/artigo"; 
	}

    @GetMapping("/listarArtigos")
    public String listarArtigos(Model model) {
        List<Artigo> artigos = artigoRepository.findAll();
        model.addAttribute("artigos", artigos);
        return "listagem/listagemArtigos";
    }
}