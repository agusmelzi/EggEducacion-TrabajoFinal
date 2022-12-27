package com.tienda.ropa.usuario.repositorios;

import com.tienda.ropa.usuario.Identificacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IdentificacionRepositorio extends JpaRepository <Identificacion, Long>{
    
}
