package com.tienda.ropa.service;


import com.tienda.ropa.entities.Producto;
import com.tienda.ropa.repository.ProductoRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repo;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProuctos() {
        return (List<Producto>) repo.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProuctosMujer() {
        return (List<Producto>) repo.buscarProductosMujer();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProuctosHombre() {
        return (List<Producto>) repo.buscarProductosHombre();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarPantalonesHombre() {
        return (List<Producto>) repo.buscarPantalonesHombre();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProuctosKids() {
        return (List<Producto>) repo.buscarProductosKids();
    }
    
    @Override
    @Transactional
    public void guardar(Producto producto) {
        repo.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Producto producto) {
        repo.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Producto producto) {
        return repo.findById(producto.getIdProducto()).orElse(null);
    }
    
}
