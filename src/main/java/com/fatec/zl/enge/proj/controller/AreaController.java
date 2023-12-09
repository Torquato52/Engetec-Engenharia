package com.fatec.zl.enge.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.zl.enge.proj.entity.Area.Area;
import com.fatec.zl.enge.proj.entity.Area.AreaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
public class AreaController {

    @Autowired
	private AreaRepository repository;
     @RequestMapping("/area")
    public ModelAndView CadastroArea() {
		return new ModelAndView("cadastroArea.html");
	}

    @PostMapping("/cadastrarArea")
	@Transactional
	public String cadastra(@Valid Area dadosArea) {
        repository.save(dadosArea);
		return "redirect:/area"; 
	}
}
