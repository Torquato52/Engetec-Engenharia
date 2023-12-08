package com.fatec.zl.enge.proj.entity.Area;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "area")
@Entity (name = "Area")
@Getter
@Setter
public class Area {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="area_id")
	private Long id;
	private String descricao;
	
	public Area(Long id) {
		this.id = id;
	}

    
	public Area (CadastroArea dados) {
		this.descricao = dados.descricao();	
	}
}