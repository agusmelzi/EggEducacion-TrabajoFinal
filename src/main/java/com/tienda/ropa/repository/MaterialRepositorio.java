package com.tienda.ropa.repository;

import com.tienda.ropa.entities.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepositorio extends CrudRepository<Material, Long> {
    
}
