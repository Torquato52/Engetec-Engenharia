package com.fatec.zl.enge.proj.entity.Usuario;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> Email(String email);

    void save(DadosCadastroUsuario das);
}