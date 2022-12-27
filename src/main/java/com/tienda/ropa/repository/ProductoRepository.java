package com.tienda.ropa.repository;

import com.tienda.ropa.entities.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
    @Query("SELECT p FROM Producto p WHERE p.genero_producto = 2")
    public List<Producto> buscarProductosMujer();
    
    @Query("SELECT p FROM Producto p WHERE p.genero_producto = 1")
    public List<Producto> buscarProductosHombre();
    
    @Query("SELECT p FROM Producto p WHERE p.genero_producto = 3 OR p.genero_producto = 4")
    public List<Producto> buscarProductosKids();
    
    @Query("SELECT p FROM Producto p WHERE p.genero_producto = 1 AND p.modelo_producto = 1")
    public List<Producto> buscarPantalonesHombre();
}
