package com.fatec.zl.enge.proj.entity.Artigo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtigoRepository extends JpaRepository <Artigo, Long> {

    
}
