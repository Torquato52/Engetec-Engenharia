package com.fatec.zl.enge.proj.entity;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuario(@NotBlank String nome, String email, String senha, String tipo) {
    
}
