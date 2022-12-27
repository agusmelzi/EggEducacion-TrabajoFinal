package com.tienda.ropa.service;


import com.tienda.ropa.entities.Producto;
import java.util.List;

public interface ProductoService {
    
    public List<Producto> listarProuctos();
    
    public List<Producto> listarProuctosMujer();
    
    public List<Producto> listarProuctosHombre();
    
    public List<Producto> listarPantalonesHombre();
    
    public List<Producto> listarProuctosKids();
    
    public void guardar(Producto producto);
    
    public void eliminar(Producto producto);
    
    public Producto encontrarProducto(Producto producto);
    
}
