package com.example.meusgastos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastos.domain.model.CentroDeCusto;
import com.example.meusgastos.domain.model.Usuario;

import java.util.List;


public interface CentroDeCustoRepository  extends 
JpaRepository<CentroDeCusto, Long>{
    List<CentroDeCusto> findByUsuario(Usuario usuario);
}
