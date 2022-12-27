package com.tienda.ropa.repository;

import com.tienda.ropa.entities.Estados;
import org.springframework.data.repository.CrudRepository;

public interface EstadoRepositorio extends CrudRepository<Estados, Long> {
    
}
