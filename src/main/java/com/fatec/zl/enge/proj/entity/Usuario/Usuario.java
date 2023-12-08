package com.fatec.zl.enge.proj.entity.Usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usuario")
@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String senha;
    private String instituicao;
    private String tipo;

    public Usuario(){
        
    }
    
    public Usuario (DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.instituicao = dados.instituicao();
        this.tipo = dados.tipo() == null ? "Usuario" : dados.tipo();
    }
}