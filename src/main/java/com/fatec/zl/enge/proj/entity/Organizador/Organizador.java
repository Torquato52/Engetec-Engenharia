package com.fatec.zl.enge.proj.entity.Organizador;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "organizador")
@Entity (name = "organizador")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Organizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="nome")
    private String nome;
    
    @Column(name ="email")
    private String email;

    @Column(name ="fone")
    private String fone;

    @Column(name ="ativo")
    private Boolean ativo;

    public Organizador(){

    }
    
    // public Organizador(CadastroOrganizador dadosOrg){
    //     this.nome = dadosOrg.nome();
    //     this.email = dadosOrg.email();
    //     this.fone = dadosOrg.fone();
    //     this.ativo = dadosOrg.ativo();
    // }
}
