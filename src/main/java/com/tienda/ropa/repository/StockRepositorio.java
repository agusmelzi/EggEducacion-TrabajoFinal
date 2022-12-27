package com.tienda.ropa.repository;

import com.tienda.ropa.entities.Stock;
import java.awt.print.Pageable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepositorio extends CrudRepository<Stock, Long> {

    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = :id) GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarPorGenero(@Param ("id") Long id);
    
    @Query(value = "SELECT * FROM stock ORDER BY producto_id_producto, talle_producto_id_talle, color_producto_id_color", nativeQuery = true)
    public List<Stock> listarTodo();
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 1 AND p.modelo_producto_id_modelo = :idModelo) GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarModelosHombres(@Param ("idModelo") Long idModelo);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 2 AND p.modelo_producto_id_modelo = :idModelo) GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarModelosMujeres(@Param ("idModelo") Long idModelo);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 3 AND p.modelo_producto_id_modelo = :idModelo) GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarModelosKids(@Param ("idModelo") Long idModelo);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 1) WHERE talle_producto_id_talle = :idTalle GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarTallesHombres(@Param ("idTalle") Long idTalle);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 2) WHERE talle_producto_id_talle = :idTalle GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarTallesMujeres(@Param ("idTalle") Long idTalle);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 3) WHERE talle_producto_id_talle = :idTalle GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarTallesKids(@Param ("idTalle") Long idTalle);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 1) WHERE marca_producto_id_marca = :idMarca GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarMarcasHombres(@Param ("idMarca") Long idMarca);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 2) WHERE marca_producto_id_marca = :idMarca GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarMarcasMujeres(@Param ("idMarca") Long idMarca);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 3) WHERE marca_producto_id_marca = :idMarca GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarMarcasKids(@Param ("idMarca") Long idMarca);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 1) WHERE color_producto_id_color = :idColor GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarColoresHombres(@Param ("idColor") Long idColor);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 2) WHERE color_producto_id_color = :idColor GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarColoresMujeres(@Param ("idColor") Long idColor);
    
    @Query(value = "SELECT stock.* FROM stock INNER JOIN producto p ON (stock.producto_id_producto = p.id_producto AND p.genero_producto_id_genero = 3) WHERE color_producto_id_color = :idColor GROUP BY producto_id_producto", nativeQuery = true)
    public List<Stock> buscarColoresKids(@Param ("idColor") Long idColor);

}
