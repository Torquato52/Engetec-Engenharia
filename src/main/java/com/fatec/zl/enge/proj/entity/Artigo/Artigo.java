package com.fatec.zl.enge.proj.entity.Artigo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.zl.enge.proj.entity.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "artigo")
@Entity
@Getter
@Setter
public class Artigo {
    @Autowired
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String resumo;
    private String tag1;
    private String tag2;
    private String tag3;
    private LocalDate dataSubmissao;

    @ManyToOne
    @JoinColumn()
    private Usuario fk_id;

    public Artigo (DadosCadastroArtigo dadosSub){
        this.titulo = dadosSub.titulo();
        this.resumo = dadosSub.resumo();
        this.tag1 = dadosSub.tag1();
        this.tag2 = dadosSub.tag2();
        this.tag3 = dadosSub.tag3();
        this.dataSubmissao = LocalDate.now();
    }
}