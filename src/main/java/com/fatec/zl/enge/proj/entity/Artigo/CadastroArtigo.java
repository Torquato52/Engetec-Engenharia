package com.fatec.zl.enge.proj.entity.Artigo;

import jakarta.validation.constraints.NotBlank;

public record CadastroArtigo(@NotBlank String titulo, 
            String resumo, String tag1, 
            String tag2,  String tag3) {
    
}
