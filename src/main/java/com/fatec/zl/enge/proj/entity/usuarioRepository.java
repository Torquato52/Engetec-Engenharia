package com.fatec.zl.enge.proj.entity;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> Email(String email);
}