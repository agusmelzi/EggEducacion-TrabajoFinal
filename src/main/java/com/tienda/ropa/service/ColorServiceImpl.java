package com.tienda.ropa.service;

import com.tienda.ropa.entities.Colores;
import com.tienda.ropa.repository.ColorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService{
    
    @Autowired
    private ColorRepositorio repo;
    
    @Override
    public List<Colores> listarColores() {
        return (List<Colores>) repo.findAll();
    }

    @Override
    public void guardar(Colores color) {
        repo.save(color);
    }

    @Override
    public void eliminar(Colores color) {
        repo.delete(color);
    }

    @Override
    public Colores encontrarColores(Colores color) {
        return repo.findById(color.getIdColor()).orElse(null);
    }
}
