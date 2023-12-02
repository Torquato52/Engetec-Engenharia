package com.fatec.zl.enge.proj.entity.Usuario;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usuario")
@Entity (name = "usuario")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="nome")
    private String nome;
    
    @Column(name ="email")
    private String email;

    @Column(name ="senha")
    private String senha;

    @Column(name ="tipo")
    private String tipo;

    public Usuario(){

    }
    
    public Usuario (DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.tipo = dados.tipo();
    }
}