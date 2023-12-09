package com.fatec.zl.enge.proj.entity.Area;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AreaRepository extends JpaRepository <Area, Long>{
    List<Area> findAll();
}