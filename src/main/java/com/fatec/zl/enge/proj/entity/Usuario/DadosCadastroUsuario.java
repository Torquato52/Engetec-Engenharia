package com.fatec.zl.enge.proj.entity.Usuario;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(@NotBlank String nome, 
        String email, String senha, 
        @Nullable String instituicao, String tipo) {
    
}