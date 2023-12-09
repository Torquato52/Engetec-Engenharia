package com.fatec.zl.enge.proj.entity.Area;

import jakarta.validation.constraints.NotNull;

public record CadastroArea(
        @NotNull
        Long id,
        String descricao) {

    
}
