package com.fatec.zl.enge.proj.entity.Usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(@NotBlank String nome, String email, String senha, String tipo) {
    
}
